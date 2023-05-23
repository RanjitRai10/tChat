package com.example.game.mysocialmedia.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.game.mysocialmedia.Adapter.viewPagerAdapter;
import com.example.game.mysocialmedia.R;
import com.google.android.material.tabs.TabLayout;


public class NotificationFragment extends Fragment {

  ViewPager viewPager;
  TabLayout tabLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
        viewPager = view.findViewById(R.id.viewPager);
        assert getFragmentManager() != null;
        viewPager.setAdapter(new viewPagerAdapter(getFragmentManager()));
        Log.d("NotificationFrag","Notification Fragment successful");
        tabLayout = view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}