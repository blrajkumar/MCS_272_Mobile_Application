package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int count=0;
    private TextView disp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        disp = (TextView) findViewById(R.id.display);
    }
    public void showToast(View view) {
        TextView text;
        Toast toast = Toast.makeText(this, "The current count is "+Integer.toString(count), Toast.LENGTH_SHORT);
        view = toast.getView();
        text = (TextView) view.findViewById(android.R.id.message);
        text.setTextColor(getResources().getColor(R.color.black));
        text.setTextSize(18);
        view.setBackgroundColor(Color.parseColor("#f2ccff"));
        toast.setGravity(Gravity.CENTER, 0, 500);
        toast.show();

    }

    public void counter(View v) {
        count++;
        if (disp != null) {
            Random rnd = new Random();
            disp.setTextSize(150);
            int color = Color.rgb(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            disp.setTextColor(color);
            disp.setText(Integer.toString(count));
        }
    }
}