package com.example.labtest02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {

    private EditText user;
    private EditText pass;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        drawerLayout = findViewById(R.id.drawer_layout);
        user = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.pass);
    }

    public void ClickMore(View view)
    {
        View menuItemView = findViewById(R.id.more);
        PopupMenu popup = new PopupMenu(AdminLogin.this, menuItemView);
        MenuInflater inflate = popup.getMenuInflater();
        inflate.inflate(R.menu.popup_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.settings_item:
                        return true;
                    case R.id.help_item:
                        return true;
                    default:
                        return false;
                }
            }
        });
        popup.show();
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
        MainActivity.redirectActvity(this,Test.class);
    }

    public void ClickSlot(View view) { recreate(); }

    public void ClickLogout(View view)
    {
        MainActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.closeDrawer(drawerLayout);
    }


    public void login_button(View v)
    {
        String userval = user.getText().toString();
        String passval = pass.getText().toString();
        if( (userval.equals("Admin")) && (passval.equals("Admin1234")))
        {
            Intent i1 = new Intent(getBaseContext(),AdminHome.class);
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