package com.example.leadagio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void jazz(View v)
    {
        Intent main = new Intent(MainActivity.this, playSong.class);
        startActivity(main);
        finish();
    }
}