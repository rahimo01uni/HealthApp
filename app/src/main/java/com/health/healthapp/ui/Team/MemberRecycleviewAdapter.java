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

public class MemberRecycleviewAdapter  extends RecyclerView.Adapter<MemberRecycleviewAdapter.MyViewHolder> {

private Context mContext;
private List<GroupMember> mData;
private OnEditLisener mOnEditListener;
public MemberRecycleviewAdapter(Context mContext, List<GroupMember> mData, OnEditLisener onEditLisener) {
        this.mContext = mContext;
        this.mData = mData;
        this.mOnEditListener = onEditLisener;
        }

@NonNull
@Override
public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.memberview_group, parent, false);

        return new MyViewHolder(view, mOnEditListener);
        }

@Override
public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.group_title.setText(mData.get(position).getTitle());
        }

@Override
public int getItemCount() {
        return mData.size();
        }

public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView group_title;
    OnEditLisener onEditLisener;

    public MyViewHolder(View itemView, OnEditLisener onEditLisener) {
        super(itemView);
        group_title = (TextView) itemView.findViewById(R.id.txt_mem);

        this.onEditLisener = onEditLisener;
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        onEditLisener.onMemberClick(getAdapterPosition());

    }
}

    public interface OnEditLisener{
        void onMemberClick(int position);
    }
}

