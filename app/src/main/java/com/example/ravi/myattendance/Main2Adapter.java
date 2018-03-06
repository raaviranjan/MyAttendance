package com.example.ravi.myattendance;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.net.ConnectException;
import java.util.List;

public class Main2Adapter extends RecyclerView.Adapter<Main2Adapter.MyViewHolder> {

    private List<Main2Blocks> moviesList;
    private Context context;

    public Main2Adapter(Context context,List<Main2Blocks> moviesList) {
        this.moviesList = moviesList;
        this.context=context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mainTVSub1,tvAttendedClass1,tvTotalClass1,tvPercentage1,tvOnTrack1,textView;
        private Button buttonToMark1;
        private LinearLayout linearLayoutToMark1;
        private ImageButton iBRight1,iBWrong1,iBReset1;
        private ImageView ivAfterMarking1;
        private int present=0,absent=0;
        private String string;

        private MyViewHolder(View row){

            super(row);

            mainTVSub1 =(TextView) row.findViewById(R.id.mainTVSub1);
            tvAttendedClass1 =(TextView) row.findViewById(R.id.tvAttendedClass1);
            tvTotalClass1 =(TextView) row.findViewById(R.id.tvTotalClass1);
            tvPercentage1 =(TextView) row.findViewById(R.id.tvPercentage1);
            tvOnTrack1=(TextView) row.findViewById(R.id.tvOnTrack1);

            ivAfterMarking1 = (ImageView) row.findViewById(R.id.ivAfterMarking1);

            linearLayoutToMark1 = (LinearLayout) row.findViewById(R.id.linearLayoutToMark1);

            iBRight1 =(ImageButton) row.findViewById(R.id.iBRight1);
            iBWrong1 =(ImageButton) row.findViewById(R.id.iBWrong1);
            iBReset1 =(ImageButton) row.findViewById(R.id.iBReset1);

            buttonToMark1 =(Button) row.findViewById(R.id.buttonToMark1);

        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.abc, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        final Main2Blocks mb = moviesList.get(position);

        holder.mainTVSub1.setText(mb.getSubjectName());
        holder.tvAttendedClass1.setText(mb.getAttended());
        holder.tvTotalClass1.setText(mb.getTotal());
        holder.tvOnTrack1.setText(mb.getTrack());
        holder.tvPercentage1.setText(mb.getPercent());
        holder.tvPercentage1.setTextColor(Color.parseColor(mb.getColor()));
        if(mb.getMark().contains("reset"))
            holder.ivAfterMarking1.setImageResource(R.drawable.border_percentage);
        else if(mb.getMark().contains("bunked"))
            holder.ivAfterMarking1.setImageResource(R.drawable.wrong);
        else if(mb.getMark().contains("attended"))
            holder.ivAfterMarking1.setImageResource(R.drawable.right);

        holder.buttonToMark1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.linearLayoutToMark1.setVisibility(View.VISIBLE);
                holder.string=String.valueOf(holder.getAdapterPosition());
                //Toast.makeText(context, String.valueOf(holder.getAdapterPosition()), Toast.LENGTH_SHORT).show();

            }
        });
        holder.iBRight1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.present++;
                holder.linearLayoutToMark1.setVisibility(View.GONE);
                holder.ivAfterMarking1.setImageResource(R.drawable.right);
                holder.string=holder.string+"attended";
                Toast.makeText(context, "Attended \"" + mb.getSubjectName() + "\"", Toast.LENGTH_SHORT).show();
                updateAttendance(position, holder.tvAttendedClass1,holder.tvTotalClass1,holder.tvPercentage1,
                        holder.tvOnTrack1,1,holder.present,holder.absent,holder.string);
            }
        });
        holder.iBWrong1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.absent++;
                holder.linearLayoutToMark1.setVisibility(View.GONE);
                holder.ivAfterMarking1.setImageResource(R.drawable.wrong);
                holder.string=holder.string+"bunked";
                Toast.makeText(context, "Bunked \"" + mb.getSubjectName() + "\"", Toast.LENGTH_SHORT).show();

                updateAttendance(position, holder.tvAttendedClass1,holder.tvTotalClass1,holder.tvPercentage1,
                        holder.tvOnTrack1,0,holder.present,holder.absent,holder.string);
            }
        });
        holder.iBReset1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.linearLayoutToMark1.setVisibility(View.GONE);
                holder.ivAfterMarking1.setImageResource(R.drawable.border_percentage);
                if(holder.present > 0 || holder.absent > 0)
                    holder.string=holder.string+"reset";
                else
                    holder.string="z";
                Toast.makeText(context,"Reset", Toast.LENGTH_SHORT).show();
                updateAttendance(position, holder.tvAttendedClass1,holder.tvTotalClass1,holder.tvPercentage1,
                        holder.tvOnTrack1,-1,holder.present,holder.absent,holder.string);
                holder.present = 0;
                holder.absent = 0;

            }
        });

    }

    private void updateAttendance(int position, TextView attended, TextView total,TextView percentTV,TextView onTrack,int value,
                                  int presentPressedCount,int absentPressedCount, String s) {

        Main2Blocks mb = moviesList.get(position);

        if(value==-1) {
            mb.attendTV -= presentPressedCount;
            mb.totTV -= presentPressedCount + absentPressedCount;
        }
        else {
            mb.attendTV += value;
            mb.totTV++;
        }

        attended.setText("Attended: "+mb.attendTV);
        total.setText("Total: "+mb.totTV);

        //calculating new attendance percentage
        float x=0.0f;
        String str="0";
        String string="";
        float x1,x2,x3,tempx,tempx1,tempx2;
        x1=mb.attendTV;
        x2=mb.totTV;
        x3=100;
        x=(x1/x2)*x3;
        if(x==100)
            str="100";
        else
            str=String.format(java.util.Locale.US,"%.1f",x);
        percentTV.setText(str+"%");

        //checking whether you are on track or not and setting the color accordingly
        if(x<mb.getAttendanceCriteria())
        {
            percentTV.setTextColor(Color.parseColor("#B22222"));//red
            tempx=x;
            tempx1=x1;
            tempx2=x2;
            int cnt=0;
            while(tempx<mb.getAttendanceCriteria())
            {
                tempx1++;
                tempx2++;
                cnt++;
                tempx=(tempx1/tempx2)*x3;
                if(tempx<mb.getAttendanceCriteria())
                {
                    continue;
                }
                else
                {
                    if(cnt==1)
                        string="!!! Attend next class !!!";
                    else
                        string="!!! Attend next "+cnt+" classes !!!";
                    break;
                }

            }
        }
        else
        {
            percentTV.setTextColor(Color.parseColor("#008000"));//green
            string="!!! You are on track !!!";
        }
        onTrack.setText(string);

        //calling saveChanges method of Product class to save the changes
        mb.saveChanges(mb.attendTV,mb.totTV,mb.index,s);

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
