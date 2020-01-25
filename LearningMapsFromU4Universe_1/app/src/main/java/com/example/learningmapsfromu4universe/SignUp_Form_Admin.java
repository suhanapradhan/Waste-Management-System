package com.example.learningmapsfromu4universe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp_Form_Admin extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText txtUserName, txtAddress, txtEmail, txtPassword, txtConfirmPassword,
            txt_no_of_family_members, txtHouseNumber, txtPhoneNumber, txtLicenseNumber;
    Button btn_register;
    /*ProgressBar progressBar;*/
    Spinner spinner;

    private FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up__form__admin);

        getSupportActionBar().setTitle("Signup Form");
        databaseReference = FirebaseDatabase.getInstance().getReference("Admin");
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        databaseReference = FirebaseDatabase.getInstance().getReference("Drivers");


        txtUserName = (EditText) findViewById(R.id.UserName);
        txtAddress = findViewById(R.id.AdminWalaAddress);
        txtEmail = (EditText) findViewById(R.id.Email);
        txtPassword = (EditText) findViewById(R.id.Password);
        txtConfirmPassword = (EditText) findViewById(R.id.ConPassword);
        txt_no_of_family_members = findViewById(R.id.NoOfFamilyMembers);
        txtHouseNumber = findViewById(R.id.Housenumber);
        txtPhoneNumber = findViewById(R.id.PhoneNumber);
        txtLicenseNumber = findViewById(R.id.Licensenumber);

        btn_register = (Button) findViewById(R.id.Register);

        spinner = (Spinner) findViewById(R.id.spinner1);

        firebaseAuth = FirebaseAuth.getInstance();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Designation, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email1 = txtEmail.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();
                String confirmPassword = txtConfirmPassword.getText().toString().trim();
                String noOfFamilyMembers = txt_no_of_family_members.getText().toString().trim();
                String houseNumber = txtHouseNumber.getText().toString().trim();
                final String phoneNumber = txtPhoneNumber.getText().toString().trim();
                String licenseNumber = txtLicenseNumber.getText().toString().trim();
                String item = spinner.getSelectedItem().toString();

                String email = "1";
                switch (item) {
                    case "Admin":
                        email = "A_" + email1;
                        break;
                    case "User":
                        email = "U_" + email1;
                        break;
                    case "Driver":
                        email = "D_" + email1;
                        break;
                }


                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(SignUp_Form_Admin.this, "Please Enter Email !", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(SignUp_Form_Admin.this, "Please Enter Valid Password !", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(confirmPassword)) {
                    Toast.makeText(SignUp_Form_Admin.this, "Please Enter Valid Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length() < 6) {
                    Toast.makeText(SignUp_Form_Admin.this, "Password too Short ! ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(licenseNumber) && item.equals("Driver")) {
                    Toast.makeText(SignUp_Form_Admin.this, "Please Enter License number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(noOfFamilyMembers) && item.equals("User")) {
                    Toast.makeText(SignUp_Form_Admin.this, "Please Enter the number of family members", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(houseNumber) && item.equals("User")) {
                    Toast.makeText(SignUp_Form_Admin.this, "Please Enter House number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(phoneNumber)) {
                    Toast.makeText(SignUp_Form_Admin.this, "Please Enter Phone number", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.equals(confirmPassword)) {
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(SignUp_Form_Admin.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {

                                        String item1 = spinner.getSelectedItem().toString();


                                        String email = txtEmail.getText().toString().trim();

                                        String name = txtUserName.getText().toString().trim();

                                        String address = txtAddress.getText().toString().trim();

                                        String password = txtPassword.getText().toString().trim();

                                        String licenseNumber =txtLicenseNumber.getText().toString().trim();

                                        String phoneNumber = txtPhoneNumber.getText().toString().trim();

                                        String house_number = txtHouseNumber.getText().toString().trim();

                                        String family_members = txt_no_of_family_members.getText().toString().trim();



                                        driverRegistrationHelper helpDriver = new driverRegistrationHelper(

                                                name,
                                                address,
                                                email,
                                                password,
                                                licenseNumber,
                                                phoneNumber

                                        );

                                        userRegistrationHelper helpUser = new userRegistrationHelper(

                                                name,
                                                address,
                                                email,
                                                password,
                                                family_members,
                                                house_number,
                                                phoneNumber
                                        );

                                        adminRegistrationHelper helpAdmin = new adminRegistrationHelper(

                                                name,
                                                address,
                                                email,
                                                password,
                                                phoneNumber
                                        );


                                        int iend = email.indexOf(".");
                                        String subEmail = "null";
                                        if (iend != -1) {
                                            subEmail = email.substring(0, iend);
                                        }



                                        // DatabaseReference mDatabase;
                                        if (item1.equals("User")) {
                                           /* mDatabase = FirebaseDatabase.getInstance().getReference("User").child("U_" + subEmail);
                                            mDatabase.child("U_" + subEmail).setValue(name);*/

                                            FirebaseDatabase.getInstance().getReference("Users")
                                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                    .setValue(helpUser).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {

                                                    Toast.makeText(SignUp_Form_Admin.this, "Registration complete", Toast.LENGTH_SHORT).show();

                                                    Intent i = new Intent(SignUp_Form_Admin.this, FrontPage.class);
                                                    startActivity(i);
                                                }

                                            });
                                        }
                                        if (item1.equals("Driver")) {
                                            /*mDatabase = FirebaseDatabase.getInstance().getReference("Drivers").child("D_" + subEmail);
                                            mDatabase.child("D_" + subEmail).setValue(name);*/


                                            FirebaseDatabase.getInstance().getReference("Drivers")
                                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                    .setValue(helpDriver).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {

                                                    Toast.makeText(SignUp_Form_Admin.this, "Registration complete", Toast.LENGTH_SHORT).show();

                                                    Intent i = new Intent(SignUp_Form_Admin.this, FrontPage.class);
                                                    startActivity(i);
                                                }

                                            });


                                        }
                                       /* Intent i = new Intent(SignUp_Form_Admin.this, AdminManage.class);
                                        startActivity(i);*/
                                        if(item1.equals("Admin")){
                                            FirebaseDatabase.getInstance().getReference("Admin")
                                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                    .setValue(helpAdmin).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {

                                                    Toast.makeText(SignUp_Form_Admin.this, "Registration complete", Toast.LENGTH_SHORT).show();

                                                    Intent i = new Intent(SignUp_Form_Admin.this, FrontPage.class);
                                                    startActivity(i);
                                                }

                                            });
                                        }


                                        startActivity(new Intent(getApplicationContext(), AdminManage.class));

                                    } else {


                                        Toast.makeText(SignUp_Form_Admin.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                }


            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
