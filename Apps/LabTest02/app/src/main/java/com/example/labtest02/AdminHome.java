package com.example.labtest02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.PopupMenu;

public class AdminHome extends AppCompatActivity {

    private EditText slot;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        drawerLayout = findViewById(R.id.drawer_layout);
        slot = (EditText)findViewById(R.id.slot);
    }

    public void ClickMore(View view)
    {
        View menuItemView = findViewById(R.id.more);
        PopupMenu popup = new PopupMenu(AdminHome.this, menuItemView);
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

    public void onAdd(View view)
    {
        Dates.insert_slot(this.getApplicationContext()
                ,slot.getText().toString());
        //Toast toast = Toast.makeText(this, "Slot has been added", Toast.LENGTH_SHORT);
        //toast.show();
    }
}