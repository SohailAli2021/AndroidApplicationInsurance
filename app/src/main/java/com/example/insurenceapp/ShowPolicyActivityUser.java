package com.example.insurenceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class ShowPolicyActivityUser extends AppCompatActivity {
    RecyclerView recyclerView;
    ShowPolicyAdapteruser showPolicyAdapteruser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_policy_user);
        Toolbar toolbar= findViewById(R.id.toolbaruser);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Search Here............");
        recyclerView=(RecyclerView)findViewById(R.id.recyleruser);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<ViewHolderpolicy> options=
                new FirebaseRecyclerOptions.Builder<ViewHolderpolicy>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("AddPolicy"),ViewHolderpolicy.class)
                        .build();
        showPolicyAdapteruser =new ShowPolicyAdapteruser(options);
        recyclerView.setAdapter(showPolicyAdapteruser);
    }
    protected void onStart(){
        super.onStart();
        showPolicyAdapteruser.startListening();
    }
    protected void onStop(){
        super.onStop();
        showPolicyAdapteruser.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem item=menu.findItem(R.id.search);
        SearchView searchView=(SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchingprocess(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                searchingprocess(query);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    private void searchingprocess(String query){

        FirebaseRecyclerOptions<ViewHolderpolicy>options=
                new FirebaseRecyclerOptions.Builder<ViewHolderpolicy>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("AddPolicy")
                                        .orderByChild("policyname").startAt(query).endAt(query + "\uf8ff")
                                , ViewHolderpolicy.class)
                        .build();

        showPolicyAdapteruser =new ShowPolicyAdapteruser(options);
        showPolicyAdapteruser.startListening();
        recyclerView.setAdapter(showPolicyAdapteruser);

    }

    public void Submit_buy(View view) {
        Intent intent = new Intent(ShowPolicyActivityUser.this,BuyActivityUser.class);
        startActivity(intent);
    }

}
