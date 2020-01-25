package com.example.learningmapsfromu4universe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class AdminManage extends AppCompatActivity {

    Button btn_add_user, btn_delete_user, btn_update_user,btn_logout;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_manage);
        getSupportActionBar().setTitle("Settings");

        btn_add_user =findViewById(R.id.addusersbutton);
        btn_delete_user =findViewById(R.id.deleteuserbutton);
        btn_update_user =findViewById(R.id.updateuserbutton);
        btn_logout = findViewById(R.id.logoutbutton);

        btn_add_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdminManage.this, SignUp_Form_Admin.class);
                startActivity(i);
                Toast.makeText(AdminManage.this, "Add User", Toast.LENGTH_SHORT).show();
            }
        });



        btn_delete_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent i = new Intent(admin.this, AdminRecordsActivity.class);
                startActivity(i);*/
                Toast.makeText(AdminManage.this, "Delete User", Toast.LENGTH_SHORT).show();
            }
        });



        btn_update_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*   Intent i = new Intent(admin.this, MainImageActivity.class);
                startActivity(i);*/
               // Toast.makeText(getApplicationContext(),"Welcome to Notices Section ! ",Toast.LENGTH_SHORT).show();

                Toast.makeText(AdminManage.this, "Update User", Toast.LENGTH_SHORT).show();
            }
        });



        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(AdminManage.this, FrontPage.class));
                // Toast.makeText(Admin.this, "Logout clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
