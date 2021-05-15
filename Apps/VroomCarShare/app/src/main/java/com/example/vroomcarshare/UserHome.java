package com.example.vroomcarshare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UserHome extends AppCompatActivity {

    TextView sname;
    TextView sid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        sname = (TextView) findViewById(R.id.sname);
        sid = (TextView) findViewById(R.id.sid);
    }

    public void strt(View v)
    {
        Intent intent=new Intent(UserHome.this, SelectCourse.class);
        startActivity(intent);
    }
}