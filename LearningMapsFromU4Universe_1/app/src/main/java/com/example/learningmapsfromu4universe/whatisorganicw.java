package com.example.learningmapsfromu4universe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class whatisorganicw extends AppCompatActivity {
    ListView list;
    ArrayAdapter<String> adapter;
    ArrayList<String> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatisorganicw);
        getSupportActionBar().setTitle("Organic Waste");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        items = new ArrayList<>();
        items.add("Organic waste is that waste which comes from plant, animal and human sources. ");
        items.add("It is also known as wet waste or bio-degradable waste.");
        items.add("They commonly include agricultural waste (crop residues)," +
                " livestock waste(dung, urine, litter, mortalities etc), kitchen" +
                "waste(food waste, fruits adn vegetables peels, eggshells and bones)," +
                " garden sweeping consisting of green or dry leaves and human excreta.");
        items.add("This type of waste is bio-degradable i.e they can be easily converted" +
                " to manure by micro-organisms over time");
       // items.add();
        //items.add();
        list = findViewById(R.id.wowlist);

        adapter = new ArrayAdapter<>(getApplication(),android.R.layout.simple_list_item_1,items);

        list.setAdapter(adapter);
    }
}
