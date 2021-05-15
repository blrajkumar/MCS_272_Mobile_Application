package com.example.christkp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class home_Activity extends AppCompatActivity {

    private ImageView stud;
    private TextView head;
    private TextView name;
    private TextView room;
    private TextView type;
    private TextView phone;
    private View actii;
    private EditText ph_edit;
    private TextView ph_text;

    private androidx.appcompat.view.ActionMode mActionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);

        stud = findViewById(R.id.prof_image);
        head = findViewById(R.id.head);
        name = findViewById(R.id.prof_name);
        room = findViewById(R.id.prof_room);
        type = findViewById(R.id.type);
        phone = findViewById(R.id.phone);
        actii = findViewById(R.id.acti);
        ph_edit=(EditText)findViewById(R.id.phedit);
        ph_text=(TextView)findViewById(R.id.phone);

        ph_text.setVisibility(View.VISIBLE);
        ph_edit.setVisibility(View.GONE);
        registerForContextMenu(stud);
        TextView phone = findViewById(R.id.phone);
        phone.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (mActionMode != null) {
                    return false;
                }
                mActionMode = home_Activity.this.startSupportActionMode(new androidx.appcompat.view.ActionMode.Callback() {
                    @Override
                    public boolean onCreateActionMode(androidx.appcompat.view.ActionMode mode, Menu menu) {
                        mode.getMenuInflater().inflate(R.menu.contextual_action, menu);
                        return true;
                    }

                    @Override
                    public boolean onPrepareActionMode(androidx.appcompat.view.ActionMode mode, Menu menu) {
                        return false;
                    }

                    @Override
                    public boolean onActionItemClicked(androidx.appcompat.view.ActionMode mode, MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.edit:
                                ph_text.setVisibility(View.GONE);
                                ph_edit.setVisibility(View.VISIBLE);
                                ph_edit.setText(ph_text.getText());
                                return true;
                            case R.id.share:
                                Toast.makeText(home_Activity.this, "Option 2 selected", Toast.LENGTH_SHORT).show();
                                mode.finish();
                                return true;
                            default:
                                return false;
                        }
                    }

                    @Override
                    public void onDestroyActionMode(androidx.appcompat.view.ActionMode mode) {
                        finish_edit();
                        mActionMode = null;
                    }
                });
                view.setSelected(true);
                return true;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.view_item:
                showPopup();
                return true;
            case R.id.share_item:
                Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.settings_item:
                View menuItemView = findViewById(R.id.settings_item);

                //showPopup();
                return true;
            case R.id.help_item:
                Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.logout_item:
                home_Activity.this.finish();
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void showPopup(){
        View menuItemView = findViewById(R.id.view_item);
        PopupMenu popup = new PopupMenu(home_Activity.this, menuItemView);
        MenuInflater inflate = popup.getMenuInflater();
        inflate.inflate(R.menu.popup_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.dark:
                        dark();
                        return true;
                    case R.id.light:
                        light();
                        return true;
                    default:
                        return false;
                }
            }
        });
        popup.show();
    }

    public void dark()
    {
        actii.setBackgroundColor(getResources().getColor(android.R.color.black));
        name.setBackgroundColor(getResources().getColor(android.R.color.black));
        name.setTextColor(getResources().getColor(android.R.color.white));
        room.setBackgroundColor(getResources().getColor(android.R.color.black));
        room.setTextColor(getResources().getColor(android.R.color.white));
        type.setBackgroundColor(getResources().getColor(android.R.color.black));
        type.setTextColor(getResources().getColor(android.R.color.white));
        phone.setBackgroundColor(getResources().getColor(android.R.color.black));
        phone.setTextColor(getResources().getColor(android.R.color.white));
        head.setBackgroundColor(getResources().getColor(android.R.color.black));
        head.setTextColor(getResources().getColor(android.R.color.white));

    }

    public void light()
    {
        actii.setBackgroundColor(getResources().getColor(android.R.color.white));
        room.setBackgroundColor(getResources().getColor(android.R.color.white));
        room.setTextColor(getResources().getColor(android.R.color.black));
        name.setBackgroundColor(getResources().getColor(android.R.color.white));
        name.setTextColor(getResources().getColor(android.R.color.black));
        type.setBackgroundColor(getResources().getColor(android.R.color.white));
        type.setTextColor(getResources().getColor(android.R.color.black));
        phone.setBackgroundColor(getResources().getColor(android.R.color.white));
        phone.setTextColor(getResources().getColor(android.R.color.black));
        head.setBackgroundColor(getResources().getColor(android.R.color.white));
        head.setTextColor(getResources().getColor(android.R.color.black));
    }

    public void edit_phone()
    {
        ph_text.setVisibility(View.GONE);
        ph_edit.setVisibility(View.VISIBLE);
        ph_edit.setText(ph_text.getText());
    }

    public void finish_edit()
    {
        ph_text.setText(ph_edit.getText());
        ph_text.setVisibility(View.VISIBLE);
        ph_edit.setVisibility(View.GONE);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.contextual, menu);
        menu.setHeaderTitle("Select The Action");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getItemId()==R.id.context_edit){
            Toast.makeText(getApplicationContext(),"Edit",Toast.LENGTH_LONG).show();
        }
        else if(item.getItemId()==R.id.context_save){
            Toast.makeText(getApplicationContext(),"Save Picture",Toast.LENGTH_LONG).show();
        }else{
            return false;
        }
        return true;
    }
}