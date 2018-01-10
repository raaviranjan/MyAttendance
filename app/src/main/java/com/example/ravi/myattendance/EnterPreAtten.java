package com.example.ravi.myattendance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import static android.R.attr.fragment;

/**
 * Created by Ravi on 06-Nov-17.
 */

public class EnterPreAtten extends Fragment {
    Button byes,bno;
    Fragment fragment=null;
    Integer[] attended;
    Integer[] total;
    SessionManager sessionManager;
    //Calendar calendar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.enter_pre_atten, viewGroup, false);

        byes=(Button)view.findViewById(R.id.buttonYesPre);
        bno=(Button)view.findViewById(R.id.buttonNoPre);
        sessionManager=new SessionManager(getActivity());

        //calendar=Calendar.getInstance();

        attended=new Integer[20];
        total=new Integer[20];
        for(int i=0;i<20;i++)
        {
            attended[i]=0;
            total[i]=0;
        }

        bno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManager.setAttended(attended,"classAttended");
                sessionManager.setTotal(total,"classTotal");
                sessionManager.makeLogin();

                /*SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
                Date d = new Date();
                String dayOfTheWeek = sdf.format(d);
                SimpleDateFormat sdf1 = new SimpleDateFormat("EEEE, dd MMM yyyy");
                Date d1 = new Date();
                String dayAndDate = sdf1.format(d1);
                sessionManager.setCalendarDetails(dayOfTheWeek,dayAndDate);*/
                //HashMap<String ,String> today=sessionManager.getDay();
                //String todayDate=today.get("day")+" "+today.get("day_date");
                //Toast.makeText(getActivity(), "Redirecting...", Toast.LENGTH_SHORT).show();

                fragment=new Main();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, fragment);
                ft.commit();

            }
        });
        byes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new PreAttendance();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, fragment);
                ft.commit();
            }
        });



        return view;
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        getActivity().setTitle("Enter Previous Attendance");
    }
}
