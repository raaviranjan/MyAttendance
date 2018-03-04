package com.example.ravi.myattendance;
/*
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;



import java.net.Inet4Address;
import java.util.ArrayList;



public class Main2Adapter extends RecyclerView.Adapter<Main2Adapter.ViewHolder1> {

    private Context mContext;
    private  ArrayList<Main2Blocks> mainlist;



    public Main2Adapter(Context context,ArrayList<Main2Blocks> list) {
        mContext=context;
        mainlist=list;
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {

        private TextView mainTVSub1,tvAttendedClass1,tvTotalClass1,tvPercentage1,tvOnTrack1,textView;
        private Button buttonToMark1;
        private LinearLayout linearLayoutToMark1;
        private ImageButton iBRight1,iBWrong1,iBReset1;
        private ImageView ivAfterMarking1;

        private ViewHolder1(View row){

            super(row);

            textView=(TextView) row.findViewById(R.id.testtext);
            mainTVSub1 =(TextView) row.findViewById(R.id.mainTVSub1);
            tvAttendedClass1 =(TextView) row.findViewById(R.id.tvAttendedClass1);
            tvTotalClass1 =(TextView) row.findViewById(R.id.tvTotalClass1);
            tvPercentage1 =(TextView) row.findViewById(R.id.tvPercentage1);
            tvOnTrack1 =(TextView) row.findViewById(R.id.tvOnTrack1);

            ivAfterMarking1 = (ImageView) row.findViewById(R.id.ivAfterMarking1);

            linearLayoutToMark1 = (LinearLayout) row.findViewById(R.id.linearLayoutToMark1);

            iBRight1 =(ImageButton) row.findViewById(R.id.iBRight1);
            iBWrong1 =(ImageButton) row.findViewById(R.id.iBWrong1);
            iBReset1 =(ImageButton) row.findViewById(R.id.iBReset1);

            buttonToMark1 =(Button) row.findViewById(R.id.buttonToMark1);

        }
    }*/


/*
    @Override
    public ViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {

        View v1 = LayoutInflater.from(mContext).inflate(R.layout.test,parent,false);



        return new ViewHolder1(v1);
    }

    @Override
    public void onBindViewHolder(final ViewHolder1 holder, final int position) {
        Main2Blocks main2Blocks=mainlist.get(position);

        String s=main2Blocks.getSubjectName();

        holder.textView.setText(s);

    }


    @Override
    public int getItemCount() {
        return mainlist.size();
    }

}*/



import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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

        private MyViewHolder(View row){

            super(row);

            mainTVSub1 =(TextView) row.findViewById(R.id.mainTVSub1);
            tvAttendedClass1 =(TextView) row.findViewById(R.id.tvAttendedClass1);
            tvTotalClass1 =(TextView) row.findViewById(R.id.tvTotalClass1);
            tvPercentage1 =(TextView) row.findViewById(R.id.tvPercentage1);

        }
    }




    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.abc, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Main2Blocks movie = moviesList.get(position);

        holder.mainTVSub1.setText(movie.getSubjectName());
        holder.tvAttendedClass1.setText(movie.getAttended());

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
