package com.example.learningmapsfromu4universe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Organic_Waste extends AppCompatActivity {

    Button btn_what, btn_advantages, btn_chemical_compo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organic__waste);
        getSupportActionBar().setTitle("Organic Waste");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn_what = findViewById(R.id.buttonwhat_is_oraganic_waste);
        btn_advantages = findViewById(R.id.button_advantages_ow);
        btn_chemical_compo = findViewById(R.id.button_chemical_composition);

        btn_what.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  Toast.makeText(Organic_Waste.this, " what is organic", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Organic_Waste.this, whatisorganicw.class);
                startActivity(intent);
            }
        });

        btn_advantages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Organic_Waste.this, " Advantages", Toast.LENGTH_SHORT).show();
                 Intent intent = new Intent(Organic_Waste.this, Adv_Ow.class);
                startActivity(intent);
            }
        });

        btn_chemical_compo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Organic_Waste.this, " Chemical Compositions", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Organic_Waste.this,chemical_composition.class);
                 startActivity(intent);
            }
        });


    }
}
