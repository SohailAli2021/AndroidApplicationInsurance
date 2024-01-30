package com.example.insurenceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.Policy;

public class NewPolicyAdminActivity extends AppCompatActivity {


    EditText policyname1, term2, policynumber3, policyemail4, contactnumber5;

    Button btnsubmit;

    String policy = "";
    FirebaseDatabase mAuth;
    RadioButton  p1,p2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_policy_admin);
        policyname1=(EditText) findViewById(R.id.policyname);
        term2=(EditText) findViewById(R.id.term);
        policynumber3=(EditText) findViewById(R.id.policynumber);
        policyemail4=(EditText) findViewById(R.id.policyemail);
        contactnumber5=(EditText) findViewById(R.id.contactnumber);
        p1=(RadioButton)findViewById(R.id.p1);
        p2=(RadioButton) findViewById(R.id.p2);
      btnsubmit = (Button) findViewById(R.id.btnpolicy);
      mAuth = FirebaseDatabase.getInstance();


    }


    public void Submitpolicy(View view) {
        String   policyname =  policyname1.getText().toString().trim();
        String term = term2.getText().toString().trim();
        String policynumber = policynumber3.getText().toString().trim();
        String policyemail = policyemail4.getText().toString().trim();
        String contactnumber = contactnumber5.getText().toString().trim();

if (p1.isChecked()){
policy = "Monthly";
}
if (p2.isChecked()){
    policy = "Yearly";
}

        AddPolicyHolder obj = new AddPolicyHolder(policyname,term,policynumber,policyemail,contactnumber,policy);
        // Admin obj = new Admin(Policyname,Term,Policynumber,Policyemail,Contactnumber);
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        DatabaseReference node=db.getReference("AddPolicy");
        node.child(policynumber).setValue(obj);
        policyname1.setText("");
        term2.setText("");
        policynumber3.setText("");
        policyemail4.setText("");
        contactnumber5.setText("");
        p1.setText("");
        p2.setText("");

        Toast.makeText(this, "Data inserted Successfully", Toast.LENGTH_SHORT).show();
    }
}