package com.example.android.recyclerview;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Cart_Activity extends AppCompatActivity {

    private final String menuNames[] = {"Biriyani","Idli","Samosa","Spegatii","Salad","Pizza","Sizzling-Fish","Burger","Salad","Donut"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_);
        final LinearLayout lm = (LinearLayout) findViewById(R.id.linear_main);

        // create the layout params that will be used to define how your
        // button will be displayed
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        //lm.setBackgroundColor(Color.BLACK);

        TextView title = new TextView(this);
        title.setText("Items Won");
        title.setTextColor(Color.BLACK);
        Typeface typeface = ResourcesCompat.getFont(getApplicationContext(), R.font.nosifer);
        title.setTypeface(typeface);
        title.setGravity(Gravity.CENTER);
        //title.setBackgroundColor(Color.BLACK);
        title.setTextSize(35);
        LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(1450,400);
        title.setLayoutParams(parms);
        lm.addView(title);
        //Create four
        int fdcnt = FoodCart.fooditems.size();

        if (fdcnt>0)
        {
            for(int i =0; i<fdcnt; i++)
            {
                TextView space = new TextView(this);
                space.setText("");
                LinearLayout.LayoutParams spc = new LinearLayout.LayoutParams(250,50);
                space.setLayoutParams(spc);
                lm.addView(space);

                // Create LinearLayout
                LinearLayout ll = new LinearLayout(this);
                ll.setOrientation(LinearLayout.HORIZONTAL);
                ll.setBackgroundColor(Color.BLACK);
                LinearLayout.LayoutParams menu = new LinearLayout.LayoutParams(1350,500);
                menu.gravity = Gravity.CENTER;
                ll.setLayoutParams(menu);

                // Create TextView
                TextView product = new TextView(this);
                product.setText(menuNames[FoodCart.fooditems.get(i)]);
                product.setTextColor(Color.WHITE);
                product.setGravity(Gravity.CENTER);
                product.setTextSize(28);
                LinearLayout.LayoutParams parms0 = new LinearLayout.LayoutParams(725,500);
                product.setLayoutParams(parms0);
                ll.addView(product);

                // Create TextView
                ImageView foodimg = new ImageView(this);
                //String imagename = "f"+FoodCart.fooditems.get(0);
                int imgnum = FoodCart.fooditems.get(i)+1;
                String imagename = "f"+Integer.toString(imgnum);
                int res = getResources().getIdentifier(imagename, "drawable", this.getPackageName());
                foodimg.setImageResource(res);
                //foodimg.setImageResource(R.drawable.f2);
                LinearLayout.LayoutParams parms1 = new LinearLayout.LayoutParams(550,500);
                foodimg.setLayoutParams(parms1);
                ll.addView(foodimg);

                lm.addView(ll);
            }

            TextView space = new TextView(this);
            space.setText("");
            LinearLayout.LayoutParams spc = new LinearLayout.LayoutParams(250,100);
            space.setLayoutParams(spc);
            lm.addView(space);

            Button claim = new Button(this);
            claim.setText("Claim");
            LinearLayout.LayoutParams clm = new LinearLayout.LayoutParams(500,200);
            clm.gravity = Gravity.CENTER;
            claim.setBackgroundColor(Color.BLACK);
            claim.setTextColor(Color.WHITE);
            claim.setTextSize(21);
            claim.setLayoutParams(clm);
            claim.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent main = new Intent(Cart_Activity.this, Congo.class);
                    startActivity(main);
                    finish();
                    Log.i("TAG", "The index is");
                }
            });
            lm.addView(claim);
        }
        else
        {
            TextView txt = new TextView(this);
            txt.setText("No items won yet!");
            LinearLayout.LayoutParams notxt = new LinearLayout.LayoutParams(900,800);
            notxt.gravity = Gravity.CENTER;
            txt.setGravity(Gravity.CENTER);
            txt.setTextColor(Color.BLACK);
            txt.setTextSize(30);
            txt.setLayoutParams(notxt);
            lm.addView(txt);

            Button claim = new Button(this);
            claim.setText("Back");
            LinearLayout.LayoutParams clm = new LinearLayout.LayoutParams(500,200);
            clm.gravity = Gravity.CENTER;
            claim.setBackgroundColor(Color.BLACK);
            claim.setTextColor(Color.WHITE);
            claim.setTextSize(21);
            claim.setLayoutParams(clm);
            claim.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent main = new Intent(Cart_Activity.this, MainActivity.class);
                    startActivity(main);
                    finish();
                    Log.i("TAG", "The index is");
                }
            });
            lm.addView(claim);
        }

    }
}