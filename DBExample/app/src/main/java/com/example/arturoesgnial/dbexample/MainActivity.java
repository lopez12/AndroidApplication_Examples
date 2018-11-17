package com.example.arturoesgnial.dbexample;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    itemAdapter ItemAdapter;
    Context thisContext;
    ListView myListView;
    TextView progressTextView;
    Map<String,Double> Mapa = new LinkedHashMap<String, Double>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        myListView = (ListView) findViewById(R.id.dbListView);
        progressTextView = (TextView) findViewById(R.id.progressTxt);
        thisContext = this;

        progressTextView.setText("");

        Button btn = (Button) findViewById(R.id.getDataBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetData retriveData = new GetData();
                retriveData.execute("");
            }
        });


        //File-> New Model -> import
        //compile project(':mysql-connector-java-3.0.17-ga-bin')
        //Manifest Internet
        //Build
        //Crear clase
        //Crear Layout
        //Crear itemlayout
        //Agregar Margen android:layout_marginBottom="24dp"
        //Inlfator (Item Adapter -> BaseAdapter)
        //Map y List
    }

    private class GetData extends AsyncTask<String,String,String>
    {
        String msg;
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String DB_URL = "jdbc:mysql://" +
                DBStrings.DATABASE_URL + "/" +
                DBStrings.DATABASE_NAME;

        protected void onPreExecute()
        {
            progressTextView.setText("Connecting to database...");
        }

        @Override
        protected String doInBackground(String... strings) {

            Connection conn = null;
            Statement stmt = null;

            try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL,DBStrings.USERNAME,DBStrings.PASSWORD);
                stmt = conn.createStatement();
                String sql = "SELECT * FROM objects";

                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next())
                {
                    String name = rs.getString("name");
                    double price = rs.getDouble("price");

                    Mapa.put(name,price);
                }
                msg = "Process complete";
                rs.close();
                stmt.close();
                conn.close();

            }catch (SQLException connError)
            {
                msg = "An exception was thrown for JDBC";
                connError.printStackTrace();
            } catch (ClassNotFoundException e) {
                msg = "An Class not found exception was thrown";
                e.printStackTrace();
            }
            finally {
               try
               {
                   if (stmt != null)
                   {
                       stmt.close();
                   }
               } catch (SQLException e) {
                   e.printStackTrace();
               }

                try
                {
                    if (conn != null)
                    {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(String msg)
        {
            progressTextView.setText(this.msg);

            if(Mapa.size() > 0)
            {
                ItemAdapter = new itemAdapter(thisContext,Mapa);
                myListView.setAdapter(ItemAdapter);
            }
        }
    }
}
