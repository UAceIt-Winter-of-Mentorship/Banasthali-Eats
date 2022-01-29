package com.example.banasthali_eats;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import android.os.Bundle;

public class PageAdapter extends FragmentPagerAdapter {

    private int numOfTabs;

    public PageAdapter(FragmentManager fragMgmt, int numOfTabs){
        super(fragMgmt);
        this.numOfTabs = numOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position){
        switch(position){
            case 0:
                snacks snack;
                snack = new snacks();
                return snack;
            case 1:
                mainCourse mc = new mainCourse();
                return mc;
            case 2:
                beverages beverage = new beverages();
                return beverage;
        }
        return null;
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_page_adapter);
//
//
//    }
}