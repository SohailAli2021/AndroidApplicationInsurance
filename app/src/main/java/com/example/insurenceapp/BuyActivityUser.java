package com.example.insurenceapp;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class BuyActivityUser extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    private EditText policyNameEditText, policyNumberEditText,policyaddressEdiText,policyCnicEditText,policyTimeEditText;

    private Button savePolicyButton;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_user);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference("Admin");

        policyNameEditText = findViewById(R.id.policyNameEditText);
        policyNumberEditText = findViewById(R.id.policyNumberEditText);
        policyaddressEdiText = findViewById(R.id.policyaddressEdiText);
        policyCnicEditText = findViewById(R.id.policyCnicEditText);
        policyTimeEditText=findViewById(R.id.policyTimeEditText);


        savePolicyButton = findViewById(R.id.savePolicyButton);


        savePolicyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savePolicyData();
            }
        });
    }

    private void savePolicyData() {
        String policyName = policyNameEditText.getText().toString().trim();
        String policyNumber = policyNumberEditText.getText().toString().trim();
        String PolicyAddress =policyaddressEdiText.getText().toString().trim();
        String PolicyCnic = policyCnicEditText.getText().toString().trim();
        String PolicyTime = policyTimeEditText.getText().toString().trim();



        String userId = mAuth.getCurrentUser().getUid();
        DatabaseReference currentUserDb = mDatabase.child(userId);
        currentUserDb.child("policyName").setValue(policyName);
        currentUserDb.child("policyNumber").setValue(policyNumber);
        currentUserDb.child("policyAddress").setValue(PolicyAddress);
        currentUserDb.child("policyCnic").setValue(PolicyCnic);
        currentUserDb.child("policyTime").setValue(PolicyTime);
        policyNameEditText.setText("");
        policyNumberEditText.setText("");
        policyaddressEdiText.setText("");
        policyCnicEditText.setText("");
        policyTimeEditText.setText("");
        Toast.makeText(BuyActivityUser.this, "Policy Buy Successfully...", Toast.LENGTH_SHORT).show();

}
}