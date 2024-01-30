package com.example.insurenceapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class PolicyViewUserActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ViewPolicyAdapter  viewpolicyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy_view_user);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Search Here............");
        recyclerView=(RecyclerView)findViewById(R.id.recyler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<ViewHolderpolicy>options=
                new FirebaseRecyclerOptions.Builder<ViewHolderpolicy>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("AddPolicy"),ViewHolderpolicy.class)
                        .build();
viewpolicyAdapter=new ViewPolicyAdapter(options);
recyclerView.setAdapter(viewpolicyAdapter);
    }
    protected void onStart(){
        super.onStart();
        viewpolicyAdapter.startListening();
    }
    protected void onStop(){
        super.onStop();
        viewpolicyAdapter.stopListening();
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

        viewpolicyAdapter =new ViewPolicyAdapter(options);
        viewpolicyAdapter.startListening();
        recyclerView.setAdapter(viewpolicyAdapter);

    }



}