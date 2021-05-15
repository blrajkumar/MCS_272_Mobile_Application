package com.example.app_life_cycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    private String messages[] = {
            "Love is flower-like.\n" +
            "Friendship is like a sheltering tree.",
            "You are loved.",

            "I may not be where I want to be,\n" +
                    "but I’m thankful for not being\n" +
                    "where I was.",

            "There are things in life that you can't\n" +
                    "control, and aren't supposed to.",
            "I’d never lived before your love.",

            "With you,\n" +
                    "I am home.",

            "You make it look easy.\n" +
                    "The fact is it's really\n" +
                    "hard and you do it anyway.",

            "Distractions will look like\n" +
                    "opportunities when you don't\n" +
                    "know where you are going.",

            "Two things you will\n" +
                    "never have to chase:\n" +
                    "True friends and true love.",

            "God will never give you\n" +
                    "anything you can't handle,\n" +
                    "so don't stress.",

            "Some things have to be\n" +
                    "believed to be seen.",

            "Believe something and the\n" +
                    "universe is on its way to\n" +
                    "being changed.",

            "Our words have power,\n" +
                    "but our actions shape our lives.",

            "Love yourself first and\n" +
                    "then everything falls into line.",

            "Authenticity is the daily\n" +
                    "practice of letting go of who\n" +
                    "we think we're supposed to be\n" +
                    "and embracing who we are.",

            "The only impossible journey\n" +
                    "is the one you never begin.",

            "Adjust, chill out, and be happy.",

            "Today you are you! That is truer\n" +
                    "than true! There is no one alive\n" +
                    "who is you-er than you!"
    };
    Random rand = new Random();
    Boolean start = true;
    private TextView main_disp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        main_disp = (TextView) findViewById(R.id.fort);
        Log.d("Activity_Lifecycle","Cookie_onCreate_Invoked");
        Toast.makeText(MainActivity2.this, "Cookie_Activity Created",Toast.LENGTH_SHORT).show();
    }

    public void generate(View v)
    {
        int rand_int1 = rand.nextInt(15);
        main_disp.setText(messages[rand_int1]);
    }

    public void destroy(View v)
    {
        finish();
        System.exit(0);
    }
    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d("Activity_Lifecycle","Cookiee_onStart_Invoked");
        Toast.makeText(MainActivity2.this, "Cookie_Activity Started",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d("Activity_Lifecycle","Cookie_onResume_Invoked");
        Toast.makeText(MainActivity2.this, "Cookiee_Activity Resumed",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d("Activity_Lifecycle","Cookie_onPause_Invoked");
        Toast.makeText(MainActivity2.this, "Cookiee_Activity Paused",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d("Activity_Lifecycle","Cookie_onStop_Invoked");
        Toast.makeText(MainActivity2.this, "Cookie_Activity Stopped",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.d("Activity_Lifecycle","Cookie_onRestart_Invoked");
        Toast.makeText(MainActivity2.this, "Cookie_Activity Restarted",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d("Activity_Lifecycle","Cookie_onDestroy_Invoked");
        Toast.makeText(MainActivity2.this, "Cookie_Activity Destroyed",Toast.LENGTH_SHORT).show();
    }
}
