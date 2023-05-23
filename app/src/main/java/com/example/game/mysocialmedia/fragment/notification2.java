package com.example.game.mysocialmedia.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.game.mysocialmedia.Adapter.NotificationAdapter;
import com.example.game.mysocialmedia.Adapter.viewPagerAdapter;
import com.example.game.mysocialmedia.Model.NotificationModel;
import com.example.game.mysocialmedia.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class notification2 extends Fragment {

    RecyclerView notificationRv;
    ArrayList<NotificationModel> list= new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification2, container, false);
        notificationRv = view.findViewById(R.id.notificationRV);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        notificationRv.setLayoutManager(linearLayoutManager);
        list = new ArrayList<>();
        list.add(new NotificationModel(R.drawable.profile_img_01,"<b>alone_xavier1</b> mentioned you in the comment","Just now"));
        list.add(new NotificationModel(R.drawable.profile_img_01,"<b>anupriyaaa</b> liked your photo","12:23"));
        list.add(new NotificationModel(R.drawable.profile_img_01,"<b>Ranjit Rai</b> commented on your photo","13:23"));
        list.add(new NotificationModel(R.drawable.profile_img_01,"<b>anupriyaaa</b> mentioned you in the comment","10:23"));
        list.add(new NotificationModel(R.drawable.profile_img_01,"<b>Ranjit Rai</b> commented on your photo","14:23"));
        list.add(new NotificationModel(R.drawable.profile_img_01,"<b>alone_xavier1</b> mentioned you in the comment","14:23"));
        list.add(new NotificationModel(R.drawable.profile_img_01,"<b>Ranjit Rai</b> commented on your photo","14:23"));
        list.add(new NotificationModel(R.drawable.profile_img_01,"<b>anupriyaaa</b> mentioned you in the comment","14:23"));
        list.add(new NotificationModel(R.drawable.profile_img_01,"<b>alone_xavier1</b> mentioned you in the comment","14:23"));
        list.add(new NotificationModel(R.drawable.profile_img_01,"<b>anupriyaaa</b> mentioned you in the comment","14:23"));
        list.add(new NotificationModel(R.drawable.profile_img_01,"<b>alone_xavier1</b> mentioned you in the comment","14:23"));
        list.add(new NotificationModel(R.drawable.profile_img_01,"<b>anupriyaaa</b> mentioned you in the comment","14:23"));
        list.add(new NotificationModel(R.drawable.profile_img_01,"<b>alone_xavier1</b> mentioned you in the comment","14:23"));
        list.add(new NotificationModel(R.drawable.profile_img_01,"<b>alone_xavier1</b> mentioned you in the comment","14:23"));
        list.add(new NotificationModel(R.drawable.profile_img_01,"<b>anupriyaaa</b> mentioned you in the comment","14:23"));
        list.add(new NotificationModel(R.drawable.profile_img_01,"<b>alone_xavier1</b> mentioned you in the comment","14:23"));
        list.add(new NotificationModel(R.drawable.profile_img_01,"<b>alone_xavier1</b> mentioned you in the comment","14:23"));
        list.add(new NotificationModel(R.drawable.profile_img_01,"<b>anupriyaaa</b> mentioned you in the comment","14:23"));
        list.add(new NotificationModel(R.drawable.profile_img_01,"<b>alone_xavier1</b> mentioned you in the comment","14:23"));
        list.add(new NotificationModel(R.drawable.profile_img_01,"<b>alone_xavier1</b> mentioned you in the comment","14:23"));
        list.add(new NotificationModel(R.drawable.profile_img_01,"<b>anupriyaaa</b> mentioned you in the comment","14:23"));
        list.add(new NotificationModel(R.drawable.profile_img_01,"<b>alone_xavier1</b> mentioned you in the comment","14:23"));
        list.add(new NotificationModel(R.drawable.profile_img_01,"<b>alone_xavier1</b> mentioned you in the comment","14:23"));

        NotificationAdapter adapter = new NotificationAdapter(list,getContext());
        notificationRv.setNestedScrollingEnabled(false);
        notificationRv.setAdapter(adapter);
        Log.d("NotificationFrag2","Notification Fragment successful");





        return view;
    }


}