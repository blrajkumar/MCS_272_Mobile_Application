package com.quintus.labs.addremovelist;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Welcome extends AppCompatActivity {

    private EditText user;
    private EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        user = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.pass);
    }

    public void login_button(View v)
    {
        WifiManager wifi = (WifiManager)getSystemService(Context.WIFI_SERVICE);
        if (!wifi.isWifiEnabled()){
            AlertDialog.Builder builder = new AlertDialog.Builder(Welcome.this);
            builder.setTitle("Check The Internet Connection");
            builder.setMessage("Wifi is disabled !\nPlease turn on the wifi from the settings");
            builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    startActivity(new Intent(Welcome.this,Settings.class));
                }
            });
            builder.show();
        }
        else
        {
            String userval = user.getText().toString();
            String passval = pass.getText().toString();
            if( (userval.equals("Raj")) && (passval.equals("Raj1234")))
            {
                Intent i1 = new Intent(getBaseContext(),MainActivity.class);
                i1.putExtra("Value",userval);
                startActivity(i1);
                finish();

            }
            else
            {
                Toast toast = Toast.makeText(this, "Invalid Credintials", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

    public void register(View view)
    {
        WifiManager wifi = (WifiManager)getSystemService(Context.WIFI_SERVICE);
        if (!wifi.isWifiEnabled()){
            AlertDialog.Builder builder = new AlertDialog.Builder(Welcome.this);
            builder.setTitle("Check The Internet Connection");
            builder.setMessage("Wifi is disabled !\nPlease turn on the wifi from the settings");
            builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    startActivity(new Intent(Welcome.this,Settings.class));
                }
            });
            builder.show();
        }
        else
        {
            Intent main = new Intent(Welcome.this, Register.class);
            startActivity(main);
            finish();
        }
    }
}