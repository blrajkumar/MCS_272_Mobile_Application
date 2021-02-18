package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void south_button(View v)
    {
        Intent i1 = new Intent(getBaseContext(), southMenu.class);
        startActivity(i1);
        finish();
    }

    public void north_button(View v){
        Toast.makeText(getApplicationContext(),"Activity under maintanance",Toast.LENGTH_SHORT).show();
    }

    public void float_button(View v)
    {
        Intent l1 = new Intent(getBaseContext(), cartActivity.class);
        startActivity(l1);
        finish();
    }
}