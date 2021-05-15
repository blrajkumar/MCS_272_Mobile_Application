package com.example.labtest02;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class Dates
{
    public static ArrayList<String> slots = new ArrayList<String>();
    public Dates()
    {

    }

    public static void set_dates(String[] dates)
    {
        slots = new ArrayList<>(Arrays.asList(dates));
    }

    public static String[] get_dates()
    {
        String dates[] = new String[slots.size()];
        for (int j = 0; j < slots.size(); j++) {
            dates[j] = slots.get(j);
        }

        return dates;
    }

    public static void insert_slot(Context c, String sd)
    {
        if(slots.contains(sd)){
            Toast toast = Toast.makeText(c,"Slot has not been added !", Toast.LENGTH_SHORT);
            toast.show();
        }
        else
        {
            slots.add(sd);Toast toast = Toast.makeText(c, "Slot has been added", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    public static void delete_slot(String sd)
    {
        if(slots.contains(sd)){
            slots.remove(sd);
        }

    }
}
