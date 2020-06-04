package com.health.healthapp.ui.Team;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.health.healthapp.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GroupRecycleviewAdapter extends RecyclerView.Adapter<GroupRecycleviewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Group> mData;

    public GroupRecycleviewAdapter(Context mContext, List<Group> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_group, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       holder.group_title.setText(mData.get(position).getTitle());
       holder.group_img.setImageResource(mData.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView group_title;
        ImageView group_img;

        public MyViewHolder(View itemView) {
            super(itemView);

            group_title = (TextView) itemView.findViewById(R.id.txt_gtitle);
            group_img = (ImageView) itemView.findViewById(R.id.img_gimg);

        }
    }
}
