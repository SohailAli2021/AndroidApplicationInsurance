package com.example.insurenceapp;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ShowActivityuserdata extends AppCompatActivity {


    private TextView firstname, lastname, email, gender,  policyNameEditText, policyNumberEditText,policyaddressEdiText,policyCnicEditText,policyTimeEditText;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_activityuserdata);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference("Admin");

        firstname = findViewById(R.id.firstNameTextView);
        lastname = findViewById(R.id.lastNameTextView);
        email = findViewById(R.id.emailTextView);
        gender = findViewById(R.id.genderTextView);
        policyNameEditText = findViewById(R.id.policyNameTextView);
        policyNumberEditText = findViewById(R.id.policyNumberTextView);
       policyaddressEdiText=findViewById(R.id.policyaddressTextView);
       policyCnicEditText=findViewById(R.id.policyCnicesTextView);
       policyTimeEditText=findViewById(R.id.policyTimessTextView);

        // Load and display user information
        loadUserData();
    }

    private void loadUserData() {

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            String userId = currentUser.getUid();
            DatabaseReference currentUserDb = mDatabase.child(userId);

            currentUserDb.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        Admin admin = dataSnapshot.getValue(Admin.class);
                        if (admin != null) {
                            // Set TextViews with user data
                            firstname.setText("First Name: " + admin.getFirstname());
                            lastname.setText("Last Name: " + admin.getLastname());
                            email.setText("Email: " + admin.getEmail());
                            gender.setText("Gender: " +admin.getGender());
                           policyNameEditText.setText("Policy Name :"+admin.getPolicyName());
                           policyNumberEditText.setText("Policy number :"+admin.getPolicyNumber());
                           policyaddressEdiText.setText("Policy Address :"+admin.getPolicyAddress());
                           policyCnicEditText.setText("Policy Cnic :"+admin.getPolicyCnic());
                           policyTimeEditText.setText("Policy Time :"+admin.getPolicyTime());

                        }
                    }

                }


                @Override
                public void onCancelled(DatabaseError databaseError) {
                    // Handle errors if any
                }
            });
}
}

    public void editpro(View view) {
        Intent intent = new Intent(ShowActivityuserdata.this, UpdatedproActivity.class);
        startActivity(intent);
    }
}