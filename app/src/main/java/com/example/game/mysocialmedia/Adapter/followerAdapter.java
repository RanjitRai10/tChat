package com.example.game.mysocialmedia.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.game.mysocialmedia.Model.myFriendsModelProfile;
import com.example.game.mysocialmedia.R;
import com.example.game.mysocialmedia.databinding.MyfriendsLayoutBinding;

import java.util.ArrayList;

public class followerAdapter extends RecyclerView.Adapter<followerAdapter.viewHolder> {

    ArrayList<myFriendsModelProfile> list;
    Context context;

    public followerAdapter(ArrayList<myFriendsModelProfile> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.myfriends_layout, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        myFriendsModelProfile model = list.get(position);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {

        MyfriendsLayoutBinding binding;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            binding = MyfriendsLayoutBinding.bind(itemView);
        }


    }
}
