package com.example.eco_rrr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class BuySell extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_sell);
    }
    public void buy_button(View v)
    {
        Intent i1 = new Intent(getBaseContext(), buy_items.class);
        startActivity(i1);
        finish();
    }

    public void sell_button(View v){
        Toast.makeText(getApplicationContext(),"Activity under maintanance", Toast.LENGTH_SHORT).show();
    }
}