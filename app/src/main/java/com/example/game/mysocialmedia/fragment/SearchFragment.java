package com.example.game.mysocialmedia.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.game.mysocialmedia.Adapter.SearchAdapter;
import com.example.game.mysocialmedia.R;
import com.example.game.mysocialmedia.User_credential;
import com.example.game.mysocialmedia.databinding.FragmentSearchBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class SearchFragment extends Fragment {

    FirebaseDatabase database;
    FirebaseAuth auth;
    ArrayList<User_credential> list = new ArrayList<>();
    private FragmentSearchBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false);

        SearchAdapter adapter = new SearchAdapter(list,getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.searchRV.setLayoutManager(layoutManager);
        binding.searchRV.setAdapter(adapter);

        database.getReference().child("Users").addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    User_credential user_credential = dataSnapshot.getValue(User_credential.class);
                    user_credential.setUserId(dataSnapshot.getKey());
                    list.add(user_credential);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return binding.getRoot();
    }
}