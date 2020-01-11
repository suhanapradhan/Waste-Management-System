package com.example.learningmapsfromu4universe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.PriorityQueue;

public class Register extends AppCompatActivity {

    private EditText name;
    private EditText address;
    private EditText email;
    private EditText password;
    private EditText confirmPassword;
    private EditText familyMembers;
    private EditText houseNumber;
    private EditText phoneNumber;

    private Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().setTitle("Signup for Users");

        name = findViewById(R.id.Name);
        address =findViewById(R.id.Address);
        email = findViewById(R.id.Email);
        password =findViewById(R.id.Password);
        confirmPassword = findViewById(R.id.ConfirmPassword);
        familyMembers =findViewById(R.id.FamilyNumber);
        houseNumber = findViewById(R.id.HouseNumber);
        phoneNumber = findViewById(R.id.PhoneNumber);
        registerBtn =findViewById(R.id.Register);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Register.this, "Registration in progress .... ", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
