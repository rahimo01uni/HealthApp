package com.health.healthapp.ui.Team;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.health.healthapp.Adapter.MyRecyclerAdapter;
import com.health.healthapp.R;
import com.health.healthapp.ui.medication.Addmedication;


import java.util.ArrayList;
import java.util.List;

public class Memberlist extends AppCompatActivity implements MemberRecycleviewAdapter.OnEditLisener{
    RecyclerView recyclerView;
    List<GroupMember> models;
    MemberRecycleviewAdapter adapter;
    FloatingActionButton btnAddLog;
    ImageView btnCloselog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memberlist);

        models = new ArrayList<>();
        models.add(new GroupMember("Dentist"));
        models.add(new GroupMember("Ali"));
        models.add(new GroupMember("Zahra"));


        recyclerView = findViewById(R.id.recycleView_member);
        adapter = new MemberRecycleviewAdapter(this, models, this);
        RecyclerView.LayoutManager LManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView.ItemAnimator animator = new DefaultItemAnimator();

        recyclerView.setLayoutManager(LManager);
        recyclerView.setItemAnimator((animator));
        recyclerView.setAdapter(adapter);


        btnAddLog = findViewById(R.id.btn_addlog);
        btnAddLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

    }
    public void openDialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // add a list
        final View customLayout = getLayoutInflater().inflate(R.layout.alert_addlog, null);
        builder.setView(customLayout);

        // create and show the alert dialog
      final   AlertDialog dialog = builder.create();

        btnCloselog = customLayout.findViewById(R.id.btn_closelog);
        btnCloselog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        dialog.show();



    }

    @Override
    public void onMemberClick(int position) {
       Intent intent = new Intent(this, EditMemList.class);
       //intent.putExtra("denti","ddd");
       startActivity(intent);
    }
}
