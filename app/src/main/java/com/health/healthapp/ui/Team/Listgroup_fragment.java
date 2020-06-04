package com.health.healthapp.ui.Team;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.health.healthapp.R;

import java.util.ArrayList;
import java.util.List;

public class Listgroup_fragment extends Fragment {
    List<Group> lstGroup;
    View root;
   FloatingActionButton btnAdd;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.activity_listgroup, container, false);

        lstGroup = new ArrayList<>();
        lstGroup.add(new Group("Doctors", R.drawable.share_icon));
        lstGroup.add(new Group("Family", R.drawable.share_icon));
        lstGroup.add(new Group("Friends", R.drawable.share_icon));

        RecyclerView myrv = root.findViewById(R.id.recycleView_group);
        GroupRecycleviewAdapter myAdapter = new GroupRecycleviewAdapter(getActivity(), lstGroup);
        myrv.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        myrv.setAdapter(myAdapter);


        initViews();
        controlView();
        return root;
    }

    private void initViews() {
        btnAdd = root.findViewById(R.id.btnAdd);
    }

    private void controlView() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Addgroup.class);
                startActivity(intent);

            }
        });
    }
}