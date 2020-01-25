package com.example.learningmapsfromu4universe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Adv_Ow extends AppCompatActivity {

    ListView list;
    ArrayAdapter<String> adapter;
    ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adv__ow);
        getSupportActionBar().setTitle("Advantages");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        items = new ArrayList<>();
        items.add("Organic maure provides all the essential nutrients that are required by plants but in limited process.");
        items.add("It helps in maintaining Carbon: Nitrogen (C:N) ratio in the soil and also increases the fertility and productivity of the soil.");
        items.add("It improves the physical, chemical and biological properties of the soil.");
        items.add("It improves both the structure and texture of the soil.");
        items.add("It increases the waster holding capacity of the soil.");
        items.add("Due to increased biological activities, the nutrients that are in the lower depths are made available to the plants.");
        items.add("It acts as mulch, thereby minimizing the evaporation losses of moisture from the soil.");
        list = findViewById(R.id.advantagelist);

        adapter = new ArrayAdapter<>(getApplication(),android.R.layout.simple_list_item_1,items);

        list.setAdapter(adapter);
    }
}
