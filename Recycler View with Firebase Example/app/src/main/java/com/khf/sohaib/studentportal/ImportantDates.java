package com.khf.sohaib.studentportal;

import android.content.Intent;
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

import com.khf.sohaib.studentportal.Model.ImportantDatesModel;
import com.khf.sohaib.studentportal.ViewHolder.ImportantDatesViewHolder;
import com.squareup.picasso.Picasso;

public class ImportantDates extends AppCompatActivity {

    FirebaseDatabase db;
    DatabaseReference categ;


    FirebaseRecyclerAdapter<ImportantDatesModel, ImportantDatesViewHolder> adapter;

    RecyclerView importantDatesList;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_important_dates);

        //InitFirebase
        db = FirebaseDatabase.getInstance();
        categ = db.getReference("ImportantDates");




       // RecyclerView importantDatesList = (RecyclerView)findViewById(R.id.importantDatesList);  uncomment All
       // importantDatesList.setLayoutManager(new LinearLayoutManager(this));
        //   String[] dateImportantDates = {"27/9/2018", "15/10/2018" , "27/7/2018","27/5/2018","27/9/2018","27/12/2018","20/12/2018","27/9/2018","27/9/2019","27/9/2018","10/3/2018"};
     //   String[] dayImportantDates = {"Holiday", "Result Day" , "Presentaion Day","Orientation Day","Mid Term","Presentation Day","Gaming Day","Programming Day","Eid","Ramazan","Defence Day"};
        // ImportantDatesAdapter adapter = new ImportantDatesAdapter(dateImportantDates,dayImportantDates);
      // importantDatesList.setAdapter(adapter);



        //load list
        importantDatesList = (RecyclerView)findViewById(R.id.importantDatesList);
        importantDatesList.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        importantDatesList.setLayoutManager(layoutManager);


        loadMenu();


        //   importantDatesList.setAdapter(new ImportantDatesAdapter(dateImportantDates,dayImportantDates));


    }

    private void loadMenu() {
        FirebaseRecyclerOptions<ImportantDatesModel> options = new FirebaseRecyclerOptions.Builder<ImportantDatesModel>()
                .setQuery(categ,ImportantDatesModel.class)
                .build();

        adapter = new FirebaseRecyclerAdapter<ImportantDatesModel, ImportantDatesViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ImportantDatesViewHolder viewHolder, int position, @NonNull ImportantDatesModel model) {
                viewHolder.dateImportantDates.setText(model.getDate());
                viewHolder.dayImportantDates.setText(model.getDay());
                Picasso.with(getBaseContext()).load(model.getImage())
                        .into(viewHolder.imgImportantDates);
                final ImportantDatesModel clickItem = model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {

                        Toast.makeText(ImportantDates.this, "Clicked", Toast.LENGTH_SHORT).show();
                        //Intent foodList = new Intent(Home.this, FoodList.class);
                        //foodList.putExtra("CategoryId", adapter.getRef(position).getKey());
                       // startActivity(foodList);
                    }
                });
            }

            @Override
            public ImportantDatesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_important_dates,parent,false);
                return new ImportantDatesViewHolder(itemView);
            }
        };

        importantDatesList.setAdapter(adapter);
        adapter.startListening();
    }


    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
