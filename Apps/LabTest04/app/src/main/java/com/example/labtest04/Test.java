package com.example.labtest04;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test extends AppCompatActivity {

    EditText match;
    Button register;
    ProgressDialog progressDialog;
    ConnectionClass connectionClass;
    int avail=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        match= (EditText) findViewById(R.id.mtch);
        register= (Button) findViewById(R.id.register);

        connectionClass = new ConnectionClass();
        progressDialog=new ProgressDialog(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Test.Doregister doregister = new Test.Doregister();
                doregister.execute("");
            }
        });
    }

    public class Doregister extends AsyncTask<String,String,String>
    {
        String mtchstr = match.getText().toString();

        String z="";
        boolean isSuccess=false;

        @Override
        protected void onPreExecute() {
            progressDialog.setMessage("Setting the match...");
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {

            if(mtchstr.trim().equals("") )
                z = "Please enter all fields....";
            else
            {
                try {
                    Connection con = connectionClass.CONN();
                    if (con == null) {
                        z = "Please check your internet connection";
                    } else {



                        String mtches="select *from matches";
                        ResultSet rsmtch=null;
                        Statement stmtmtch = con.createStatement();
                        rsmtch = stmtmtch.executeQuery(mtches);
                        while(rsmtch.next()) {
                            String name = rsmtch.getString("Name");
                            if(name.equals(match.getText().toString()))
                            {
                                String scrupd = "DELETE FROM matches WHERE Name=?";
                                PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(scrupd);
                                pstmt.setString(1, name);
                                int i = pstmt.executeUpdate();
                            }
                        }

                        String insmtch="INSERT INTO matches VALUES (?,?)";
                        PreparedStatement pdt = (PreparedStatement) con.prepareStatement(insmtch);
                        pdt.setString(1, match.getText().toString());
                        pdt.setInt(2, 0);
                        //put the rest of the code
                        int n1=pdt.executeUpdate();
                        DB_Support.setMtchName(match.getText().toString());

                        DB_Support.players.clear();
                        String query="select *from players where Available='"+avail+"'";
                        ResultSet rs=null;
                        Statement stmt = con.createStatement();
                        rs = stmt.executeQuery(query);
                        while(rs.next()) {
                            String name = rs.getString("Name");
                            DB_Support.addplayers(name);
                        }
                        z = "Match Setup successfull";
                        isSuccess=true;
                    }
                }
                catch (Exception ex)
                {
                    isSuccess = false;
                    z = "Exceptions"+ex;
                }
            }
            return z;
        }

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(getBaseContext(),""+z,Toast.LENGTH_LONG).show();
            startActivity(new Intent(Test.this,PlayerList.class));
            progressDialog.hide();
        }
    }


    private class Dologin extends AsyncTask<String,String,String>{
        String z="";
        boolean isSuccess=false;
        String nm,em,password;


        @Override
        protected void onPreExecute() {
            progressDialog.setMessage("Loading...");
            progressDialog.show();
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            return z;        }

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(getBaseContext(),""+z,Toast.LENGTH_LONG).show();


            if(isSuccess) {
                Intent intent=new Intent(Test.this,PlayerList.class);
                startActivity(intent);
            }
            progressDialog.hide();

        }
    }

    public void exit(View v)
    {
        System.exit(0);
    }
}
