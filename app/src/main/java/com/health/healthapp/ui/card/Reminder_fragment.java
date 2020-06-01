package com.health.healthapp.ui.card;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.health.healthapp.Adapter.MyRecyclerAdapter;
import com.health.healthapp.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Reminder_fragment extends Fragment {

    RecyclerView recyclerView;
    List<CardModel> models;
    MyRecyclerAdapter adapter;
    Button btnAdd;
    View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_card, container, false);
        models = new ArrayList<>();
        models.add(new CardModel("BloodPressure", "Daily- 8:00", "7 Days"));
        models.add(new CardModel("BloodPressure", "Daily- 8:00", "7 Days"));
        models.add(new CardModel("BloodPressure", "Daily- 8:00", "7 Days"));
        models.add(new CardModel("BloodPressure", "Daily- 8:00", "7 Days"));
        models.add(new CardModel("BloodPressure", "Daily- 8:00", "7 Days"));
        models.add(new CardModel("BloodPressure", "Daily- 8:00", "7 Days"));
        recyclerView = root.findViewById(R.id.recyclerView);
        adapter = new MyRecyclerAdapter(getActivity(), models);
        RecyclerView.LayoutManager LManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        RecyclerView.ItemAnimator animator = new DefaultItemAnimator();

        recyclerView.setLayoutManager(LManager);
        recyclerView.setItemAnimator((animator));
        recyclerView.setAdapter(adapter);

        initViews();
        controlView();
        return root;
    }

    private void initViews() {
        btnAdd = root.findViewById(R.id.btn_add);
    }

    private void controlView() {
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Add.class);
                startActivity(intent);
            }
        });
    }
}
