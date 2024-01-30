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

public class AdminShowActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    adminshowAdpter  adminshowAdpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_show);

        Toolbar toolbar= findViewById(R.id.toolbaruserdata);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Search Here............");
        recyclerView=(RecyclerView)findViewById(R.id.recyleruserdata);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<AdminShowUserHolder> options=
                new FirebaseRecyclerOptions.Builder<AdminShowUserHolder>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Admin"),AdminShowUserHolder.class)
                        .build();
        adminshowAdpter =new adminshowAdpter(options);
        recyclerView.setAdapter(adminshowAdpter);
    }
    protected void onStart(){
        super.onStart();
        adminshowAdpter.startListening();
    }
    protected void onStop(){
        super.onStop();
        adminshowAdpter.stopListening();
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

        FirebaseRecyclerOptions<AdminShowUserHolder>options=
                new FirebaseRecyclerOptions.Builder<AdminShowUserHolder>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Admin")
                                        .orderByChild("Firstname").startAt(query).endAt(query + "\uf8ff")
                                , AdminShowUserHolder.class)
                        .build();

        adminshowAdpter =new adminshowAdpter(options);
        adminshowAdpter.startListening();
        recyclerView.setAdapter(adminshowAdpter);

    }



}
