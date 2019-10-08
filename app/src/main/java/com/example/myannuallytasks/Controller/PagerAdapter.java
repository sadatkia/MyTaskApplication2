package com.example.myannuallytasks.Controller;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {


    public PagerAdapter(FragmentManager FM,int NumberOfTabs) {
        super(FM);

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
               To_Do_Fragment tab1 = To_Do_Fragment.newInstance();
                return tab1;
            case 1:
               Doing_Fragment tab2 = Doing_Fragment.newInstance();
                return tab2;
            case 2:
               Done_Fragment tab3 = Done_Fragment.newInstance();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
