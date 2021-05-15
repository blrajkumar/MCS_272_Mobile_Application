package com.quintus.labs.addremovelist;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Register extends AppCompatActivity {

    EditText zipcode;
    Button register;
    ProgressDialog progressDialog;
    ConnectionClass connectionClass;
    int avail=1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        zipcode= (EditText) findViewById(R.id.zipcode);
        register= (Button) findViewById(R.id.register);

        connectionClass = new ConnectionClass();
        progressDialog=new ProgressDialog(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register.Doregister doregister = new Register.Doregister();
                doregister.execute("");
            }
        });
    }

    public class Doregister extends AsyncTask<String,String,String>
    {
        String zipstr=zipcode.getText().toString();

        String z="";
        boolean isSuccess=false;

        @Override
        protected void onPreExecute() {
            progressDialog.setMessage("Searching nearby agents...");
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {

            if(zipstr.trim().equals("") )
                z = "Please enter all fields....";
            else
            {
                try {
                    Connection con = connectionClass.CONN();
                    if (con == null) {
                        z = "Please check your internet connection";
                    } else {
                        FreshCo.agent_names.clear();
                        String query="select *from agent where Available='"+avail+"'";
                        ResultSet rs=null;
                        Statement stmt = con.createStatement();
                        rs = stmt.executeQuery(query);
                        while(rs.next()) {
                            String name = rs.getString("Name");
                            FreshCo.addAgent_name(name);
                        }
                        z = "Agent Fetch successfull";
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
            if(isSuccess) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Register.this);
                builder.setTitle("Please make note of your login credentials");
                builder.setMessage("Zipcode : "+zipstr);
                builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(Register.this,MainActivity.class));
                    }
                });
                builder.show();
            }
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
                Intent intent=new Intent(Register.this,Welcome.class);
                startActivity(intent);
            }
            progressDialog.hide();

        }
    }
}
