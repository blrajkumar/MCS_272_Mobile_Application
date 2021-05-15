package com.example.vroomcarshare;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.Statement;

public class Register extends AppCompatActivity {

    EditText fname, lname, email, phnumber, university;
    Button register;
    ProgressDialog progressDialog;
    ConnectionClass connectionClass;
    SharedPreferences sharedpreferences;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        fname= (EditText) findViewById(R.id.fname);
        lname= (EditText) findViewById(R.id.lname);
        email= (EditText) findViewById(R.id.email);
        phnumber= (EditText) findViewById(R.id.phnumber);
        university = (EditText) findViewById(R.id.street);
        register= (Button) findViewById(R.id.register);

        connectionClass = new ConnectionClass();
        progressDialog=new ProgressDialog(this);

        sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);

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


        String fnamestr=fname.getText().toString();
        String lnamestr=lname.getText().toString();
        String emailstr=email.getText().toString();
        String phnumberstr=phnumber.getText().toString();
        String universitystr = university.getText().toString();

        String z="";
        boolean isSuccess=false;

        @Override
        protected void onPreExecute() {
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {

            if(fnamestr.trim().equals("")
                    || lnamestr.trim().equals("")
                    || emailstr.trim().equals("")
                    || phnumberstr.trim().equals("")
                    || universitystr.trim().equals("") )
                z = "Please enter all fields....";
            else
            {
                try {
                    Connection con = connectionClass.CONN();
                    if (con == null) {
                        z = "Please check your internet connection";
                    } else {
                        String query="insert into student values('2047120','"+fnamestr+"','"+lnamestr+"','"+emailstr+"','"+phnumberstr+"', '"+ universitystr +"')";
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(query);

                        z = "Register successfull";
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
                builder.setMessage("Username : "+fnamestr+"\nPassword : "+fnamestr+phnumberstr);
                builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(Register.this, Login.class));
                    }
                });
                builder.show();
            }
            progressDialog.hide();
        }
    }


    private class Dologin extends AsyncTask<String,String,String>{
        String namestr=fname.getText().toString();
        String emailstr=email.getText().toString();
        String passstr=lname.getText().toString();
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
                Intent intent=new Intent(Register.this, Login.class);
                intent.putExtra("name",namestr);
                startActivity(intent);
            }
            progressDialog.hide();

        }
    }


    public void savebtm(View v)
    {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPREFERENCES", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        // write all the data entered by the user in SharedPreference and apply
        myEdit.putString("fname", fname.getText().toString());
        myEdit.putString("lname", lname.getText().toString());
        myEdit.putString("email", email.getText().toString());
        myEdit.putString("phn", phnumber.getText().toString());
        myEdit.putString("university", university.getText().toString());

        myEdit.apply();
        Toast toast = Toast.makeText(getApplicationContext(),
                "Details are saved!",
                Toast.LENGTH_SHORT);

        toast.show();
    }

    public void clrbtn(View v)
    {
        fname.setText("");
        lname.setText("");
        email.setText("");
        phnumber.setText("");
        university.setText("");
        Toast toast = Toast.makeText(getApplicationContext(),
                "Form Cleared",
                Toast.LENGTH_SHORT);
        toast.show();
    }

//    protected void onResume() {
//        super.onResume();
//
//        // Fetching the stored data
//        // from the SharedPreference
//        SharedPreferences sh = getSharedPreferences("MyPREFERENCES", MODE_PRIVATE);
//
//        String s1 = sh.getString("fname", "");
//        String s2 = sh.getString("lname", "");
//        String s3 = sh.getString("email", "");
//        String s4 = sh.getString("phn", "");
//        String s5 = sh.getString("dob", "");
//        String s6 = sh.getString("dlnum", "");
//        String s7 = sh.getString("street", "");
//        String s8 = sh.getString("city", "");
//        String s9 = sh.getString("state", "");
//        String s10 = sh.getString("zip", "");
//
//
//        // Setting the fetched data
//        // in the EditTexts
//        fname.setText(s1);
//        lname.setText(s2);
//        email.setText(s3);
//        phnumber.setText(s4);
//        dob.setText(s5);
//        dlnumber.setText(s6);
//        street.setText(s7);
//        city.setText(s8);
//        state.setText(s9);
//        zipcode.setText(s10);
//    }

    public void ftchbtn(View v) {

        // Fetching the stored data
        // from the SharedPreference
        SharedPreferences sh = getSharedPreferences("MyPREFERENCES", MODE_PRIVATE);

        String s1 = sh.getString("fname", "");
        String s2 = sh.getString("lname", "");
        String s3 = sh.getString("email", "");
        String s4 = sh.getString("phn", "");
        String s5 = sh.getString("university", "");

        // Setting the fetched data
        // in the EditTexts
        fname.setText(s1);
        lname.setText(s2);
        email.setText(s3);
        phnumber.setText(s4);
        university.setText(s5);

        Toast toast = Toast.makeText(getApplicationContext(),
                "Data Retrieved Successfully!",
                Toast.LENGTH_SHORT);
        toast.show();
    }
}
