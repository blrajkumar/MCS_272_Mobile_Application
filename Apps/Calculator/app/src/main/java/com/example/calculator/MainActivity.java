package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String expr = "";
    private TextView main_disp;
    private TextView sub_disp;
    private boolean eval_flag = false;
    private boolean bracket_flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_disp = (TextView) findViewById(R.id.result);
        sub_disp = (TextView) findViewById(R.id.expr);
    }
    public void click_zero(View v)
    {
        if (eval_flag){sub_disp.setText("");main_disp.setText("");eval_flag=false;}
        expr = main_disp.getText().toString();
        expr = expr + "0";
        main_disp.setText(expr);
    }

    public void click_one(View v)
    {
        if (eval_flag){sub_disp.setText("");main_disp.setText("");eval_flag=false;}
        expr = main_disp.getText().toString();
        expr = expr + "1";
        main_disp.setText(expr);
    }

    public void click_two(View v)
    {
        if (eval_flag){sub_disp.setText("");main_disp.setText("");eval_flag=false;}
        expr = main_disp.getText().toString();
        expr = expr + "2";
        main_disp.setText(expr);
    }

    public void click_three(View v)
    {
        if (eval_flag){sub_disp.setText("");main_disp.setText("");eval_flag=false;}
        expr = main_disp.getText().toString();
        expr = expr + "3";
        main_disp.setText(expr);
    }

    public void click_four(View v)
    {
        if (eval_flag){sub_disp.setText("");main_disp.setText("");eval_flag=false;}
        expr = main_disp.getText().toString();
        expr = expr + "4";
        main_disp.setText(expr);
    }

    public void click_five(View v)
    {
        if (eval_flag){sub_disp.setText("");main_disp.setText("");eval_flag=false;}
        expr = main_disp.getText().toString();
        expr = expr + "5";
        main_disp.setText(expr);
    }

    public void click_six(View v)
    {
        if (eval_flag){sub_disp.setText("");main_disp.setText("");eval_flag=false;}
        expr = main_disp.getText().toString();
        expr = expr + "6";
        main_disp.setText(expr);
    }

    public void click_seven(View v)
    {
        if (eval_flag){sub_disp.setText("");main_disp.setText("");eval_flag=false;}
        expr = main_disp.getText().toString();
        expr = expr + "7";
        main_disp.setText(expr);
    }

    public void click_eight(View v)
    {
        if (eval_flag){sub_disp.setText("");main_disp.setText("");eval_flag=false;}
        expr = main_disp.getText().toString();
        expr = expr + "8";
        main_disp.setText(expr);
    }

    public void click_nine(View v)
    {
        if (eval_flag){sub_disp.setText("");main_disp.setText("");eval_flag=false;}
        expr = main_disp.getText().toString();
        expr = expr + "9";
        main_disp.setText(expr);
    }

    public void click_dot(View v)
    {
        if (eval_flag){sub_disp.setText("");main_disp.setText("");eval_flag=false;}
        expr = main_disp.getText().toString();
        expr = expr + ".";
        main_disp.setText(expr);
    }

    public void click_plus(View v)
    {
        if (eval_flag){sub_disp.setText("");main_disp.setText("");eval_flag=false;}
        expr = main_disp.getText().toString();
        expr = expr + "+";
        main_disp.setText(expr);
    }

    public void click_minus(View v)
    {
        if (eval_flag){sub_disp.setText("");main_disp.setText("");eval_flag=false;}
        expr = main_disp.getText().toString();
        expr = expr + "-";
        main_disp.setText(expr);
    }

    public void click_multp(View v)
    {
        if (eval_flag){sub_disp.setText("");main_disp.setText("");eval_flag=false;}
        expr = main_disp.getText().toString();
        expr = expr + "*";
        main_disp.setText(expr);
    }

    public void click_div(View v)
    {
        if (eval_flag){sub_disp.setText("");main_disp.setText("");eval_flag=false;}
        expr = main_disp.getText().toString();
        expr = expr + "/";
        main_disp.setText(expr);
    }

    public void click_percnt(View v)
    {
        if (eval_flag){sub_disp.setText("");main_disp.setText("");eval_flag=false;}
        expr = main_disp.getText().toString();
        expr = expr + "%";
        main_disp.setText(expr);
    }

    public void click_ac(View v)
    {
        if (eval_flag){sub_disp.setText("");main_disp.setText("");eval_flag=false;}
        main_disp.setText("");
        expr="";
    }

    public void click_del(View v)
    {
        if (eval_flag){sub_disp.setText("");main_disp.setText("");eval_flag=false;}
        expr = main_disp.getText().toString();
        if(expr.length() > 0) {
            expr = expr.substring(0, expr.length() - 1);
        }
        main_disp.setText(expr);
    }

    public void click_brackets(View v)
    {
        if (eval_flag){sub_disp.setText("");main_disp.setText("");eval_flag=false;}
        expr = main_disp.getText().toString();
        if(expr.length() == 0) {
            expr = expr+"(";
            bracket_flag = true;
        }
        else if((expr.length()>0) && (expr.endsWith("(")))
        {
            expr = expr+"(";
        }
        else if((expr.length()>0) && (expr.endsWith(")")))
        {
            expr = expr+")";
        }
        else if(!bracket_flag)
        {
            expr = expr+"(";
            bracket_flag = true;
        }
        else
        {
            expr = expr+")";
            bracket_flag = false;
        }

        main_disp.setText(expr);
    }

    public void click_equal(View v)
    {
        int result = 0;
        sub_disp.setText(expr);
        if(!expr.isEmpty())
        {
            try {
                result = EvaluateString.evaluate(expr);
                main_disp.setText(Integer.toString(result));
            } catch (Exception e) {
                e.printStackTrace();
                main_disp.setText("Invalid Expr");
            }
            expr="";
            eval_flag = true;
        }
    }
}