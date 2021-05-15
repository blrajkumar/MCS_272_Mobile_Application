package com.example.eco_rrr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class buy_items extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_items);
    }
    public void book_button(View v)
    {
        Toast.makeText(getApplicationContext(),"Activity under maintanance", Toast.LENGTH_SHORT).show();
    }

    public void gadjet_button(View v)
    {
        Intent i1 = new Intent(getBaseContext(), buy_gadget.class);
        startActivity(i1);
        finish();
    }
}