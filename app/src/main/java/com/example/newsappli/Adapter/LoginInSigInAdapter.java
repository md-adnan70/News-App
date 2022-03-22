package com.example.newsappli.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class LoginInSigInAdapter extends FragmentPagerAdapter {
    //Initialize arraylist
    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    ArrayList<String> stringArrayList = new ArrayList<>();

    // create constructor
    public void AddFragment(Fragment fragment,String s){
        //add fragment
        fragmentArrayList.add(fragment);
        //add string
        stringArrayList.add(s);
    }

    public LoginInSigInAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        //return fragment position
        return fragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        // return fragment list size
        return fragmentArrayList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        // return tab title
        return stringArrayList.get(position);
    }
}
