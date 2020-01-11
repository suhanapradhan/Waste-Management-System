package com.example.learningmapsfromu4universe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.sql.Driver;

public class FrontPage extends AppCompatActivity {

    private Button Login;
    private Button RegisterTo;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);
        getSupportActionBar().setTitle("Welcome ! ");

        Login= findViewById(R.id.login);
        RegisterTo = findViewById(R.id.FrontRegister);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FrontPage.this, "Logging in ..... !", Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(FrontPage.this, Login.class);
            //    startActivity(intent);
            }
        });

        RegisterTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FrontPage.this, "Registration....", Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(FrontPage.this, Register.class);
              startActivity(intent);
            }
        });


    }
}
