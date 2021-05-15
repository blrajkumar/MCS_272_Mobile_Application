package com.quintus.labs.addremovelist;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AgentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final LinearLayout lm = (LinearLayout) findViewById(R.id.linear_main);

        // create the layout params that will be used to define how your
        // button will be displayed
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        //lm.setBackgroundColor(Color.BLACK);

        TextView title = new TextView(this);
        title.setText("Select Agent");
        title.setTextColor(Color.BLACK);
        Typeface typeface = ResourcesCompat.getFont(getApplicationContext(), R.font.audiowide);
        title.setTypeface(typeface);
        title.setGravity(Gravity.CENTER);
        //title.setBackgroundColor(Color.BLACK);
        title.setTextSize(35);
        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(1450, 400);
        title.setLayoutParams(parms);
        lm.addView(title);
        //Create four
        int agntCnt = FreshCo.agent_names.size();

        if (agntCnt > 0) {
            for (int i = 0; i < agntCnt; i++) {
                TextView space = new TextView(this);
                space.setText("");
                LinearLayout.LayoutParams spc = new LinearLayout.LayoutParams(250, 50);
                space.setLayoutParams(spc);
                lm.addView(space);

                // Create LinearLayout
                LinearLayout ll = new LinearLayout(this);
                ll.setOrientation(LinearLayout.HORIZONTAL);
                ll.setBackgroundColor(Color.BLACK);
                LinearLayout.LayoutParams menu = new LinearLayout.LayoutParams(1100, 250);
                menu.gravity = Gravity.CENTER;
                ll.setLayoutParams(menu);

                // Create TextView
                TextView product = new TextView(this);
                product.setText(FreshCo.agent_names.get(i));
                product.setTextColor(Color.WHITE);
                product.setGravity(Gravity.CENTER);
                product.setTextSize(28);
                LinearLayout.LayoutParams parms0 = new LinearLayout.LayoutParams(500, 250);
                product.setLayoutParams(parms0);
                ll.addView(product);

                // Create TextView
                TextView rtng = new TextView(this);
                int randomNum = ((int) (Math.random()*(5 - 1))) + 1;
                rtng.setText("Rating: "+ randomNum);
                rtng.setTextColor(Color.WHITE);
                rtng.setGravity(Gravity.CENTER);
                rtng.setTextSize(28);
                LinearLayout.LayoutParams parms1 = new LinearLayout.LayoutParams(500, 250);
                rtng.setLayoutParams(parms1);
                ll.addView(rtng);

                ll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent main = new Intent(AgentActivity.this, MainActivity.class);
                        startActivity(main);
                        finish();
                    }
                });
                lm.addView(ll);
            }

            TextView space = new TextView(this);
            space.setText("");
            LinearLayout.LayoutParams spc = new LinearLayout.LayoutParams(250, 100);
            space.setLayoutParams(spc);
            lm.addView(space);

            Button claim = new Button(this);
            claim.setText("Claim");
            LinearLayout.LayoutParams clm = new LinearLayout.LayoutParams(500, 200);
            clm.gravity = Gravity.CENTER;
            claim.setBackgroundColor(Color.BLACK);
            claim.setTextColor(Color.WHITE);
            claim.setTextSize(21);
            claim.setLayoutParams(clm);
            claim.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent main = new Intent(AgentActivity.this, MainActivity.class);
                    startActivity(main);
                    finish();
                    Log.i("TAG", "The index is");
                }
            });
            lm.addView(claim);

            TextView space2 = new TextView(this);
            space2.setText("");
            LinearLayout.LayoutParams spc2 = new LinearLayout.LayoutParams(250, 100);
            space2.setLayoutParams(spc2);
            lm.addView(space2);
        } else {
            TextView txt = new TextView(this);
            txt.setText("No agents near your place, Try again!");
            LinearLayout.LayoutParams notxt = new LinearLayout.LayoutParams(900, 800);
            notxt.gravity = Gravity.CENTER;
            txt.setGravity(Gravity.CENTER);
            txt.setTextColor(Color.BLACK);
            txt.setTextSize(30);
            txt.setLayoutParams(notxt);
            lm.addView(txt);

            Button claim = new Button(this);
            claim.setText("Back");
            LinearLayout.LayoutParams clm = new LinearLayout.LayoutParams(500, 200);
            clm.gravity = Gravity.CENTER;
            claim.setBackgroundColor(Color.BLACK);
            claim.setTextColor(Color.WHITE);
            claim.setTextSize(21);
            claim.setLayoutParams(clm);
            claim.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent main = new Intent(AgentActivity.this, Register.class);
                    startActivity(main);
                    finish();
                    Log.i("TAG", "The index is");
                }
            });
            lm.addView(claim);
        }

    }
}