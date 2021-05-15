package com.example.vroomcarshare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Report extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
    }

    public void logt(View v)
    {
        Intent main = new Intent(Report.this, Login.class);
        startActivity(main);
        finish();
    }

    public void dashbrd(View v)
    {
        Intent main = new Intent(Report.this, SelectCourse.class);
        startActivity(main);
        finish();
    }
}