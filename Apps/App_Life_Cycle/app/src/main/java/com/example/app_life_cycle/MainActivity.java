package com.example.app_life_cycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Activity_Lifecycle","Welcome_onCreate_Invoked");
        Toast.makeText(MainActivity.this, "Welcome_Activity Created",Toast.LENGTH_SHORT).show();
    }

    public void start_button(View v)
    {
            Intent i1 = new Intent(getBaseContext(),MainActivity2.class);
            startActivity(i1);
            finish();
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d("Activity_Lifecycle","Welcome_onStart_Invoked");
        Toast.makeText(MainActivity.this, "Welcome_Activity Started",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.d("Activity_Lifecycle","Welcome_onResume_Invoked");
        Toast.makeText(MainActivity.this, "Welcome_Activity Resumed",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d("Activity_Lifecycle","Welcome_onPause_Invoked");
        Toast.makeText(MainActivity.this, "Welcome_Activity Paused",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d("Activity_Lifecycle","Welcome_onStop_Invoked");
        Toast.makeText(MainActivity.this, "Welcome_Activity Stopped",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.d("Activity_Lifecycle","Welcome_onRestart_Invoked");
        Toast.makeText(MainActivity.this, "Welcome_Activity Restarted",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d("Activity_Lifecycle","Welcome_onDestroy_Invoked");
        Toast.makeText(MainActivity.this, "Welcome_Activity Destroyed",Toast.LENGTH_SHORT).show();
    }
}