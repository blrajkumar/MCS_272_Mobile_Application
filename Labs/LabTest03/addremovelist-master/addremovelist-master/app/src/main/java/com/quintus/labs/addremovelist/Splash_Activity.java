package com.quintus.labs.addremovelist;



import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class Splash_Activity extends AppCompatActivity {
    private static int spt = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent main = new Intent(Splash_Activity.this, Welcome.class);
                startActivity(main);
                finish();
            }
        },spt);
    }
}