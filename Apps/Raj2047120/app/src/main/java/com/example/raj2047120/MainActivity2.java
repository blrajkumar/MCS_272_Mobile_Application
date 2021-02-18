 package com.example.raj2047120;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

 public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

     public void click_chan(View v)
     {
         Intent j1 = new Intent(getBaseContext(),MainActivity3.class);
         j1.putExtra("Value","chan");
         startActivity(j1);
         finish();
     }

     public void click_chui(View v)
     {
         Intent j2 = new Intent(getBaseContext(),MainActivity3.class);
         j2.putExtra("Value","chui");
         startActivity(j2);
         finish();
     }

     public void click_hari(View v)
     {
         Intent j3 = new Intent(getBaseContext(),MainActivity3.class);
         j3.putExtra("Value","hari");
         startActivity(j3);
         finish();
     }

     public void click_raj(View v)
     {
         Intent j4 = new Intent(getBaseContext(),MainActivity3.class);
         j4.putExtra("Value","raj");
         startActivity(j4);
         finish();
     }

     public void click_shivam(View v)
     {
         Intent j5 = new Intent(getBaseContext(),MainActivity3.class);
         j5.putExtra("Value","shivam");
         startActivity(j5);
         finish();
     }

     public void click_sonali(View v)
     {
         Intent j6 = new Intent(getBaseContext(),MainActivity3.class);
         j6.putExtra("Value","sonali");
         startActivity(j6);
         finish();
     }
}