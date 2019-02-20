package com.khf.sohaib.studentportal.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.khf.sohaib.studentportal.Interface.ItemClickListener;
import com.khf.sohaib.studentportal.R;

public class ImportantDatesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView dateImportantDates;
    public TextView dayImportantDates;
    public ImageView imgImportantDates;

    private ItemClickListener itemClickListener;  //Delete all click listener


    public ImportantDatesViewHolder(@NonNull View itemView) {
        super(itemView);

        dateImportantDates = (TextView)itemView.findViewById(R.id.dateImportantDates);
        dayImportantDates = (TextView)itemView.findViewById(R.id.dayImportantDates);
        imgImportantDates = (ImageView) itemView.findViewById(R.id.imgImportantDates);

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
