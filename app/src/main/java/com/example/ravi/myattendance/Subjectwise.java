package com.example.ravi.myattendance;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ravi on 17-Nov-17.
 */

public class Subjectwise extends Fragment {

    private RecyclerView recyclerView;
    private  SubjectWiseAdapter adapter;
    ArrayList<SubjectWiseBlock> blocks ;
    SessionManager sessionManager;
    Integer[] getPreviousAttendedClass;
    Integer[] getPreviousTotalClass;
    String[] totalSubjects;
    private Context context;
    int sizeof;
    String att;
    float attend;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.abc2, viewGroup, false);

        context=getContext();

        recyclerView = (RecyclerView) view.findViewById(R.id.customRecyclerView);

        sessionManager=new SessionManager(getActivity());

        getPreviousAttendedClass=sessionManager.getAttended("classAttended");//array of attended classes for each subject
        getPreviousTotalClass=sessionManager.getTotal("classTotal");//array of total classes for each subject
        totalSubjects=sessionManager.loadArray("mySubject");//array of total subjects
        sizeof=sessionManager.getSize();//no of total subjects

        HashMap<String ,String> str=sessionManager.getUserDetails();
        att=str.get(SessionManager.KEY_ATTENDANCE);
        attend=Float.parseFloat(att);

        blocks=new ArrayList<>();

        for(int i=0;i<sizeof;i++){
            blocks.add(new SubjectWiseBlock(totalSubjects[i], "Attended: "+getPreviousAttendedClass[i],
                    "Total: "+getPreviousTotalClass[i],percent(getPreviousAttendedClass[i],getPreviousTotalClass[i]) + "%",
                    onTrackTV(getPreviousAttendedClass[i],getPreviousTotalClass[i])));
        }

        adapter = new SubjectWiseAdapter(getContext(),blocks);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setAdapter(adapter);

        return view;
    }

    public String percent(int attend, int total){
        float x=0.0f;
        String str;
        float x1,x2;
        x1=attend;
        x2=total;
        x=(x1/x2)*100;
        if(x==100)
            str="100";
        else
            str=String.format(java.util.Locale.US,"%.1f",x);
        return str;
    }

    public String onTrackTV(int b,int c) {

        float tempx,tempx1,tempx2;
        String string="";
        float a = Float.parseFloat(percent(b,c));
        if(a<attend)
        {
            tempx=a;
            tempx1=b;
            tempx2=c;
            int cnt=0;
            while(tempx<attend)
            {
                tempx1++;
                tempx2++;
                cnt++;
                tempx=(tempx1/tempx2)*100;
                if(tempx >= attend)
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
            string="!!! You are on track !!!";
        return string;
    }
    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        getActivity().setTitle("SubjectWise Attendance");
    }
}
