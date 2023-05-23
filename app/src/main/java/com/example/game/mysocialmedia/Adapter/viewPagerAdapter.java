package com.example.game.mysocialmedia.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.game.mysocialmedia.fragment.notification2;
import com.example.game.mysocialmedia.fragment.request;

public class viewPagerAdapter extends FragmentPagerAdapter {

    public viewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new notification2();
            case 1: return new request();
            default: return new notification2();
        }
            }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if(position == 0){ title = "Notifications";}
        else if(position == 1){ title = "Requests";}
        return title;
    }
}
