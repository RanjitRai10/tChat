package com.example.game.mysocialmedia.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.game.mysocialmedia.Adapter.followerAdapter;
import com.example.game.mysocialmedia.Model.myFriendsModelProfile;
import com.example.game.mysocialmedia.R;
import com.example.game.mysocialmedia.User_credential;
import com.example.game.mysocialmedia.databinding.FragmentProfileBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Objects;


public class ProfileFragment extends Fragment {

    RecyclerView recyclerView;
    FragmentProfileBinding binding;
    ArrayList<myFriendsModelProfile> list;
    FirebaseAuth auth;
    FirebaseStorage storage;
    FirebaseDatabase database;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        auth = FirebaseAuth.getInstance();
        storage = FirebaseStorage.getInstance();
        database = FirebaseDatabase.getInstance();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        database.getReference().child("Users").child(Objects.requireNonNull(auth.getUid())).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    User_credential user_credential = snapshot.getValue(User_credential.class);
                    assert user_credential != null;
                    Picasso.get().load(user_credential.getCoverPhoto()).placeholder(R.drawable.story_img)
                            .into(binding.coverPhoto);
                    Picasso.get().load(user_credential.getProfile_image()).placeholder(R.drawable.profile_img_01).into(binding.profileImage);
                    binding.userName.setText(user_credential.getName());
                    binding.userProfession.setText(user_credential.getProfession());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        recyclerView = view.findViewById(R.id.friendRV);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        list = new ArrayList<>();
        list.add(new myFriendsModelProfile(R.drawable.profile_img_01));
        list.add(new myFriendsModelProfile(R.drawable.story_img));
        list.add(new myFriendsModelProfile(R.drawable.profile_img_01));
        list.add(new myFriendsModelProfile(R.drawable.story_img));
        list.add(new myFriendsModelProfile(R.drawable.profile_img_01));
        list.add(new myFriendsModelProfile(R.drawable.profile_img_01));
        list.add(new myFriendsModelProfile(R.drawable.profile_img_01));
        list.add(new myFriendsModelProfile(R.drawable.profile_img_01));
        list.add(new myFriendsModelProfile(R.drawable.profile_img_01));

        followerAdapter adapter = new followerAdapter(list, getContext());
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(adapter);

        ImageView changeCover = view.findViewById(R.id.changeCoverPhoto);

        changeCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 11);

            }
        });

        ImageView profile_image = view.findViewById(R.id.profileImage);
        profile_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 22);

            }
        });


        return view;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 11) {
            assert data != null;
            if (data.getData() != null) {
                Uri uri = data.getData();
                binding.coverPhoto.setImageURI(uri);

                final StorageReference reference = storage.getReference().child("cover_photo").child(Objects.requireNonNull(FirebaseAuth.getInstance().getUid()));
                reference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                database.getReference().child("Users").child(Objects.requireNonNull(auth.getUid())).child("coverPhoto").setValue(uri.toString());
                            }
                        });
                    }
                });

            }
        } else {
            assert data != null;
            if (data.getData() != null) {
                Uri uri = data.getData();
                binding.profileImage.setImageURI(uri);
                final StorageReference reference = storage.getReference().child("profile_image").child(Objects.requireNonNull(FirebaseAuth.getInstance().getUid()));
                reference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                database.getReference().child("Users").child(Objects.requireNonNull(auth.getUid())).child("profile_image").setValue(uri.toString());
                            }
                        });
                    }
                });

            }
        }
    }
}