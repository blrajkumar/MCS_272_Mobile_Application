package com.example.labtest02;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Test extends AppCompatActivity {

    DrawerLayout drawerLayout;
    private EditText name;
    private EditText phone;
    Spinner slot;
    private int healthid=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        drawerLayout = findViewById(R.id.drawer_layout);
        name = (EditText)findViewById(R.id.name);
        phone = (EditText)findViewById(R.id.phone);
        slot = (Spinner) findViewById(R.id.slot);

        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Dates.get_dates());
        slot.setAdapter(adapter);
    }

    public void ClickMenu(View view)
    {
        MainActivity.openDrawer(drawerLayout);
    }

    public void ClickLogo(View view)
    {
        MainActivity.closeDrawer(drawerLayout);
    }

    public void ClickHome(View view)
    {
        MainActivity.redirectActvity(this,MainActivity.class);
    }

    public void ClickBookTest(View view)
    {
        recreate();
    }

    public void ClickSlot(View view)
    {
        MainActivity.redirectActvity(this,AdminLogin.class);
    }

    public void ClickLogout(View view)
    {
        MainActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.closeDrawer(drawerLayout);
    }

    public void onSubmit(View view)
    {
        healthid = (int)(Math.random() * (2047300 - 2047100 + 1) + 2047100);
        String alrtmsg;
        alrtmsg = "Appointment ID: "+Integer.toString(healthid);
        alrtmsg = alrtmsg +  "\n" + "Name: " + name.getText().toString();
        alrtmsg = alrtmsg +  "\n" + "Phone: " + phone.getText().toString();
        alrtmsg = alrtmsg +  "\n" + "Slot: " + slot.getSelectedItem().toString();
        Dates.delete_slot(slot.getSelectedItem().toString());
        AlertDialog.Builder builder = new AlertDialog.Builder(Test.this);
        builder.setMessage(alrtmsg);
        builder.setTitle("Registration Confirmation !");
        builder.setCancelable(false);
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog,int which) {
                MainActivity.redirectActvity(Test.this,MainActivity.class);
                dialog.cancel();}});
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // If user click no // then dialog box is canceled.
                dialog.cancel(); }});
        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();
        // Show the Alert Dialog box
        alertDialog.show();
    }

}