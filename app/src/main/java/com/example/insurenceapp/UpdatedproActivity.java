package com.example.insurenceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdatedproActivity extends AppCompatActivity {

    EditText pcname, pcemail, pcnumber, pcaddress, pctimer;
    Button proButton;

    String userIds;
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatedpro);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser != null) {
            userIds = currentUser.getUid();
        } else {
            showToast("User not authenticated");
            // Handle the case when the user is not authenticated
            // You might want to redirect the user to the login screen or take appropriate action
            return;
        }

        databaseReference = FirebaseDatabase.getInstance().getReference("Admin");

        pcname = findViewById(R.id.pcname);
        pcemail = findViewById(R.id.pcemail);
        pcnumber = findViewById(R.id.pcnumber);
        pcaddress = findViewById(R.id.pcaddress);
        pctimer = findViewById(R.id.pctimer);
        proButton = findViewById(R.id.proButton);

        proButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdatedData();
            }
        });

        fetchdataallfeild();
    }

    private void fetchdataallfeild() {
        databaseReference.child(userIds).get().addOnSuccessListener(snapshot -> {
            if (snapshot.exists()) {
                AdminShowUserHolder userData = snapshot.getValue(AdminShowUserHolder.class);

                if (userData != null) {
                    pcname.setText(userData.getPolicyName());
                    pcemail.setText(userData.getEmail());
                    pcnumber.setText(userData.getPolicyNumber());
                    pcaddress.setText(userData.getPolicyAddress());
                    pctimer.setText(userData.getPolicyTime());
                } else {
                    showToast("User data is null");
                }
            }
        }).addOnFailureListener(e -> {
            showToast("Failed to fetch user data");
        });
    }

    private void UpdatedData() {
        String pcnames = pcname.getText().toString().trim();
        String pcemails = pcemail.getText().toString().trim();
        String pcnumbers = pcnumber.getText().toString().trim();
        String pcaddres = pcaddress.getText().toString().trim();
        String pctimers = pctimer.getText().toString().trim();

        updatedDataWithoutImage(pcnames, pcemails, pcnumbers, pcaddres, pctimers);
    }

    private void updatedDataWithoutImage(String pcnames, String pcemails, String pcnumbers, String pcaddres, String pctimers) {
        databaseReference.child(userIds).child("policyName").setValue(pcnames);
        databaseReference.child(userIds).child("email").setValue(pcemails);
        databaseReference.child(userIds).child("policynumber").setValue(pcnumbers);
        databaseReference.child(userIds).child("policyAddress").setValue(pcaddres);
        databaseReference.child(userIds).child("policyTime").setValue(pctimers);

        showToast("Data updated successfully");
        Intent intent = new Intent(UpdatedproActivity.this, ShowActivityuserdata.class);
        startActivity(intent);
        finish();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
