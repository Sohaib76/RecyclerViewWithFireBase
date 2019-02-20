//package com.khf.sohaib.studentportal;
//
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//public class ImportantDatesAdapter extends RecyclerView.Adapter<ImportantDatesAdapter.ImportantDatesViewHolder> {
//
//    ImageView imgImportantDates;
//    TextView dateImportantDates;
//    TextView dayImportantDates;
//
//
//    private String[] dateArray;
//    private String[] dayArray;
//
//    public ImportantDatesAdapter(String[] dateArray, String[] dayArray) {
//        this.dateArray = dateArray;
//        this.dayArray = dayArray;
//    }
//
//    //    public ImportantDatesAdapter(String[] dateArray) {
////        this.dateArray  = dateArray;
////        this.dayArray = dayArray;
////
////
////    }
//
//    @NonNull
//    @Override
//    public ImportantDatesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
//        View view = inflater.inflate(R.layout.list_important_dates, viewGroup,false);
//        return new ImportantDatesViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ImportantDatesViewHolder holder, int position) {
//       // String title = data[position];
//
//      //  holder.dateImportantDates.setText(title);
//
//        dateImportantDates.setText(dateArray[position]);
//        dayImportantDates.setText(dayArray[position]);
//
//        //  String title1 = data[position]; //delete
//        //holder.dayImportantDates.setText(title1);      //delete
//    }
//
//
//
//    @Override
//    public int getItemCount() {
//        return dateArray.length;
//
//    }
//
//    public class ImportantDatesViewHolder extends RecyclerView.ViewHolder {
//
//        ImageView imgImportantDates;  //clone
//        TextView dateImportantDates;  //clone
//        TextView dayImportantDates;   //clone
//
//        public ImportantDatesViewHolder(@NonNull View itemView) {
//            super(itemView);
//            imgImportantDates = (ImageView)itemView.findViewById(R.id.imgImportantDates);
//            dateImportantDates = (TextView) itemView.findViewById(R.id.dateImportantDates);
//            dayImportantDates = (TextView) itemView.findViewById(R.id.dayImportantDates);
//        }
//
//
//    }
//
//}
