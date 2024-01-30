package com.example.insurenceapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class ShowPolicyAdapteruser extends FirebaseRecyclerAdapter<ViewHolderpolicy,ShowPolicyAdapteruser.MyViewHolders> {
    public ShowPolicyAdapteruser(@NonNull FirebaseRecyclerOptions<ViewHolderpolicy> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyViewHolders holder, int position, @NonNull ViewHolderpolicy model) {
        holder.policyname.setText(model.getPolicyname());
        holder.term.setText(model.getTerm());
        holder.policynumber.setText(model.getPolicynumber());
        holder.policyemail.setText(model.getPolicyemail());
        holder.contactnumber.setText(model.getContactnumber());
        holder.policy.setText(model.getPolicy());

    }


    @NonNull
    @Override
    public ShowPolicyAdapteruser.MyViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowuserlayout,parent,false);
        return new MyViewHolders(view);
    }


    public class MyViewHolders extends RecyclerView.ViewHolder{
        TextView policyname,term,policynumber,policyemail,contactnumber,policy;

        public MyViewHolders(@NonNull View itemView) {
            super(itemView);
            policyname=(TextView)itemView.findViewById(R.id.sname);
            term=(TextView)itemView.findViewById(R.id.sterm);
            policynumber=(TextView)itemView.findViewById(R.id.snumber);
            policyemail=(TextView)itemView.findViewById(R.id.semail);
            contactnumber=(TextView)itemView.findViewById(R.id.scontactnumber);
            policy=(TextView)itemView.findViewById(R.id.spolicy);
        }
    }
}
