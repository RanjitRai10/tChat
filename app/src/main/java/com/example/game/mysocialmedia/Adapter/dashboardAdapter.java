package com.example.game.mysocialmedia.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.game.mysocialmedia.Model.dashboarModel;
import com.example.game.mysocialmedia.R;

import java.util.ArrayList;

public class dashboardAdapter extends RecyclerView.Adapter<dashboardAdapter.viewHolder> {

    Context context;
    ArrayList<dashboarModel> list;

    public dashboardAdapter(Context context, ArrayList<dashboarModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.dashboard_layout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        dashboarModel model = list.get(position);

        holder.profileImg.setImageResource(model.getProfileImg());
        holder.post.setImageResource(model.getPost());
        holder.name.setText(model.getName());
        holder.about.setText(model.getAbout());
        holder.like.setText(model.getLike());
        holder.comment.setText(model.getComment());
        holder.share.setText(model.getShare());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        ImageView profileImg,post;
        TextView name,about,like,comment,share;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            profileImg = itemView.findViewById(R.id.profile_image_post);
            post = itemView.findViewById(R.id.postImg);
            name = itemView.findViewById(R.id.profile_name_post);
            about = itemView.findViewById(R.id.about);
            like = itemView.findViewById(R.id.postLike);
            comment = itemView.findViewById(R.id.postComment);
            share = itemView.findViewById(R.id.postShare);

        }
    }
}
