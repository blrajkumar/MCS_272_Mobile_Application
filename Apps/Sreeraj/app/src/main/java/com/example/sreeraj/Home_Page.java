package com.example.sreeraj;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Home_Page extends AppCompatActivity {

    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__page);
        name = (TextView) findViewById(R.id.iceType);
        name.setText("SREERAJ");
        loadFragment(new intial());
    }

    public void mango_click(View v)
    {
        name.setText("Mango");
        loadFragment(new Mango());
    }

    public void strawberry_click(View v)
    {
        name.setText("Strawberry");
        loadFragment(new Strawberry());
    }

    public void pista_click(View v)
    {
        name.setText("Pistachio");
        loadFragment(new Pista());
    }

    public void blue_click(View v)
    {
        name.setText("BlueBerry");
        loadFragment(new Blueberry());
    }

    public void banana_click(View v)
    {
        name.setText("Banana");
        loadFragment(new Banana());
    }


    public void home_click(View v)
    {
        name.setText("SREERAJ");
        loadFragment(new intial());
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.ice_view,fragment);
        fragmentTransaction.commit();
    }
}
