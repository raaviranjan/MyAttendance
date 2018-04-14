package com.abcd.ravi.myattendance;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by Ravi on 17-Nov-17.
 */

public class Timetable extends Fragment {
    Button b1,b2,b3,b4,b5,b6,b7;
    TextView t1,t2,t3,t4,t5,t6,t7;
    LinearLayout l1;
    SessionManager sessionManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.timetable, viewGroup, false);

        sessionManager=new SessionManager(getActivity());

        b1=(Button)view.findViewById(R.id.ButtonTimeTableMon);
        b2=(Button)view.findViewById(R.id.ButtonTimeTableTue);
        b3=(Button)view.findViewById(R.id.ButtonTimeTableWed);
        b4=(Button)view.findViewById(R.id.ButtonTimeTableThu);
        b5=(Button)view.findViewById(R.id.ButtonTimeTableFri);
        b6=(Button)view.findViewById(R.id.ButtonTimeTableSat);
        b7=(Button)view.findViewById(R.id.ButtonTimeTableSun);

        t1=(TextView)view.findViewById(R.id.TVTimetable1);
        t2=(TextView)view.findViewById(R.id.TVTimetable2);
        t3=(TextView)view.findViewById(R.id.TVTimetable3);
        t4=(TextView)view.findViewById(R.id.TVTimetable4);
        t5=(TextView)view.findViewById(R.id.TVTimetable5);
        t6=(TextView)view.findViewById(R.id.TVTimetable6);
        t7=(TextView)view.findViewById(R.id.TVTimetable7);

        l1=(LinearLayout)view.findViewById(R.id.TimeTableoffLayout);

        if(sessionManager.isLoggedIn())
        {
            mon();
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    makeTextViewInvisible();
                    mon();
                    b1.setTextColor(Color.parseColor("#FF4081"));
                    b2.setTextColor(Color.parseColor("#FFFFFF"));
                    b3.setTextColor(Color.parseColor("#FFFFFF"));
                    b4.setTextColor(Color.parseColor("#FFFFFF"));
                    b5.setTextColor(Color.parseColor("#FFFFFF"));
                    b6.setTextColor(Color.parseColor("#FFFFFF"));
                    b7.setTextColor(Color.parseColor("#FFFFFF"));
                }
            });
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int cnt=sessionManager.getCountTue();
                    HashMap<String ,String> subjtue=sessionManager.getTueSubjects();
                    makeTextViewInvisible();
                    b1.setTextColor(Color.parseColor("#FFFFFF"));
                    b2.setTextColor(Color.parseColor("#FF4081"));
                    b3.setTextColor(Color.parseColor("#FFFFFF"));
                    b4.setTextColor(Color.parseColor("#FFFFFF"));
                    b5.setTextColor(Color.parseColor("#FFFFFF"));
                    b6.setTextColor(Color.parseColor("#FFFFFF"));
                    b7.setTextColor(Color.parseColor("#FFFFFF"));
                    if(cnt>0)
                    {
                        if(cnt>=1)
                        {
                            t1.setVisibility(View.VISIBLE);
                            t1.setText(subjtue.get(SessionManager.KEY_TUE_SUB_1));
                        }
                        if(cnt>=2)
                        {
                            t2.setVisibility(View.VISIBLE);
                            t2.setText(subjtue.get(SessionManager.KEY_TUE_SUB_2));
                        }
                        if(cnt>=3)
                        {
                            t3.setVisibility(View.VISIBLE);
                            t3.setText(subjtue.get(SessionManager.KEY_TUE_SUB_3));
                        }
                        if(cnt>=4)
                        {
                            t4.setVisibility(View.VISIBLE);
                            t4.setText(subjtue.get(SessionManager.KEY_TUE_SUB_4));
                        }
                        if(cnt>=5)
                        {
                            t5.setVisibility(View.VISIBLE);
                            t5.setText(subjtue.get(SessionManager.KEY_TUE_SUB_5));
                        }
                        if(cnt>=6)
                        {
                            t6.setVisibility(View.VISIBLE);
                            t6.setText(subjtue.get(SessionManager.KEY_TUE_SUB_6));
                        }
                        if(cnt>=7)
                        {
                            t7.setVisibility(View.VISIBLE);
                            t7.setText(subjtue.get(SessionManager.KEY_TUE_SUB_7));
                        }
                    }
                    else
                        l1.setVisibility(View.VISIBLE);
                }
            });
            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int cnt=sessionManager.getCountWed();
                    HashMap<String ,String> subjwed=sessionManager.getWedSubjects();
                    makeTextViewInvisible();
                    b1.setTextColor(Color.parseColor("#FFFFFF"));
                    b2.setTextColor(Color.parseColor("#FFFFFF"));
                    b3.setTextColor(Color.parseColor("#FF4081"));
                    b4.setTextColor(Color.parseColor("#FFFFFF"));
                    b5.setTextColor(Color.parseColor("#FFFFFF"));
                    b6.setTextColor(Color.parseColor("#FFFFFF"));
                    b7.setTextColor(Color.parseColor("#FFFFFF"));
                    if(cnt>0)
                    {
                        if(cnt>=1)
                        {
                            t1.setVisibility(View.VISIBLE);
                            t1.setText(subjwed.get(SessionManager.KEY_WED_SUB_1));
                        }
                        if(cnt>=2)
                        {
                            t2.setVisibility(View.VISIBLE);
                            t2.setText(subjwed.get(SessionManager.KEY_WED_SUB_2));
                        }
                        if(cnt>=3)
                        {
                            t3.setVisibility(View.VISIBLE);
                            t3.setText(subjwed.get(SessionManager.KEY_WED_SUB_3));
                        }
                        if(cnt>=4)
                        {
                            t4.setVisibility(View.VISIBLE);
                            t4.setText(subjwed.get(SessionManager.KEY_WED_SUB_4));
                        }
                        if(cnt>=5)
                        {
                            t5.setVisibility(View.VISIBLE);
                            t5.setText(subjwed.get(SessionManager.KEY_WED_SUB_5));
                        }
                        if(cnt>=6)
                        {
                            t6.setVisibility(View.VISIBLE);
                            t6.setText(subjwed.get(SessionManager.KEY_WED_SUB_6));
                        }
                        if(cnt>=7)
                        {
                            t7.setVisibility(View.VISIBLE);
                            t7.setText(subjwed.get(SessionManager.KEY_WED_SUB_7));
                        }
                    }
                    else
                        l1.setVisibility(View.VISIBLE);
                }
            });
            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int cnt=sessionManager.getCountThu();
                    HashMap<String ,String> subjthu=sessionManager.getThuSubjects();
                    makeTextViewInvisible();
                    b1.setTextColor(Color.parseColor("#FFFFFF"));
                    b2.setTextColor(Color.parseColor("#FFFFFF"));
                    b3.setTextColor(Color.parseColor("#FFFFFF"));
                    b4.setTextColor(Color.parseColor("#FF4081"));
                    b5.setTextColor(Color.parseColor("#FFFFFF"));
                    b6.setTextColor(Color.parseColor("#FFFFFF"));
                    b7.setTextColor(Color.parseColor("#FFFFFF"));
                    if(cnt>0)
                    {
                        if(cnt>=1)
                        {
                            t1.setVisibility(View.VISIBLE);
                            t1.setText(subjthu.get(SessionManager.KEY_THU_SUB_1));
                        }
                        if(cnt>=2)
                        {
                            t2.setVisibility(View.VISIBLE);
                            t2.setText(subjthu.get(SessionManager.KEY_THU_SUB_2));
                        }
                        if(cnt>=3)
                        {
                            t3.setVisibility(View.VISIBLE);
                            t3.setText(subjthu.get(SessionManager.KEY_THU_SUB_3));
                        }
                        if(cnt>=4)
                        {
                            t4.setVisibility(View.VISIBLE);
                            t4.setText(subjthu.get(SessionManager.KEY_THU_SUB_4));
                        }
                        if(cnt>=5)
                        {
                            t5.setVisibility(View.VISIBLE);
                            t5.setText(subjthu.get(SessionManager.KEY_THU_SUB_5));
                        }
                        if(cnt>=6)
                        {
                            t6.setVisibility(View.VISIBLE);
                            t6.setText(subjthu.get(SessionManager.KEY_THU_SUB_6));
                        }
                        if(cnt>=7)
                        {
                            t7.setVisibility(View.VISIBLE);
                            t7.setText(subjthu.get(SessionManager.KEY_THU_SUB_7));
                        }
                    }
                    else
                        l1.setVisibility(View.VISIBLE);
                }
            });
            b5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int cnt=sessionManager.getCountFri();
                    HashMap<String ,String> subjfri=sessionManager.getFriSubjects();
                    makeTextViewInvisible();
                    b1.setTextColor(Color.parseColor("#FFFFFF"));
                    b2.setTextColor(Color.parseColor("#FFFFFF"));
                    b3.setTextColor(Color.parseColor("#FFFFFF"));
                    b4.setTextColor(Color.parseColor("#FFFFFF"));
                    b5.setTextColor(Color.parseColor("#FF4081"));
                    b6.setTextColor(Color.parseColor("#FFFFFF"));
                    b7.setTextColor(Color.parseColor("#FFFFFF"));

                    if(cnt>0)
                    {
                        if(cnt>=1)
                        {
                            t1.setVisibility(View.VISIBLE);
                            t1.setText(subjfri.get(SessionManager.KEY_FRI_SUB_1));
                        }
                        if(cnt>=2)
                        {
                            t2.setVisibility(View.VISIBLE);
                            t2.setText(subjfri.get(SessionManager.KEY_FRI_SUB_2));
                        }
                        if(cnt>=3)
                        {
                            t3.setVisibility(View.VISIBLE);
                            t3.setText(subjfri.get(SessionManager.KEY_FRI_SUB_3));
                        }
                        if(cnt>=4)
                        {
                            t4.setVisibility(View.VISIBLE);
                            t4.setText(subjfri.get(SessionManager.KEY_FRI_SUB_4));
                        }
                        if(cnt>=5)
                        {
                            t5.setVisibility(View.VISIBLE);
                            t5.setText(subjfri.get(SessionManager.KEY_FRI_SUB_5));
                        }
                        if(cnt>=6)
                        {
                            t6.setVisibility(View.VISIBLE);
                            t6.setText(subjfri.get(SessionManager.KEY_FRI_SUB_6));
                        }
                        if(cnt>=7)
                        {
                            t7.setVisibility(View.VISIBLE);
                            t7.setText(subjfri.get(SessionManager.KEY_FRI_SUB_7));
                        }
                    }
                    else
                        l1.setVisibility(View.VISIBLE);
                }
            });
            b6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int cnt=sessionManager.getCountSat();
                    HashMap<String ,String> subjsat=sessionManager.getSatSubjects();
                    makeTextViewInvisible();
                    b1.setTextColor(Color.parseColor("#FFFFFF"));
                    b2.setTextColor(Color.parseColor("#FFFFFF"));
                    b3.setTextColor(Color.parseColor("#FFFFFF"));
                    b4.setTextColor(Color.parseColor("#FFFFFF"));
                    b5.setTextColor(Color.parseColor("#FFFFFF"));
                    b6.setTextColor(Color.parseColor("#FF4081"));
                    b7.setTextColor(Color.parseColor("#FFFFFF"));
                    if(cnt>0)
                    {
                        if(cnt>=1)
                        {
                            t1.setVisibility(View.VISIBLE);
                            t1.setText(subjsat.get(SessionManager.KEY_SAT_SUB_1));
                        }
                        if(cnt>=2)
                        {
                            t2.setVisibility(View.VISIBLE);
                            t2.setText(subjsat.get(SessionManager.KEY_SAT_SUB_2));
                        }
                        if(cnt>=3)
                        {
                            t3.setVisibility(View.VISIBLE);
                            t3.setText(subjsat.get(SessionManager.KEY_SAT_SUB_3));
                        }
                        if(cnt>=4)
                        {
                            t4.setVisibility(View.VISIBLE);
                            t4.setText(subjsat.get(SessionManager.KEY_SAT_SUB_4));
                        }
                        if(cnt>=5)
                        {
                            t5.setVisibility(View.VISIBLE);
                            t5.setText(subjsat.get(SessionManager.KEY_SAT_SUB_5));
                        }
                        if(cnt>=6)
                        {
                            t6.setVisibility(View.VISIBLE);
                            t6.setText(subjsat.get(SessionManager.KEY_SAT_SUB_6));
                        }
                        if(cnt>=7)
                        {
                            t7.setVisibility(View.VISIBLE);
                            t7.setText(subjsat.get(SessionManager.KEY_SAT_SUB_7));
                        }
                    }
                    else
                        l1.setVisibility(View.VISIBLE);
                }
            });
            b7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    makeTextViewInvisible();
                    b1.setTextColor(Color.parseColor("#FFFFFF"));
                    b2.setTextColor(Color.parseColor("#FFFFFF"));
                    b3.setTextColor(Color.parseColor("#FFFFFF"));
                    b4.setTextColor(Color.parseColor("#FFFFFF"));
                    b5.setTextColor(Color.parseColor("#FFFFFF"));
                    b6.setTextColor(Color.parseColor("#FFFFFF"));
                    b7.setTextColor(Color.parseColor("#FF4081"));
                    l1.setVisibility(View.VISIBLE);
                }
            });
        }
        else
            Toast.makeText(getActivity(), "Nothing to display", Toast.LENGTH_SHORT).show();



        return view;
    }
    public void mon()
    {
        int cnt=sessionManager.getCountMon();
        HashMap<String ,String> subj=sessionManager.getMonSubjects();
        if(cnt>0)
        {
            if(cnt>=1)
            {
                t1.setVisibility(View.VISIBLE);
                t1.setText(subj.get(SessionManager.KEY_MON_SUB_1));
            }
            if(cnt>=2)
            {
                t2.setVisibility(View.VISIBLE);
                t2.setText(subj.get(SessionManager.KEY_MON_SUB_2));
            }
            if(cnt>=3)
            {
                t3.setVisibility(View.VISIBLE);
                t3.setText(subj.get(SessionManager.KEY_MON_SUB_3));
            }
            if(cnt>=4)
            {
                t4.setVisibility(View.VISIBLE);
                t4.setText(subj.get(SessionManager.KEY_MON_SUB_4));
            }
            if(cnt>=5)
            {
                t5.setVisibility(View.VISIBLE);
                t5.setText(subj.get(SessionManager.KEY_MON_SUB_5));
            }
            if(cnt>=6)
            {
                t6.setVisibility(View.VISIBLE);
                t6.setText(subj.get(SessionManager.KEY_MON_SUB_6));
            }
            if(cnt>=7)
            {
                t7.setVisibility(View.VISIBLE);
                t7.setText(subj.get(SessionManager.KEY_MON_SUB_7));
            }
        }
        else
            l1.setVisibility(View.VISIBLE);
    }
    public void makeTextViewInvisible()
    {
        t1.setVisibility(View.GONE);
        t2.setVisibility(View.GONE);
        t3.setVisibility(View.GONE);
        t4.setVisibility(View.GONE);
        t5.setVisibility(View.GONE);
        t6.setVisibility(View.GONE);
        t7.setVisibility(View.GONE);
        l1.setVisibility(View.GONE);
    }
    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        getActivity().setTitle("Time Table");
    }
}
