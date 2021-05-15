package com.quintus.labs.addremovelist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CartActivity extends AppCompatActivity {

    TextView crt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        crt = (TextView) findViewById(R.id.cart);

        String crtItems="";
        int crtCnt = FreshCo.cart_items.size();
        if (crtCnt > 0) {
            for (int i = 0; i < crtCnt; i++) {
                crtItems = crtItems + FreshCo.cart_items.get(i) + "\n";
            }
        }
        crt.setText(crtItems);
    }

    public void order(View v)
    {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.codingwithsara.notificationapp");
        if (launchIntent != null) {
            startActivity(launchIntent);
        } else {
            Toast.makeText(CartActivity.this, "There is no package available in android", Toast.LENGTH_LONG).show();
        }
    }
}