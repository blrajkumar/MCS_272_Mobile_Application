package com.example.raj2047120;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText user;
    private EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.pass);
    }

    public void login_button(View v)
    {
        String userval = user.getText().toString();
        String passval = pass.getText().toString();
        if( (userval.equals("Admin")) && (passval.equals("Raj1234")))
        {
            Intent i1 = new Intent(getBaseContext(),MainActivity2.class);
            i1.putExtra("Value",userval);
            startActivity(i1);
            finish();

        }
        else
        {
            Toast toast = Toast.makeText(this, "Invalid Credintials", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}