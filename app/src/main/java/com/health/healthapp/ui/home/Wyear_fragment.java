package com.health.healthapp.ui.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.health.healthapp.Database.DatabaseHelper;
import com.health.healthapp.R;
import com.health.healthapp.ui.medication.Addmedication;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import ru.slybeaver.slycalendarview.SlyCalendarDialog;

public class Wyear_fragment extends Fragment implements SearchView.OnQueryTextListener,SlyCalendarDialog.Callback {

    RecyclerView recyclerView;
   ArrayList<LogModel> models;
Adapter adapter;
 //   Button btnAdd;
    View root;
    FloatingActionButton btn;
   DatabaseHelper db;
    SearchView editsearch;
   public static Handler visible;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_wmyear, container, false);
        models = new ArrayList<>();
        models.add(new LogModel("BloodPressure", "Measurements", "08:08",R.drawable.bloodicon,"1"));
        models.add(new LogModel("Mk", "Measurements", "08:08",R.drawable.mood_icon,"-1"));
        models.add(new LogModel("Pl", "Measurements", "08:08",1,"0"));
        models.add(new LogModel("mm", "Measurements", "08:08",0,"-1"));
        models.add(new LogModel("BloodPressure", "Measurements", "08:08",0,"-1"));
        models.add(new LogModel("BloodPressure", "Measurements", "08:08",0,"-1"));
        models.add(new LogModel("BloodPressure", "Measurements", "08:08",0,"-1"));

        editsearch = root.findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);
        editsearch.setMinimumHeight(0);
        visible=new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {

                    editsearch.setMinimumHeight(50);
            }
        };
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
                //   openDialog();
                new SlyCalendarDialog()
                        .setSingle(false)
                        .setCallback(Wyear_fragment.this)
                        .show(getActivity().getSupportFragmentManager(), "TAG_SLYCALENDAR");
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

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase(Locale.getDefault());
        ArrayList<LogModel> temp=models;
        ArrayList<LogModel> temp2=new ArrayList<>();
        if (newText.length() == 0) {
            temp2.addAll(temp);
        } else {
            for (LogModel wp : temp) {
                if (wp.getName().toLowerCase(Locale.getDefault()).contains(newText)) {
                    temp2.add(wp);
                }
            }


        }
        adapter.setData(temp2);

        return false;

    }

    @Override
    public void onCancelled() {

    }

    @Override
    public void onDataSelected(Calendar firstDate, Calendar secondDate, int hours, int minutes) {

    }
}
