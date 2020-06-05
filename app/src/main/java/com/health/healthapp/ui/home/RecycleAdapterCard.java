package com.health.healthapp.ui.home;

/**
 * Created by Sulik on 1/3/2019.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.health.healthapp.R;
import com.health.healthapp.main.note_model;

import java.util.ArrayList;


public class RecycleAdapterCard extends RecyclerView.Adapter<RecycleAdapterCard.Reklama_viewholder> {
    ArrayList<note_model> list1;
    Context cntx;



    public class Reklama_viewholder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;
FrameLayout fr;
        public Reklama_viewholder(View itemView) {
            super(itemView);
            fr=(FrameLayout)itemView.findViewById(R.id.framecat);
            image = (ImageView) itemView.findViewById(R.id.imageMain);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }

    public RecycleAdapterCard(ArrayList<note_model> items, Context ctx) {
        this.list1 = items;
        this.cntx = ctx;

    }

    @Override
    public Reklama_viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.categorycard, parent, false);
        final Reklama_viewholder view = new Reklama_viewholder(v);
        return view;

    }

    @Override
    public void onBindViewHolder(final Reklama_viewholder holder, final int position) {
        holder.title.setText(list1.get(position).getName());
            //constants.category=list1.get(position).getId();

        holder.fr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
    @Override
    public int getItemCount() {
        return list1.size();
    }
    public void setData(ArrayList<note_model> food) {
        list1 = food;
        notifyDataSetChanged();
    }
}