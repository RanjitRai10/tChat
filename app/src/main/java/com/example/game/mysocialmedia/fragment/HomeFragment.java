package com.example.game.mysocialmedia.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.game.mysocialmedia.Adapter.dashboardAdapter;
import com.example.game.mysocialmedia.Adapter.storyAdapter;
import com.example.game.mysocialmedia.Model.dashboarModel;
import com.example.game.mysocialmedia.Model.storyModel;
import com.example.game.mysocialmedia.R;
import com.example.game.mysocialmedia.User_credential;
import com.example.game.mysocialmedia.databinding.FragmentHomeBinding;
import com.example.game.mysocialmedia.databinding.FragmentProfileBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Objects;

public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    RecyclerView storyRv,postRv;
    ArrayList<storyModel> list = new ArrayList<>();
    ArrayList<dashboarModel> dashboardList = new ArrayList<>();
    FirebaseAuth auth;
    FirebaseStorage storage;
    FirebaseDatabase database;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();
        storage = FirebaseStorage.getInstance();
        database = FirebaseDatabase.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        storyRv = view.findViewById(R.id.storyOther);
        database.getReference().child("Users").child(Objects.requireNonNull(auth.getUid())).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    User_credential user_credential = snapshot.getValue(User_credential.class);
                    assert user_credential != null;
                    ImageView profile_image = view.findViewById(R.id.profile_image);
                    Picasso.get().load(user_credential.getProfile_image()).placeholder(R.drawable.profile_img_01).into(profile_image);
                    Picasso.get().load(user_credential.getProfile_image()).placeholder(R.drawable.profile_img_01).into(binding.myStoryProfile);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        list = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        storyRv.setLayoutManager(linearLayoutManager);
        list.add(new storyModel("vikrant",R.drawable.story_demo,R.drawable.profile_img_01));
        list.add(new storyModel("Mehek",R.drawable.profile_img_01,R.drawable.profile_img_01));
        list.add(new storyModel("Priya",R.drawable.profile_img_01,R.drawable.profile_img_01));
        list.add(new storyModel("Aniket",R.drawable.profile_img_01,R.drawable.profile_img_01));
        list.add(new storyModel("Oshi",R.drawable.profile_img_01,R.drawable.profile_img_01));
        list.add(new storyModel("vikrant",R.drawable.profile_img_01,R.drawable.profile_img_01));

        storyAdapter adapter = new storyAdapter(list,getContext());
        storyRv.setNestedScrollingEnabled(false);
        storyRv.setAdapter(adapter);


        postRv = view.findViewById(R.id.postRv);
        dashboardList.add(new dashboarModel(R.drawable.profile_img_01,R.drawable.story_img,"alone_xavier1","Hill , Mountains" ,"229","31","5"));
        dashboardList.add(new dashboarModel(R.drawable.profile_img_01,R.drawable.story_img,"ranjit_rai02","Hill , Mountains" ,"229","31","5"));
        dashboardAdapter dashboardAdapter = new dashboardAdapter(getContext(), dashboardList);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        postRv.setLayoutManager(linearLayoutManager1);
        postRv.setNestedScrollingEnabled(false);
        postRv.setAdapter(dashboardAdapter);


        return view;
    }
}