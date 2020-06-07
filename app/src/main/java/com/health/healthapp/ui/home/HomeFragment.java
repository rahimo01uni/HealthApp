package com.health.healthapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.health.healthapp.R;
import com.health.healthapp.ui.Reminder.Reminder_fragment;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    TabLayout tabLayout;
    TextView text;
    ViewPager viewPager;
    RecyclerView  all_view;
    SectionsPagerAdapter sectionsPagerAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        tabLayout=root.findViewById(R.id.home_tab);
       // text=root.findViewById(R.id.home);
      //  all_view=root.findViewById(R.id.recyclerView);
       //all_view.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        sectionsPagerAdapter = new SectionsPagerAdapter(getActivity().getSupportFragmentManager());
        viewPager = root.findViewById(R.id.viewpager);
        sectionsPagerAdapter.AddFragment(new Today_fragment(), "Today");
        sectionsPagerAdapter.AddFragment(new Week_fragment(), "Week");
        sectionsPagerAdapter.AddFragment(new Month_fragment(), "Month");
        sectionsPagerAdapter.AddFragment(new Year_fragment(), "Year");
        viewPager.setAdapter(sectionsPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                  text.setText(""+tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




        return root;
    }
    void Init(){


    }

}