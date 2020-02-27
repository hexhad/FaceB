package com.hexhad.faceb;

import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyFirstAdapter extends FragmentPagerAdapter {

    public MyFirstAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return FragmentOne.fragmentOne();
            case 1:
                return FragmentTwo.fragmenttwo();
            case 2:
                return FragmentThree.fragmentthree();
            default:
                return FragmentOne.fragmentOne();
        }
    }


    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
//        return super.getPageTitle(position);
        return "page" + (position + 1);
    }
}
