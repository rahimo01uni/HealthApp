package com.health.healthapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;


import com.health.healthapp.Database.DatabaseHelper;
import com.health.healthapp.R;
import com.health.healthapp.main.note_model;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    TabLayout tabLayout;
    TextView text;
    RecyclerView  all_view;
    RecycleAdapterCard adapterCard;
     DatabaseHelper db;
     FloatingActionButton add;
     ViewPager viewPager;
     SectionsPagerAdapter sectionsPagerAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        db=new DatabaseHelper(getActivity());

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        all_view=root.findViewById(R.id.recycler);
        adapterCard = new RecycleAdapterCard(db.getData(),getActivity());
        all_view.setAdapter(adapterCard);
        tabLayout=root.findViewById(R.id.home_tab);
        text=root.findViewById(R.id.home);
        add=root.findViewById(R.id.floatingActionButton4);

      //  viewPager=root.findViewById(R.id.viewpager);
    //    sectionsPagerAdapter = new SectionsPagerAdapter();

      //  viewPager.setAdapter(sectionsPagerAdapter);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                  text.setText(""+tab.getText()+ db.insertData(new note_model(0,"","","","","","",
                          "","")));
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