package com.example.insurenceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DashboardActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard2);
    }


    public void gotoaboutuser(View view) {
        Intent intent = new Intent(DashboardActivity2.this, AboutActivity.class);
        startActivity(intent);
    }

    public void gotopolicyreaduser(View view) {
        Intent intent = new Intent(DashboardActivity2.this, ShowPolicyActivityUser.class);
        startActivity(intent);
    }

    public void gotofileuser(View view) {
        Intent intent = new Intent(DashboardActivity2.this, ViewPDFActivity.class);
        startActivity(intent);
    }


    public void checkpolicy(View view) {
        Intent intent = new Intent(DashboardActivity2.this, ShowActivityuserdata.class);
        startActivity(intent);
    }

    public void logoutuser(View view) {
        Intent intent = new Intent(DashboardActivity2.this, Login_Activity.class);
        startActivity(intent);
        finish();
        Toast.makeText(DashboardActivity2.this,"SuccessFully Logout",Toast.LENGTH_SHORT).show();
    }

    public void forgetpassword(View view) {
        Intent intent = new Intent(DashboardActivity2.this, ForgetPasswordActivity .class);
        startActivity(intent);
    }
}