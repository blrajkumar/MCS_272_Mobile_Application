package com.example.christ;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Attendance extends AppCompatActivity {

    DrawerLayout drawerLayout;
    EditText fromdate,todate;
    DatePickerDialog datePicker;
    DatePickerDialog.OnDateSetListener setListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        drawerLayout = findViewById(R.id.drawer_layout);
        fromdate = (EditText) findViewById(R.id.fromDate);
        todate = (EditText) findViewById(R.id.todate);

        Calendar calendar=Calendar.getInstance();
        int current_years=calendar.get(Calendar.YEAR);
        int current_month=calendar.get(Calendar.MONTH);
        int current_day=calendar.get(Calendar.DAY_OF_MONTH);
        fromdate.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v)
            {
                DatePickerDialog datePickerDialog =new DatePickerDialog (Attendance.this, new DatePickerDialog.OnDateSetListener()
                {
                    @Override public void onDateSet(DatePicker view, int year, int month, int day)
                    {
                        month=month+1;
                        String date=day+"/"+month+"/"+year;
                        if(day>current_day && (month==current_month && year==current_years))
                        {
                            Toast toast = Toast.makeText(getApplicationContext(),"Invalid Entry! Try Again :(", Toast.LENGTH_SHORT);
                            toast.show();
                            fromdate.setText("");
                        }
                        else if(month>(current_month+1))
                        {
                            Toast toast = Toast.makeText(getApplicationContext(),"Invalid Entry! Try Again :(", Toast.LENGTH_SHORT);
                            toast.show();
                            fromdate.setText("");
                        }
                        else if(year>(current_years+1))
                        {
                            Toast toast = Toast.makeText(getApplicationContext(),"Invalid Entry! Try Again :(", Toast.LENGTH_SHORT);
                            toast.show();
                            fromdate.setText("");
                        }
                        else
                        {
                            fromdate.setText(date);
                        }

                    }
                },current_years,current_month,current_day); datePickerDialog.show();
            } });

        todate.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v)
            {
                DatePickerDialog datePickerDialog =new DatePickerDialog (Attendance.this, new DatePickerDialog.OnDateSetListener()
                {
                    @Override public void onDateSet(DatePicker view, int year, int month, int day)
                    {
                        month=month+1;
                        String date=day+"/"+month+"/"+year;
                        if(day>current_day && (month==current_month && year==current_years))
                        {
                            Toast toast = Toast.makeText(getApplicationContext(),"Invalid Entry! Try Again :(", Toast.LENGTH_SHORT);
                            toast.show();
                            todate.setText("");
                        }
                        else if(month>(current_month+1))
                        {
                            Toast toast = Toast.makeText(getApplicationContext(),"Invalid Entry! Try Again :(", Toast.LENGTH_SHORT);
                            toast.show();
                            todate.setText("");
                        }
                        else if(year>(current_years+1))
                        {
                            Toast toast = Toast.makeText(getApplicationContext(),"Invalid Entry! Try Again :(", Toast.LENGTH_SHORT);
                            toast.show();
                            todate.setText("");
                        }
                        else
                        {
                            todate.setText(date);
                        }

                    }
                },current_years,current_month,current_day); datePickerDialog.show();
            } });
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

    public void ClickPG(View view)
    {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.example.christkp");
        if (launchIntent != null) {
            startActivity(launchIntent);
        } else {
            Toast.makeText(Attendance.this, "There is no package available in android", Toast.LENGTH_LONG).show();
        }
    }

    public void ClickAttendance(View view)
    {
        recreate();
    }


    public void ClickDatabase(View view)
    {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.example.raj2047120");
        if (launchIntent != null) {
            startActivity(launchIntent);
        } else {
            Toast.makeText(Attendance.this, "There is no package available in android", Toast.LENGTH_LONG).show();
        }
    }

    public void ClickCanteen(View view)
    {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.example.myapplication");
        if (launchIntent != null) {
            startActivity(launchIntent);
        } else {
            Toast.makeText(Attendance.this, "There is no package available in android", Toast.LENGTH_LONG).show();
        }
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

    public void ClickUpload(View v)
    {
        Toast toast = Toast.makeText(getApplicationContext(),"Activity Under Maintenance", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void ClickSubmit(View v)
    {
        Toast toast = Toast.makeText(getApplicationContext(),"Claim submitted successfully !", Toast.LENGTH_SHORT);
        toast.show();
    }
}