package com.khf.sohaib.studentportal;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.khf.sohaib.studentportal.Interface.ItemClickListener;
import com.khf.sohaib.studentportal.Model.ExamScheduleModel;
import com.khf.sohaib.studentportal.Model.ImportantDatesModel;
import com.khf.sohaib.studentportal.ViewHolder.ExamScheduleViewHolder;
import com.khf.sohaib.studentportal.ViewHolder.ImportantDatesViewHolder;
import com.squareup.picasso.Picasso;

public class ExamSchedule extends AppCompatActivity {

    FirebaseDatabase db;
    DatabaseReference category;


    FirebaseRecyclerAdapter<ExamScheduleModel, ExamScheduleViewHolder> adapter;

    RecyclerView examScheduleList;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_schedule);

        //InitFirebase
        db = FirebaseDatabase.getInstance();
        category = db.getReference("ExamSchedule");

        //load list
        examScheduleList = (RecyclerView)findViewById(R.id.examScheduleList);
        examScheduleList.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        examScheduleList.setLayoutManager(layoutManager);


        loadMenu();

    }

    private void loadMenu() {

        FirebaseRecyclerOptions<ExamScheduleModel> options = new FirebaseRecyclerOptions.Builder<ExamScheduleModel>()
                .setQuery(category,ExamScheduleModel.class)
                .build();

        adapter = new FirebaseRecyclerAdapter<ExamScheduleModel, ExamScheduleViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ExamScheduleViewHolder viewHolder, int position, @NonNull ExamScheduleModel model) {
                viewHolder.subjectExamSchedule.setText(model.getSubject());
                viewHolder.dateExamSchedule.setText(model.getDate());
                Picasso.with(getBaseContext()).load(model.getImage())
                        .into(viewHolder.imgExamSchedule);
                final ExamScheduleModel clickItem = model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {

                        Toast.makeText(ExamSchedule.this, "Clicked", Toast.LENGTH_SHORT).show();
                        //Intent foodList = new Intent(Home.this, FoodList.class);
                        //foodList.putExtra("CategoryId", adapter.getRef(position).getKey());
                        // startActivity(foodList);
                    }
                });
            }

            @Override
            public ExamScheduleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_exam_schedule,parent,false);
                return new ExamScheduleViewHolder(itemView);
            }
        };

        examScheduleList.setAdapter(adapter);
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
