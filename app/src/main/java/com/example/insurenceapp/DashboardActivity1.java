package com.example.insurenceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DashboardActivity1 extends AppCompatActivity {
    ImageView imgs1;
    TextView texts;
    Animation top,bottom;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard1);




    }

    public void gotopolicy(View view) {
        Intent intent = new Intent(DashboardActivity1.this,NewPolicyAdminActivity.class);
        startActivity(intent);
    }

    public void gotopolicyread(View view) {
        Intent intent = new Intent(DashboardActivity1.this, PolicyViewUserActivity.class);
        startActivity(intent);
    }

    public void gotoabout(View view) {
        Intent intent = new Intent(DashboardActivity1.this, AboutActivity.class);
        startActivity(intent);
    }


    public void gotofilepdf(View view) {
        Intent intent = new Intent(DashboardActivity1.this,PDFActivity.class);
        startActivity(intent);
    }


    public void chkalluser(View view) {
        Intent intent = new Intent(DashboardActivity1.this, AdminShowActivity.class);
        startActivity(intent);
    }

    public void logout(View view) {
        Intent intent = new Intent(DashboardActivity1.this, Login_Activity.class);
        startActivity(intent);
        finish();
        Toast.makeText(DashboardActivity1.this,"SuccessFully Logout",Toast.LENGTH_SHORT).show();

    }
}
