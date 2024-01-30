package com.example.insurenceapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import com.google.firebase.database.FirebaseDatabase;

public class ViewPolicyAdapter extends FirebaseRecyclerAdapter<ViewHolderpolicy,ViewPolicyAdapter.MyViewHolder> {

    public ViewPolicyAdapter(@NonNull FirebaseRecyclerOptions<ViewHolderpolicy> options) {
        super(options);}

    @Override
    protected void onBindViewHolder(@NonNull ViewPolicyAdapter.MyViewHolder holder, int position, @NonNull ViewHolderpolicy model) {
       holder.policyname.setText(model.getPolicyname());
        holder.term.setText(model.getTerm());
        holder.policynumber.setText(model.getPolicynumber());
        holder.policyemail.setText(model.getPolicyemail());
        holder.contactnumber.setText(model.getContactnumber());
        holder.policy.setText(model.getPolicy());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(holder.policyname.getContext());
                builder.setTitle("Delete Item");
                builder.setMessage("Are you sure you want to delete?");
builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialog, int which) {
        FirebaseDatabase.getInstance().getReference().child("AddPolicy")
                .child(getRef(holder.getAdapterPosition()).getKey()).removeValue();
    }

});
builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialog, int which) {

    }
});
builder.show();





            }
        });

    }


    @NonNull
    @Override
    public ViewPolicyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowadminpolicy,parent,false);
        return new MyViewHolder(view);
    }



    public class MyViewHolder  extends RecyclerView.ViewHolder {

        TextView policyname,term,policynumber,policyemail,contactnumber,policy;
        ImageView edit,delete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            policyname=(TextView)itemView.findViewById(R.id.pname);
            term=(TextView)itemView.findViewById(R.id.pterm);
            policynumber=(TextView)itemView.findViewById(R.id.pnumber);
            policyemail=(TextView)itemView.findViewById(R.id.pemail);
            contactnumber=(TextView)itemView.findViewById(R.id.pcontactnumber);
            policy=(TextView)itemView.findViewById(R.id.ppolicy);
            edit=(ImageView)itemView.findViewById(R.id.editicon);
            delete=(ImageView)itemView.findViewById(R.id.deleteicon);
            edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        String userId = getRef(position).getKey();
                        Intent intent = new Intent(itemView.getContext(),UpdatePolicyActivity .class);
                        intent.putExtra("userId", userId);
                        itemView.getContext().startActivity(intent);
                    }

                }
            });

        }

    }
}
