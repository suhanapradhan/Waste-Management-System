package com.example.learningmapsfromu4universe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class chemical_composition extends AppCompatActivity {
    ListView list;
    ArrayAdapter<String> adapter;
    ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemical_composition);
        getSupportActionBar().setTitle("Chemical Composition");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        items = new ArrayList<>();
        items.add("Fraction:- \n-->Sugars, starches, amino acids, urea, ammonium salts,(hot/cold water solubles) \nPercentage (on dry water basis):- \n-->2-30");
        items.add("Fraction:- \n-->Fats, oils, waxes, (either / alcohol solubles) \nPercentage (on dry water basis):- \n-->1-15");
        items.add("Fraction:- \n-->Proteins \nPercentage (on dry water basis):- \n-->5-40");
        items.add("Fraction:- \n-->Hemi-Cellulose \nPercentage (on dry water basis):- \n-->10-30");
        items.add("Fraction:- \n-->Cellulose \nPercentage (on dry water basis):- \n-->15-60");
        items.add("Fraction:- \n-->Lignin \nPercentage (on dry water basis):- \n-->5-30");
        items.add("Fraction:- \n-->Mineral Matter (ash) \nPercentage (on dry water basis):- \n-->5-30");
        list = findViewById(R.id.chemicallist);

        adapter = new ArrayAdapter<>(getApplication(),android.R.layout.simple_list_item_1,items);

        list.setAdapter(adapter);
    }
}
