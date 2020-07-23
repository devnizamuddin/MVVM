package com.e.mvvm.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.e.mvvm.Model.User;
import com.e.mvvm.R;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    User[] users;

    public UserAdapter(User[] users) {
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_single_layout, parent,false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        User user = users[position];
        holder.one_et.setText(user.getLogin());
        holder.two_et.setText(String.valueOf(user.getId()));
        holder.three_et.setText(user.getReposUrl());
        Glide.with(holder.image_view.getContext()).load(user.getAvatarUrl()).into(holder.image_view);

    }

    @Override
    public int getItemCount() {
        return users.length;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        ImageView image_view;
        TextView one_et, two_et, three_et;


        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            image_view = itemView.findViewById(R.id.image_view);
            one_et = itemView.findViewById(R.id.one_et);
            two_et = itemView.findViewById(R.id.two_et);
            three_et = itemView.findViewById(R.id.three_et);

        }
    }
}
