package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class foodActivity extends AppCompatActivity {

    private TextView name;
    private String prof;
    private WebView foodWebView;
    private CheckBox vada;
    private CheckBox roll;
    private CheckBox samsa;
    RadioButton tea;
    RadioButton cofee;
    RatingBar spice;
    Spinner qty;
    private ArrayList<String> current_item = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        name = (TextView) findViewById(R.id.name);
        foodWebView = (WebView) findViewById(R.id.webcontent);
        vada = (CheckBox)findViewById(R.id.vada);
        roll = (CheckBox)findViewById(R.id.vegroll);
        samsa = (CheckBox)findViewById(R.id.samosa);
        tea = (RadioButton) findViewById(R.id.tea);
        cofee = (RadioButton) findViewById(R.id.cofee);
        spice = (RatingBar) findViewById(R.id.spicebar);
        qty = (Spinner) findViewById(R.id.quantity);

        prof = getIntent().getExtras().getString("Value");
        switch (prof)
        {
            case "idli":
                name.setText("Idli");
                foodWebView.loadUrl("https://www.vegrecipesofindia.com/idli-recipe-with-idli-rava/");
                break;
            case "dosa":
                name.setText("Dosa");
                foodWebView.loadUrl("https://www.vegrecipesofindia.com/paper-masala-dosa-recipe/");
                break;
            case "puri":
                name.setText("Puri");
                foodWebView.loadUrl("https://www.vegrecipesofindia.com/poori-a-kind-of-fried-indian-bread/");
                break;
            case "paniyaram":
                name.setText("Paniyaram");
                foodWebView.loadUrl("https://www.vegrecipesofindia.com/masala-paniyaram-recipe/");
                break;
            case "puttu":
                name.setText("Puttu");
                foodWebView.loadUrl("https://www.vegrecipesofindia.com/puttu-recipe/");
                break;
            case "pongal":
                name.setText("Pongal");
                foodWebView.loadUrl("https://www.vegrecipesofindia.com/ven-pongal-recipe-khara-pongal-recipe/");
                break;
            default:
                break;
        }
    }

    public void vada_clicked(View v)
    {

        if(vada.isChecked())
        {
            current_item.add("Vadai");
        }
        else
        {

        }

    }

    public void roll_clicked(View v)
    {

        if(roll.isChecked())
        {
            current_item.add("Veg Roll");
        }
        else
        {

        }

    }

    public void samsa_clicked(View v)
    {

        if(samsa.isChecked())
        {
            current_item.add("Samosa");
        }
        else
        {

        }

    }

    public void onRadioButtonClicked(View v)
    {
        boolean tea_checked = tea.isChecked();
        boolean cofee_checked = cofee.isChecked();
        if (tea_checked)
        {
            current_item.add("tea");
        }
        else if(cofee_checked)
        {
            current_item.add("Coffee");
        }
        else
        {

        }
    }

    public void spice_clicked(View v)
    {
        current_item.add("Spice Level: "+Float.toString(spice.getRating()));
    }

    public void qty_clicked(View v)
    {
        current_item.add("Quantity: "+qty.getSelectedItem().toString());
    }

    public void add_cart_button(View v)
    {
        current_item.add(0, name.getText().toString());
        current_item.add("Spice Level: "+Float.toString(spice.getRating()));
        current_item.add("Quantity: "+qty.getSelectedItem().toString());
        current_item.add("****************");
        cart.total = cart.total + 10 * Integer.parseInt(qty.getSelectedItem().toString());

        cart.insert(cart.item_count,current_item);
        cart.item_count++;
        Snackbar sb = Snackbar.make(v,"Items added to cart",Snackbar.LENGTH_LONG);
        sb.show();
    }

    public void cancel_button(View v){
        Intent k1 = new Intent(getBaseContext(),southMenu.class);
        startActivity(k1);
        finish();
    }

    public void float_button(View v)
    {
        Intent l1 = new Intent(getBaseContext(), cartActivity.class);
        startActivity(l1);
        finish();
    }

    public void back_button(View v)
    {
        Intent l1 = new Intent(getBaseContext(), southMenu.class);
        startActivity(l1);
        finish();
    }

}