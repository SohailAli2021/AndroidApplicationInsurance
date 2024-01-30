package com.example.insurenceapp;

import static java.util.Objects.*;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;



public class adminshowAdpter extends FirebaseRecyclerAdapter<AdminShowUserHolder,adminshowAdpter.MyViewHolder> {
    public adminshowAdpter(@NonNull FirebaseRecyclerOptions<AdminShowUserHolder> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull adminshowAdpter.MyViewHolder holder, int position, @NonNull AdminShowUserHolder model) {
        holder.firstname.setText(model.getFirstname());
        holder.lastname.setText(model.getLastname());
        holder.email.setText(model.getEmail());
        holder.gender.setText(model.getGender());
        holder.policyNameEditText.setText(model.getPolicyName());
        holder.policyNumberEditText.setText(model.getPolicyNumber());
      holder.policyaddressEdiText.setText(model.getPolicyAddress());
      holder.policyCnicEditText.setText(model.getPolicyCnic());
      holder.policyTimeEditText.setText(model.getPolicyTime());


    }

    @NonNull
    @Override
    public adminshowAdpter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowall,parent,false);
        return new MyViewHolder(view);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView firstname, lastname, email, gender,  policyNameEditText, policyNumberEditText,policyaddressEdiText,policyCnicEditText,policyTimeEditText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            firstname=itemView.findViewById(R.id.fname);
            lastname=itemView.findViewById(R.id.lname);
            email=itemView.findViewById(R.id.aemail);
            gender=itemView.findViewById(R.id.agender);
            policyNameEditText=itemView.findViewById(R.id.anames);
            policyNumberEditText=itemView.findViewById(R.id.apolicynums);
            policyaddressEdiText=itemView.findViewById(R.id.acontact);
            policyCnicEditText=itemView.findViewById(R.id.acnic);
            policyTimeEditText=itemView.findViewById(R.id.aptimes);




        }

    }
}
