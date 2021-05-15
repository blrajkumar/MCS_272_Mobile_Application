package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText;
        final EditText editText2;
        final TextView tv2;
        Button btn_add;
        Button btn_sub;
        Button btn_mul;
        Button btn_div;


        editText=(EditText)findViewById(R.id.editText);
        editText2=(EditText)findViewById(R.id.editText2);
        tv2=(TextView)findViewById(R.id.tv2);
        btn_add=(Button)findViewById(R.id.btn_add);
        btn_sub=(Button)findViewById(R.id.btn_sub);
        btn_mul=(Button)findViewById(R.id.btn_mul);
        btn_div=(Button)findViewById(R.id.btn_div);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double num1,num2,sum;
                num1 = Double.parseDouble(editText.getText().toString());
                num2 = Double.parseDouble(editText2.getText().toString());
                sum = num1 + num2;
                tv2.setText(Double.toString(sum));
            }
        });

        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double num1,num2,sub;
                num1 = Double.parseDouble(editText.getText().toString());
                num2 = Double.parseDouble(editText2.getText().toString());
                sub = num1 - num2;
                tv2.setText(Double.toString(sub));
            }
        });

        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double num1, num2, mul;
                num1 = Double.parseDouble(editText.getText().toString());
                num2 = Double.parseDouble(editText2.getText().toString());
                mul = num1 * num2;
                tv2.setText(Double.toString(mul));
            }
        });

        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double num1, num2, div;
                num1 = Double.parseDouble(editText.getText().toString());
                num2 = Double.parseDouble(editText2.getText().toString());
                div = num1 / num2;
                tv2.setText(Double.toString(div));
            }
        });
    }
}