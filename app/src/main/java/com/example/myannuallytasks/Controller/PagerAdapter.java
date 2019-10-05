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
               To_Do_Fragment tab1 = new To_Do_Fragment();
                return tab1;
            case 1:
               Doing_Fragment tab2 = new Doing_Fragment();
                return tab2;
            case 2:
               Done_Fragment tab3 = new Done_Fragment();
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
