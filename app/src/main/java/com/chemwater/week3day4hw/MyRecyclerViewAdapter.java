package com.chemwater.week3day4hw;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent ;
import android.os.Bundle ;
import android.util.Log ;
import android.view.LayoutInflater ;
import android.widget.RatingBar ;
import android.widget.TextView ;
import android.widget.Toast ;

import org.w3c.dom.Text;

import java.util.ArrayList ;
import java.util.Collections;


public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    //List of Animals that will be populated into the recycler view
    ArrayList<User> usersArrayList ;

    //TextView

    //Constructor for the Adapter
    public MyRecyclerViewAdapter(ArrayList<User> usersArrayList) {
        this.usersArrayList = usersArrayList ;
    }

    public void addUserToList(User users) {
        usersArrayList.add(users) ;
        notifyDataSetChanged() ;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        User currentUsersBeingPopulated = usersArrayList.get(position) ;
        viewHolder.username.setText(currentUsersBeingPopulated.getUserName()) ;
        viewHolder.useremail.setText(currentUsersBeingPopulated.getUserEmail()) ;
        viewHolder.userpassword.setText(currentUsersBeingPopulated.getPassWord()) ;


        Log.d("TAG", "onBindViewHolder: item being rendered = " + position) ;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {


        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.user_item, viewGroup, false));
    }


    @Override
    public int getItemCount() {
        return usersArrayList.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView username, useremail, userpassword ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView) ;
            username = itemView.findViewById(R.id.tvUserName) ;
            useremail = itemView.findViewById(R.id.tvUserEmail) ;
            userpassword = itemView.findViewById(R.id.tvUserPassword) ;


        }
    }



}
