package com.example.cyclesynch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MainAdapter madapter;
    RecyclerView recycleview;
    GridLayoutManager layoutManager = new GridLayoutManager(this,2);
    ArrayList<DataClass> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycleview = findViewById(R.id.rcview);
        setAdapter();
    }

    public void setAdapter(){
        madapter = new MainAdapter(data, MainActivity.this);
        recycleview.setLayoutManager(layoutManager);
        recycleview.setAdapter(madapter);
    }


}

