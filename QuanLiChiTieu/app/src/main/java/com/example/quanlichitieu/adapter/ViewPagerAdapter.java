package com.example.quanlichitieu.adapter;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.quanlichitieu.fragment.FragmentHistory;
import com.example.quanlichitieu.fragment.FragmentHome;
import com.example.quanlichitieu.fragment.FragmentSearch;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {


    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

//    public void addFragment(Fragment fragment){
//        listFragment.add(fragment);
//    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:return new FragmentHome();
            case 1:return new FragmentHistory();
            case 2:return new FragmentSearch();

        }
        return new FragmentHome();
    }

    @Override
    public int getCount() {
        return 3;
    }
}
