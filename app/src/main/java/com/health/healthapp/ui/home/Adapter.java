package com.health.healthapp.ui.home;

import android.app.Activity;
import android.icu.text.LocaleDisplayNames;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.health.healthapp.R;
import com.health.healthapp.ui.Reminder.CardModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {
    private Activity context;
    private List<LogModel> models;

    public Adapter(Activity context, List<LogModel> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(context).inflate(R.layout.log_card,viewGroup, false);
        return new myViewHolder(v);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.txtTitle.setText(models.get(position).getName());
        holder.txtCategory.setText(models.get(position).getCategory());
        holder.time.setText(models.get(position).getTime());
   /*     Glide.with(context)
                .load(context.getResources()
                        .getIdentifier(models.get(position).getImg(), "drawable", context.getPackageName())).asBitmap().into(holder.icon);*/
if(models.get(position).getImg()>1)      holder.icon.setImageResource(models.get(position).getImg());
        // we should change here later
       if(models.get(position).status.equals("1")) holder.status.setBackgroundResource(R.drawable.triangle_green);
       else
           if (models.get(position).status.equals("-1"))
               holder.status.setBackgroundResource(R.drawable.triangle_red);
           else
               holder.status.setBackgroundResource(R.drawable.triangle_white);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTitle, txtCategory, time;
        private ImageView icon;
        private ConstraintLayout parent;
        private RelativeLayout status;
        //private ImageView pic;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.name);
            txtCategory = itemView.findViewById(R.id.category);
            time = itemView.findViewById(R.id.time);
            icon = itemView.findViewById(R.id.imageView);
            status=itemView.findViewById(R.id.status);

        }
    }
    public void setData(ArrayList<LogModel> food) {
        models = food;
        notifyDataSetChanged();
    }

}
