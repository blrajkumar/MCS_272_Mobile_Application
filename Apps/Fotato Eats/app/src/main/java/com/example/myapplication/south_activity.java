package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class south_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_north_activity);
    }

    public void click_idli(View v)
    {
        Intent j1 = new Intent(getBaseContext(),south_activity.class);
        j1.putExtra("Value","idli");
        startActivity(j1);
        finish();
    }

    public void click_dosa(View v)
    {
        Intent j1 = new Intent(getBaseContext(),south_activity.class);
        j1.putExtra("Value","dosa");
        startActivity(j1);
        finish();
    }

    public void click_puri(View v)
    {
        Intent j1 = new Intent(getBaseContext(),south_activity.class);
        j1.putExtra("Value","puri");
        startActivity(j1);
        finish();
    }

    public void click_paniyaram(View v)
    {
        Intent j1 = new Intent(getBaseContext(),south_activity.class);
        j1.putExtra("Value","paniyaram");
        startActivity(j1);
        finish();
    }

    public void click_puttu(View v)
    {
        Intent j1 = new Intent(getBaseContext(),south_activity.class);
        j1.putExtra("Value","puttu");
        startActivity(j1);
        finish();
    }

    public void click_pongal(View v)
    {
        Intent j1 = new Intent(getBaseContext(),south_activity.class);
        j1.putExtra("Value","pongal");
        startActivity(j1);
        finish();
    }
}