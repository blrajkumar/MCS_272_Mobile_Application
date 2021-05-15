package com.example.rajuscoreboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PlayerList extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list);

        final LinearLayout lm = (LinearLayout) findViewById(R.id.plr_list);
        // create the layout params that will be used to define how your
        // button will be displayed
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        //lm.setBackgroundColor(Color.BLACK);

        int agntCnt = DB_Support.players.size();
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
                LinearLayout.LayoutParams menu = new LinearLayout.LayoutParams(900, 210);
                menu.gravity = Gravity.CENTER;
                ll.setLayoutParams(menu);

                // Create TextView
                TextView product = new TextView(this);
                product.setText(DB_Support.players.get(i));
                product.setTextColor(Color.WHITE);
                product.setGravity(Gravity.CENTER);
                product.setTextSize(28);
                LinearLayout.LayoutParams parms0 = new LinearLayout.LayoutParams(900, 210);
                product.setLayoutParams(parms0);
                ll.addView(product);
                final int id = i;
                ll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DB_Support.setPlrName(DB_Support.players.get(id));
                        Intent launchIntent =  new Intent(PlayerList.this, ScoreBoard.class);
                        if (launchIntent != null) {
                            startActivity(launchIntent);
                        } else {
                            Toast.makeText(PlayerList.this, "There is no package available in android", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                ll.setBackground(getDrawableWithRadius());
                lm.addView(ll);
            }

            TextView space = new TextView(this);
            space.setText("");
            LinearLayout.LayoutParams spc = new LinearLayout.LayoutParams(250, 100);
            space.setLayoutParams(spc);
            lm.addView(space);

            Button claim = new Button(this);
            claim.setText("Exit");
            LinearLayout.LayoutParams clm = new LinearLayout.LayoutParams(880, 200);
            clm.gravity = Gravity.CENTER;
            claim.setBackgroundColor(Color.RED);
            claim.setTextColor(Color.WHITE);
            claim.setTextSize(21);
            claim.setLayoutParams(clm);
            claim.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent main = new Intent(PlayerList.this, MatchFinder.class);
                    startActivity(main);
                    finish();
                    Log.i("TAG", "The index is");
                }
            });
            claim.setBackground(getDrawableWithRadius2());
            lm.addView(claim);

            TextView space2 = new TextView(this);
            space2.setText("");
            LinearLayout.LayoutParams spc2 = new LinearLayout.LayoutParams(250, 100);
            space2.setLayoutParams(spc2);
            lm.addView(space2);
        } else {
            TextView txt = new TextView(this);
            txt.setText("No Players avilable for this match. Try again!");
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
                    Intent main = new Intent(PlayerList.this, MatchFinder.class);
                    startActivity(main);
                    finish();
                    Log.i("TAG", "The index is");
                }
            });
            lm.addView(claim);
        }

    }

    private Drawable getDrawableWithRadius() {

        GradientDrawable gradientDrawable   =   new GradientDrawable();
        gradientDrawable.setCornerRadii(new float[]{60, 60, 60, 60, 60, 60, 60, 60});
        gradientDrawable.setColor(Color.BLACK);
        return gradientDrawable;
    }

    private Drawable getDrawableWithRadius2() {

        GradientDrawable gradientDrawable   =   new GradientDrawable();
        gradientDrawable.setCornerRadii(new float[]{60, 60, 60, 60, 60, 60, 60, 60});
        gradientDrawable.setColor(Color.RED);
        return gradientDrawable;
    }

}