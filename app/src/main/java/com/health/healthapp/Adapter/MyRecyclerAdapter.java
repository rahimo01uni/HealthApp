package com.health.healthapp.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.health.healthapp.R;
import com.health.healthapp.ui.card.CardModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.myViewHolder> {
    private Activity context;
    private List<CardModel> models;

    public MyRecyclerAdapter(Activity context, List<CardModel> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(context).inflate(R.layout.custom_view,viewGroup, false);
        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
     CardModel model = models.get(position);
     holder.txtTitle.setText(model.getTitle());
     holder.txtRemainder.setText(model.getRemider());
     holder.txtLeftDays.setText(model.getLeftdays());


    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder {
      private TextView txtTitle, txtRemainder, txtLeftDays;
      private ConstraintLayout parent;
      //private ImageView pic;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.title);
            txtRemainder = itemView.findViewById(R.id.txt1);
            txtLeftDays = itemView.findViewById(R.id.txt2);
            //pic = itemView.findViewById(R.id.img1);

        }
    }
}
