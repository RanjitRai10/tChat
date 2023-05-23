package com.example.game.mysocialmedia.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.game.mysocialmedia.Model.storyModel;
import com.example.game.mysocialmedia.R;

import java.util.ArrayList;

public class storyAdapter extends RecyclerView.Adapter<storyAdapter.viewHolder>{

    ArrayList<storyModel> list;
    Context context;

    public storyAdapter(ArrayList<storyModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public storyAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.story_other_design,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        storyModel model = list.get(position);
        holder.storyImg.setImageResource(model.getStory());
        holder.profile.setImageResource(model.getProfile());
        holder.name.setText(model.getName());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView storyImg,profile;
        TextView name;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            storyImg = itemView.findViewById(R.id.myStoryProfileStory);
            profile = itemView.findViewById(R.id.profile_image_small_story);
            name = itemView.findViewById(R.id.name_story);

        }
    }
}
