package com.example.insurenceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdatePolicyActivity extends AppCompatActivity {
    EditText pnameupdate,termupdate,pnumupdate,pemailupdate,pcontatupdate,pupdate;
    Button pupdateButton;

    DatabaseReference databaseReference;

    String userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_policy);
        databaseReference = FirebaseDatabase.getInstance().getReference("AddPolicy");
        pnameupdate=findViewById(R.id.pnameupdate);
        termupdate=findViewById(R.id.termupdate);
        pnumupdate=findViewById(R.id.pnumupdate);
        pemailupdate=findViewById(R.id.pemailupdate);
        pcontatupdate=findViewById(R.id.pcontatupdate);
        pupdate=findViewById(R.id.pupdate);
        pupdateButton=findViewById(R.id.pupdateButton);

        userId = getIntent().getStringExtra("userId");

        pupdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){updateData();}

        });
        fetchDataAndUpdateFields();

    }

    private void fetchDataAndUpdateFields() {
databaseReference.child(userId).get().addOnSuccessListener(snapshot ->{
if(snapshot.exists()){
ViewHolderpolicy userData = snapshot.getValue(ViewHolderpolicy.class);

  pnameupdate.setText(userData.getPolicyname());
  termupdate.setText(userData.getTerm());
  pnumupdate.setText(userData.getPolicynumber());
  pemailupdate.setText(userData.getPolicyemail());
  pcontatupdate.setText(userData.getContactnumber());
  pupdate.setText(userData.getPolicy());


}

}).addOnFailureListener(e->{
showToast("Failed to fetch user data");
});
    }

    private void updateData() {
        String poname = pnameupdate.getText().toString().trim();
        String poterm = termupdate.getText().toString().trim();
        String ponum = pnumupdate.getText().toString().trim();
        String poemail = pemailupdate.getText().toString().trim();
        String pocontact = pcontatupdate.getText().toString().trim();
        String pop = pupdate.getText().toString().trim();
        updateDataWithoutImage(poname,poterm,ponum,poemail,pocontact,pop);


    }
    private void updateDataWithoutImage(String poname, String poterm, String ponum, String poemail, String pocontact, String pop) {
        databaseReference.child(userId).child("policyname").setValue(poname);
        databaseReference.child(userId).child("term").setValue(poterm);
        databaseReference.child(userId).child("policynumber").setValue(ponum);
        databaseReference.child(userId).child("policyemail").setValue(poemail);
        databaseReference.child(userId).child("contactnumber").setValue(pocontact);
        databaseReference.child(userId).child("policy").setValue(pop);



        showToast("Data updated successfully");
        Intent intent = new Intent(UpdatePolicyActivity.this, PolicyViewUserActivity.class);
        intent.putExtra("userId", userId);
        startActivity(intent);


        finish();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}