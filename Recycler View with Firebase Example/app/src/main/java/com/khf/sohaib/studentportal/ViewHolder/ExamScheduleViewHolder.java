package com.khf.sohaib.studentportal.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.khf.sohaib.studentportal.Interface.ItemClickListener;
import com.khf.sohaib.studentportal.R;

public class ExamScheduleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView subjectExamSchedule;
    public TextView dateExamSchedule;
    public ImageView imgExamSchedule;

    private ItemClickListener itemClickListener;  //Delete all click listener


    public ExamScheduleViewHolder(@NonNull View itemView) {
        super(itemView);

        subjectExamSchedule = (TextView)itemView.findViewById(R.id.subjectExamSchedule);
        dateExamSchedule = (TextView)itemView.findViewById(R.id.dateExamSchedule);
        imgExamSchedule = (ImageView) itemView.findViewById(R.id.imgExamSchedule);

        itemView.setOnClickListener(this);  //Delete this

    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),false);
    }
}
