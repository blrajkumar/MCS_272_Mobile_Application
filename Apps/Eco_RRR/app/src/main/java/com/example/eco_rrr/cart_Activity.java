package com.example.eco_rrr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class cart_Activity extends AppCompatActivity {

    private TextView disp;
    private TextView total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_);
        disp = (TextView) findViewById(R.id.item_details);
        total = (TextView) findViewById(R.id.total);
        int c = cart.cart_details.size();
        String disp_content="";
        for (int i =1; i <= c; i++)
        {
            int d = cart.cart_details.get(i).size();
            for (int j =0; j < d; j++)
            {
                disp_content = disp_content + cart.cart_details.get(i).get(j).toString() + "\n";
            }
        }
        disp.setText(disp_content);
        total.setText("Total: " +cart.total);
    }
    public void check_button(View v){
        Toast.makeText(getApplicationContext(),"Activity under maintanance",Toast.LENGTH_SHORT).show();
    }
}