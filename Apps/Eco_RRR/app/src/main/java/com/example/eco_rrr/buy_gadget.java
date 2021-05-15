package com.example.eco_rrr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class buy_gadget extends AppCompatActivity {

    private Spinner is;
    private Spinner ps;
    private Spinner qs;
    private String is_choice;
    private String ps_choice;
    private String qs_choice;
    private ArrayList<String> current_item = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_gadget);
        is = (Spinner) findViewById(R.id.itemspin);
        ps = (Spinner) findViewById(R.id.partspin);
        qs = (Spinner) findViewById(R.id.qtyspin);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.laptop, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.tablet, android.R.layout.simple_spinner_item);

        is.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                        is_choice = is.getItemAtPosition(pos).toString();
                        switch (is_choice)
                        {
                            case "Laptop":

                                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                ps.setAdapter(adapter);
                                break;
                            case "Tablet":

                                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                                ps.setAdapter(adapter2);
                                break;
                            default:
                                break;
                        }

                    }
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
    }

    public void buy_button(View v)
    {
        current_item.add("Item: "+is.getSelectedItem().toString());
        current_item.add("Type: "+ps.getSelectedItem().toString());
        current_item.add("Quantity: "+qs.getSelectedItem().toString());
        current_item.add("****************");
        cart.total = cart.total + 100000 * Integer.parseInt(qs.getSelectedItem().toString());
        cart.insert(cart.item_count,current_item);
        cart.item_count++;
        Snackbar sb = Snackbar.make(v,"Items added to cart",Snackbar.LENGTH_LONG);
        sb.show();
    }

    public void float_button(View v)
    {
        Intent l1 = new Intent(getBaseContext(), cart_Activity.class);
        startActivity(l1);
        finish();
    }

}