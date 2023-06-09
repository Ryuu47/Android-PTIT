package com.example.sachtablayout.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.sachtablayout.fragment.FragmentDS;
import com.example.sachtablayout.fragment.FragmentInfo;
import com.example.sachtablayout.fragment.FragmentStatistic;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new FragmentDS();

            case 1:
                return new FragmentInfo();
            case 2:
                return new FragmentStatistic();

            default: return new FragmentDS();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title="";
        switch (position){
            case 0:
                title= "Home";
                break;
            case 1:
                title= "Info";
                break;
            case 2:
                title= "Statistic";
                break;
        }
        return title;
    }
}
