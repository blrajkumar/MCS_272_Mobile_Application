package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    EditText fname;
    EditText lname;
    EditText email;
    EditText phone;
    EditText clg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        fname = (EditText) findViewById(R.id.fname);
        lname = (EditText) findViewById(R.id.lname);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        clg = (EditText) findViewById(R.id.college);
    }

    public void submit_btn (View v)
    {

    }

    public void clear_btn (View v)
    {
        fname.setText("");
        lname.setText("");
        email.setText("");
        phone.setText("");
        clg.setText("");
    }
}