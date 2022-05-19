package com.example.babydev;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class userAdapter extends RecyclerView.Adapter<userAdapter.myViewHolder>{

    private Context context;
    private List<userData> userList;

    public void setUserList(List<userData> userlist){
        this.userList = userlist;
        notifyDataSetChanged();
    }

    public userAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public userAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout1, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull userAdapter.myViewHolder holder, int position) {
        holder.tvGname.setText(this.userList.get(position).Gname);
        holder.tvBname.setText(this.userList.get(position).Bname);
        holder.tvDOB.setText(this.userList.get(position).DOB);
        holder.tvBirthWeight.setText(String.valueOf(this.userList.get(position).Bweight));
        holder.tvBirthHeight.setText(String.valueOf(this.userList.get(position).Bheight));
    }

    @Override
    public int getItemCount() {
        return this.userList.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{
      TextView tvGname, tvBname, tvDOB, tvBirthWeight, tvBirthHeight;
//        TextView tvGname, tvBname;

        public myViewHolder (View view){
            super(view);
            tvGname = view.findViewById(R.id.tvGname);
            tvBname = view.findViewById(R.id.tvBname);
            tvDOB = view.findViewById(R.id.tvDOB);
            tvBirthWeight = view.findViewById(R.id.tvBirthWeight);
            tvBirthHeight = view.findViewById(R.id.tvBirthHeight);
        }
    }
}
