package com.health.healthapp.ui.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.health.healthapp.Adapter.MyRecyclerAdapter;
import com.health.healthapp.Database.DatabaseHelper;
import com.health.healthapp.R;
import com.health.healthapp.ui.Reminder.CardModel;
import com.health.healthapp.ui.medication.Addmedication;


import java.util.ArrayList;
import java.util.List;

public class Today_fragment extends Fragment {

    RecyclerView recyclerView;
    List<LogModel> models;
Adapter adapter;
 //   Button btnAdd;
    View root;
    FloatingActionButton btn;
DatabaseHelper db;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_today, container, false);
        models = new ArrayList<>();
        models.add(new LogModel("BloodPressure", "Measurements", "08:08",R.drawable.bloodicon,"1"));
        models.add(new LogModel("BloodPressure", "Measurements", "08:08",R.drawable.mood_icon,"-1"));
        models.add(new LogModel("BloodPressure", "Measurements", "08:08",1,"0"));
        models.add(new LogModel("BloodPressure", "Measurements", "08:08",0,"-1"));
        models.add(new LogModel("BloodPressure", "Measurements", "08:08",0,"-1"));
        models.add(new LogModel("BloodPressure", "Measurements", "08:08",0,"-1"));
        models.add(new LogModel("BloodPressure", "Measurements", "08:08",0,"-1"));
        db=new DatabaseHelper(getActivity());
        recyclerView = root.findViewById(R.id.recyclerView);
        btn=root.findViewById(R.id.today_btn);
        adapter = new Adapter(getActivity(), models);
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
        //btnAdd = root.findViewById(R.id.btn_add);
    }

    private void controlView() {
       btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(getContext(), Add.class);
                //startActivity(intent);
                openDialog();
            }
        });
    }

   public void openDialog(){




       AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
       builder.setTitle("Add a new element");

      // add a list
       final View customLayout = getLayoutInflater().inflate(R.layout.alert, null);
       builder.setView(customLayout);
       TextView txt_medication= customLayout.findViewById(R.id.txt_medication);

       txt_medication.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(getContext(), Addmedication.class);
                                    startActivity(intent);
                                }
                            });


       builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
           @Override
           public void onClick(DialogInterface dialog, int i) {

           }
       });
      // create and show the alert dialog
       AlertDialog dialog = builder.create();
       dialog.show();

   }

}
