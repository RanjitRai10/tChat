package com.example.game.mysocialmedia.Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.game.mysocialmedia.Model.Follow;
import com.example.game.mysocialmedia.R;
import com.example.game.mysocialmedia.User_credential;
import com.example.game.mysocialmedia.databinding.UsersearchLayoutBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.viewHolder> {

    ArrayList<User_credential> list;
    Context context;

    public SearchAdapter(ArrayList list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.usersearch_layout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
            User_credential user = list.get(position);
        Picasso.get().load(user.getProfile_image()).placeholder(R.drawable.profile_img_01)
                .into(holder.image);
        holder.name.setText(user.getName());
        holder.profession.setText(user.getProfession());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        UsersearchLayoutBinding binding;
        ImageView image;
        TextView name,profession;
        Button followBtn;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.search_profile_image);
            name = itemView.findViewById(R.id.searchName);
            profession = itemView.findViewById(R.id.searchProfession);
            followBtn = itemView.findViewById(R.id.followButton);

        }
    }
}
