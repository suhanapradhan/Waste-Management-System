package com.example.learningmapsfromu4universe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class admin extends AppCompatActivity {
    Button btn_manage_account, btn_notice, btn_user_record, btn_logout;

    //firebase
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        getSupportActionBar().setTitle("Admin");

        firebaseAuth = FirebaseAuth.getInstance();

        btn_manage_account = (Button) findViewById(R.id.managebutton);

        btn_notice = (Button) findViewById(R.id.adminnoticebutton);
        btn_user_record = (Button) findViewById(R.id.userrecordbutton);
        btn_logout = (Button) findViewById(R.id.logoutbutton);



        btn_manage_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(admin.this, AdminManage.class);
                startActivity(i);
                Toast.makeText(admin.this, "Manage account clicked", Toast.LENGTH_SHORT).show();
            }
        });



        btn_user_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent i = new Intent(admin.this, AdminRecordsActivity.class);
                startActivity(i);*/
                Toast.makeText(admin.this, "Record clicked", Toast.LENGTH_SHORT).show();
            }
        });



        btn_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*   Intent i = new Intent(admin.this, MainImageActivity.class);
                startActivity(i);*/
                Toast.makeText(getApplicationContext(),"Welcome to Notices Section ! ",Toast.LENGTH_SHORT).show();

                //Toast.makeText(Admin.this, "Notice clicked", Toast.LENGTH_SHORT).show();
            }
        });



        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(admin.this, FrontPage.class));
                // Toast.makeText(Admin.this, "Logout clicked", Toast.LENGTH_SHORT).show();
            }
        });


    }


}
