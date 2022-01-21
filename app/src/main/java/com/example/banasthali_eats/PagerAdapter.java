package com.example.banasthali_eats;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    private int numOfTabs;

    public PagerAdapter(FragmentManager fm,int numOfTabs){
        super(fm);
        this.numOfTabs = numOfTabs;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                chats s = new chats();
                return s;
            case 1:
                status d = new status();
                return d;
            case 2:
                calls k = new calls();
                return k;

        }
        return null;
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}

