package com.abcd.ravi.myattendance;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ravi on 12-Mar-18.
 */

public class SubjectWiseAdapter extends RecyclerView.Adapter<SubjectWiseAdapter.MyViewHolder>  {

    private List<SubjectWiseBlock> subjectList;
    private Context context;

    public SubjectWiseAdapter(Context context,List<SubjectWiseBlock> subjectList) {
        this.subjectList = subjectList;
        this.context=context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView SubjectWiseTVSub,SubjectWisetvAttendedClass,SubjectWisetvTotalClass,SubjectWisetvPercentage,SubjectWisetvOnTrack;

        private MyViewHolder(View row){

            super(row);

            SubjectWiseTVSub =(TextView) row.findViewById(R.id.SubjectWiseTVSub);
            SubjectWisetvAttendedClass =(TextView) row.findViewById(R.id.SubjectWisetvAttendedClass);
            SubjectWisetvTotalClass =(TextView) row.findViewById(R.id.SubjectWisetvTotalClass);
            SubjectWisetvPercentage =(TextView) row.findViewById(R.id.SubjectWisetvPercentage);
            SubjectWisetvOnTrack=(TextView) row.findViewById(R.id.SubjectWisetvOnTrack);

        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.subject_wise2, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final SubjectWiseAdapter.MyViewHolder holder, final int position) {

        final SubjectWiseBlock subjectWiseBlock = subjectList.get(position);

        holder.SubjectWiseTVSub.setText(subjectWiseBlock.getSubjectName());
        holder.SubjectWisetvAttendedClass.setText(subjectWiseBlock.getAttended());
        holder.SubjectWisetvTotalClass.setText(subjectWiseBlock.getTotal());
        holder.SubjectWisetvPercentage.setText(subjectWiseBlock.getPercent());
        holder.SubjectWisetvOnTrack.setText(subjectWiseBlock.getTrack());
        holder.SubjectWisetvPercentage.setTextColor(Color.parseColor(subjectWiseBlock.getColor()));

    }
    @Override
    public int getItemCount() {
        return subjectList.size();
    }
}
