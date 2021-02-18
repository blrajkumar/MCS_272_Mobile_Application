package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class southMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_south_menu);
    }

    public void click_idli(View v)
    {
        Intent j1 = new Intent(getBaseContext(),foodActivity.class);
        j1.putExtra("Value","idli");
        startActivity(j1);
        finish();
    }

    public void click_dosa(View v)
    {
        Intent j1 = new Intent(getBaseContext(),foodActivity.class);
        j1.putExtra("Value","dosa");
        startActivity(j1);
        finish();
    }

    public void click_puri(View v)
    {
        Intent j1 = new Intent(getBaseContext(),foodActivity.class);
        j1.putExtra("Value","puri");
        startActivity(j1);
        finish();
    }

    public void click_paniyaram(View v)
    {
        Intent j1 = new Intent(getBaseContext(),foodActivity.class);
        j1.putExtra("Value","paniyaram");
        startActivity(j1);
        finish();
    }

    public void click_puttu(View v)
    {
        Intent j1 = new Intent(getBaseContext(),foodActivity.class);
        j1.putExtra("Value","puttu");
        startActivity(j1);
        finish();
    }

    public void click_pongal(View v)
    {
        Intent j1 = new Intent(getBaseContext(),foodActivity.class);
        j1.putExtra("Value","pongal");
        startActivity(j1);
        finish();
    }
    public void float_button(View v)
    {
        Intent l1 = new Intent(getBaseContext(), cartActivity.class);
        startActivity(l1);
        finish();
    }

    public void back_button(View v)
    {
        Intent l1 = new Intent(getBaseContext(), MainActivity2.class);
        startActivity(l1);
        finish();
    }
}