package com.example.ravi.myattendance;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

/**
 * Created by Ravi on 07-Feb-18.
 */

public class Main2 extends Fragment {

    private RecyclerView recyclerView;
    private  Main2Adapter adapter;
    ArrayList<Main2Blocks> blocks ;
    SessionManager sessionManager;
    Integer[] getPreviousAttendedClass;
    Integer[] getPreviousTotalClass;
    String[] totalSubjects;
    String lastUpdateDay,currentDay;
    private Context context;
    int sizeof;
    HashMap<String ,String> subj;
    HashMap<String ,String> subtue;
    HashMap<String ,String> subwed;
    HashMap<String ,String> subthu;
    HashMap<String ,String> subfri;
    HashMap<String ,String> subsat;
    HashMap<String ,String> str;
    HashMap<String ,String> mark;
    String att;
    float attend;
    boolean flag;
    LinearLayout offLayout;
    AdView mAdView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.abc2, viewGroup, false);

        context=getContext();

        MobileAds.initialize(getActivity(), "ca-app-pub-3940256099942544~3347511713");
        mAdView = view.findViewById(R.id.adView);
        //banner ad
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("50F7BD1535D4AA905405E185DB25BBB7").build();
        mAdView.loadAd(adRequest);

        recyclerView = (RecyclerView) view.findViewById(R.id.customRecyclerView);
        offLayout = (LinearLayout) view.findViewById(R.id.offLayout);

        sessionManager=new SessionManager(getActivity());

        //getting subjects of each day
        subj=sessionManager.getMonSubjects();
        subtue=sessionManager.getTueSubjects();
        subwed=sessionManager.getWedSubjects();
        subthu=sessionManager.getThuSubjects();
        subfri=sessionManager.getFriSubjects();
        subsat=sessionManager.getSatSubjects();

        //storing today's day and date
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE", Locale.US);
        Date d = new Date();
        String dayOfTheWeek = sdf.format(d);
        SimpleDateFormat sdf1 = new SimpleDateFormat("EEEE, dd MMM yyyy",Locale.US);
        Date d1 = new Date();
        String dayAndDate = sdf1.format(d1);
        sessionManager.setCalendarDetails(dayOfTheWeek,dayAndDate);

        flag=sessionManager.getFlag();
        lastUpdateDay=sessionManager.getOpenDay();
        currentDay=dayOfTheWeek;
        if(!currentDay.equals(lastUpdateDay))
        {
            flag=true;
            sessionManager.setOpenDay(currentDay);
        }

        if(flag)
        {
            sessionManager.setImageAfterMarking("0reset","1reset","2reset","3reset","4reset","5reset","6reset");
        }

        mark = sessionManager.getImageAfterMarking() ;

        //getting the attendance criteria of the user
        str=sessionManager.getUserDetails();
        att=str.get(SessionManager.KEY_ATTENDANCE);
        attend=Float.parseFloat(att);

        getPreviousAttendedClass=sessionManager.getAttended("classAttended");//array of attended classes for each subject
        getPreviousTotalClass=sessionManager.getTotal("classTotal");//array of total classes for each subject
        totalSubjects=sessionManager.loadArray("mySubject");//array of total subjects
        sizeof=sessionManager.getSize();//no of total subjects

        blocks=new ArrayList<>();

        getSubjects();

        adapter = new Main2Adapter(getContext(),blocks);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setAdapter(adapter);

        return view;
    }

    public void getSubjects() {
        int cnt;
        HashMap<String ,String> today=sessionManager.getDay();
        String todayDay=today.get("day");

        if(todayDay.equals("Monday")) {

            cnt = sessionManager.getCountMon();

            int a=matchForSubjectNumber(subj.get(SessionManager.KEY_MON_SUB_1));
            int b=matchForSubjectNumber(subj.get(SessionManager.KEY_MON_SUB_2));
            int c=matchForSubjectNumber(subj.get(SessionManager.KEY_MON_SUB_3));
            int d=matchForSubjectNumber(subj.get(SessionManager.KEY_MON_SUB_4));
            int e=matchForSubjectNumber(subj.get(SessionManager.KEY_MON_SUB_5));
            int f=matchForSubjectNumber(subj.get(SessionManager.KEY_MON_SUB_6));
            int g=matchForSubjectNumber(subj.get(SessionManager.KEY_MON_SUB_7));

            if(cnt == 0){
                offLayout.setVisibility(View.VISIBLE);
            } else {
                if (cnt >= 1) {
                    blocks.add(new Main2Blocks(subj.get(SessionManager.KEY_MON_SUB_1),
                            "Attended: "+getPreviousAttendedClass[a], "Total: "+getPreviousTotalClass[a],
                            percentageTextView(a)+"%", setColorOfPercentageTextView(a),a,context,attend,mark.get("first")));
                }
                if (cnt >= 2) {
                    blocks.add(new Main2Blocks(subj.get(SessionManager.KEY_MON_SUB_2),
                            ("Attended: "+getPreviousAttendedClass[b]),("Total: "+getPreviousTotalClass[b]),
                            (percentageTextView(b)+"%"),setColorOfPercentageTextView(b),b,context,attend,mark.get("second")));
                }
                if (cnt >= 3) {
                    blocks.add(new Main2Blocks(subj.get(SessionManager.KEY_MON_SUB_3),
                            ("Attended: "+getPreviousAttendedClass[c]),("Total: "+getPreviousTotalClass[c]),
                            (percentageTextView(c)+"%"),setColorOfPercentageTextView(c),c,context,attend,mark.get("third")));
                }
                if (cnt >= 4) {
                    blocks.add(new Main2Blocks(subj.get(SessionManager.KEY_MON_SUB_4),
                            ("Attended: "+getPreviousAttendedClass[d]),("Total: "+getPreviousTotalClass[d]),
                            (percentageTextView(d)+"%"),setColorOfPercentageTextView(d),d,context,attend,mark.get("fourth")));
                }
                if (cnt >= 5) {
                    blocks.add(new Main2Blocks(subj.get(SessionManager.KEY_MON_SUB_5),
                            ("Attended: "+getPreviousAttendedClass[e]),("Total: "+getPreviousTotalClass[e]),
                            (percentageTextView(e)+"%"),setColorOfPercentageTextView(e),e,context,attend,mark.get("fifth")));
                }
                if (cnt >= 6) {
                    blocks.add(new Main2Blocks(subj.get(SessionManager.KEY_MON_SUB_6),
                            ("Attended: "+getPreviousAttendedClass[f]),("Total: "+getPreviousTotalClass[f]),
                            (percentageTextView(f)+"%"),setColorOfPercentageTextView(f),f,context,attend,mark.get("sixth")));
                }
                if (cnt >= 7) {
                    blocks.add(new Main2Blocks(subj.get(SessionManager.KEY_MON_SUB_7),
                            ("Attended: "+getPreviousAttendedClass[g]),("Total: "+getPreviousTotalClass[g]),
                            (percentageTextView(g)+"%"),setColorOfPercentageTextView(g),g,context,attend,mark.get("seventh")));
                }
            }
        }

        if(todayDay.equals("Tuesday")) {

            cnt = sessionManager.getCountTue();

            int a=matchForSubjectNumber(subtue.get(SessionManager.KEY_TUE_SUB_1));
            int b=matchForSubjectNumber(subtue.get(SessionManager.KEY_TUE_SUB_2));
            int c=matchForSubjectNumber(subtue.get(SessionManager.KEY_TUE_SUB_3));
            int d=matchForSubjectNumber(subtue.get(SessionManager.KEY_TUE_SUB_4));
            int e=matchForSubjectNumber(subtue.get(SessionManager.KEY_TUE_SUB_5));
            int f=matchForSubjectNumber(subtue.get(SessionManager.KEY_TUE_SUB_6));
            int g=matchForSubjectNumber(subtue.get(SessionManager.KEY_TUE_SUB_7));

            if(cnt == 0){
                offLayout.setVisibility(View.VISIBLE);
            } else {
                if (cnt >= 1) {
                    blocks.add(new Main2Blocks(subtue.get(SessionManager.KEY_TUE_SUB_1),
                            ("Attended: "+getPreviousAttendedClass[a]),("Total: "+getPreviousTotalClass[a]),
                            (percentageTextView(a)+"%"),setColorOfPercentageTextView(a),a,context,attend,mark.get("first")));
                }
                if (cnt >= 2) {
                    blocks.add(new Main2Blocks(subtue.get(SessionManager.KEY_TUE_SUB_2),
                            ("Attended: "+getPreviousAttendedClass[b]),("Total: "+getPreviousTotalClass[b]),
                            (percentageTextView(b)+"%"),setColorOfPercentageTextView(b),b,context,attend,mark.get("second")));
                }
                if (cnt >= 3) {
                    blocks.add(new Main2Blocks(subtue.get(SessionManager.KEY_TUE_SUB_3),
                            ("Attended: "+getPreviousAttendedClass[c]),("Total: "+getPreviousTotalClass[c]),
                            (percentageTextView(c)+"%"),setColorOfPercentageTextView(c),c,context,attend,mark.get("third")));
                }
                if (cnt >= 4) {
                    blocks.add(new Main2Blocks(subtue.get(SessionManager.KEY_TUE_SUB_4),
                            ("Attended: "+getPreviousAttendedClass[d]),("Total: "+getPreviousTotalClass[d]),
                            (percentageTextView(d)+"%"),setColorOfPercentageTextView(d),d,context,attend,mark.get("fourth")));
                }
                if (cnt >= 5) {
                    blocks.add(new Main2Blocks(subtue.get(SessionManager.KEY_TUE_SUB_5),
                            ("Attended: "+getPreviousAttendedClass[e]),("Total: "+getPreviousTotalClass[e]),
                            (percentageTextView(e)+"%"),setColorOfPercentageTextView(e),e,context,attend,mark.get("fifth")));
                }
                if (cnt >= 6) {
                    blocks.add(new Main2Blocks(subtue.get(SessionManager.KEY_TUE_SUB_6),
                            ("Attended: "+getPreviousAttendedClass[f]),("Total: "+getPreviousTotalClass[f]),
                            (percentageTextView(f)+"%"),setColorOfPercentageTextView(f),f,context,attend,mark.get("sixth")));
                }
                if (cnt >= 7) {
                    blocks.add(new Main2Blocks(subtue.get(SessionManager.KEY_TUE_SUB_7),
                            ("Attended: "+getPreviousAttendedClass[g]),("Total: "+getPreviousTotalClass[g]),
                            (percentageTextView(g)+"%"),setColorOfPercentageTextView(g),g,context,attend,mark.get("seventh")));
                }
            }
        }

        if(todayDay.equals("Wednesday")) {

            cnt = sessionManager.getCountWed();

            int a=matchForSubjectNumber(subwed.get(SessionManager.KEY_WED_SUB_1));
            int b=matchForSubjectNumber(subwed.get(SessionManager.KEY_WED_SUB_2));
            int c=matchForSubjectNumber(subwed.get(SessionManager.KEY_WED_SUB_3));
            int d=matchForSubjectNumber(subwed.get(SessionManager.KEY_WED_SUB_4));
            int e=matchForSubjectNumber(subwed.get(SessionManager.KEY_WED_SUB_5));
            int f=matchForSubjectNumber(subwed.get(SessionManager.KEY_WED_SUB_6));
            int g=matchForSubjectNumber(subwed.get(SessionManager.KEY_WED_SUB_7));

            if(cnt == 0){
                offLayout.setVisibility(View.VISIBLE);
            } else {
                if (cnt >= 1) {
                    blocks.add(new Main2Blocks(subwed.get(SessionManager.KEY_WED_SUB_1),
                            ("Attended: "+getPreviousAttendedClass[a]),("Total: "+getPreviousTotalClass[a]),
                            (percentageTextView(a)+"%"),setColorOfPercentageTextView(a),a,context,attend,mark.get("first")));
                }
                if (cnt >= 2) {
                    blocks.add(new Main2Blocks(subwed.get(SessionManager.KEY_WED_SUB_2),
                            ("Attended: "+getPreviousAttendedClass[b]),("Total: "+getPreviousTotalClass[b]),
                            (percentageTextView(b)+"%"),setColorOfPercentageTextView(b),b,context,attend,mark.get("second")));
                }
                if (cnt >= 3) {
                    blocks.add(new Main2Blocks(subwed.get(SessionManager.KEY_WED_SUB_3),
                            ("Attended: "+getPreviousAttendedClass[c]),("Total: "+getPreviousTotalClass[c]),
                            (percentageTextView(c)+"%"),setColorOfPercentageTextView(c),c,context,attend,mark.get("third")));
                }
                if (cnt >= 4) {
                    blocks.add(new Main2Blocks(subwed.get(SessionManager.KEY_WED_SUB_4),
                            ("Attended: "+getPreviousAttendedClass[d]),("Total: "+getPreviousTotalClass[d]),
                            (percentageTextView(d)+"%"),setColorOfPercentageTextView(d),d,context,attend,mark.get("fourth")));
                }
                if (cnt >= 5) {
                    blocks.add(new Main2Blocks(subwed.get(SessionManager.KEY_WED_SUB_5),
                            ("Attended: "+getPreviousAttendedClass[e]),("Total: "+getPreviousTotalClass[e]),
                            (percentageTextView(e)+"%"),setColorOfPercentageTextView(e),e,context,attend,mark.get("fifth")));
                }
                if (cnt >= 6) {
                    blocks.add(new Main2Blocks(subwed.get(SessionManager.KEY_WED_SUB_6),
                            ("Attended: "+getPreviousAttendedClass[f]),("Total: "+getPreviousTotalClass[f]),
                            (percentageTextView(f)+"%"),setColorOfPercentageTextView(f),f,context,attend,mark.get("sixth")));
                }
                if (cnt >= 7) {
                    blocks.add(new Main2Blocks(subwed.get(SessionManager.KEY_WED_SUB_7),
                            ("Attended: "+getPreviousAttendedClass[g]),("Total: "+getPreviousTotalClass[g]),
                            (percentageTextView(g)+"%"),setColorOfPercentageTextView(g),g,context,attend,mark.get("seventh")));
                }
            }
        }

        if(todayDay.equals("Thursday")) {

            cnt = sessionManager.getCountThu();

            int a=matchForSubjectNumber(subthu.get(SessionManager.KEY_THU_SUB_1));
            int b=matchForSubjectNumber(subthu.get(SessionManager.KEY_THU_SUB_2));
            int c=matchForSubjectNumber(subthu.get(SessionManager.KEY_THU_SUB_3));
            int d=matchForSubjectNumber(subthu.get(SessionManager.KEY_THU_SUB_4));
            int e=matchForSubjectNumber(subthu.get(SessionManager.KEY_THU_SUB_5));
            int f=matchForSubjectNumber(subthu.get(SessionManager.KEY_THU_SUB_6));
            int g=matchForSubjectNumber(subthu.get(SessionManager.KEY_THU_SUB_7));

            if(cnt == 0){
                offLayout.setVisibility(View.VISIBLE);
            } else {
                if (cnt >= 1) {
                    blocks.add(new Main2Blocks(subthu.get(SessionManager.KEY_THU_SUB_1),
                            ("Attended: "+getPreviousAttendedClass[a]),("Total: "+getPreviousTotalClass[a]),
                            (percentageTextView(a)+"%"),setColorOfPercentageTextView(a),a,context,attend,mark.get("first")));
                }
                if (cnt >= 2) {
                    blocks.add(new Main2Blocks(subthu.get(SessionManager.KEY_THU_SUB_2),
                            ("Attended: "+getPreviousAttendedClass[b]),("Total: "+getPreviousTotalClass[b]),
                            (percentageTextView(b)+"%"),setColorOfPercentageTextView(b),b,context,attend,mark.get("second")));
                }
                if (cnt >= 3) {
                    blocks.add(new Main2Blocks(subthu.get(SessionManager.KEY_THU_SUB_3),
                            ("Attended: "+getPreviousAttendedClass[c]),("Total: "+getPreviousTotalClass[c]),
                            (percentageTextView(c)+"%"),setColorOfPercentageTextView(c),c,context,attend,mark.get("third")));
                }
                if (cnt >= 4) {
                    blocks.add(new Main2Blocks(subthu.get(SessionManager.KEY_THU_SUB_4),
                            ("Attended: "+getPreviousAttendedClass[d]),("Total: "+getPreviousTotalClass[d]),
                            (percentageTextView(d)+"%"),setColorOfPercentageTextView(d),d,context,attend,mark.get("fourth")));
                }
                if (cnt >= 5) {
                    blocks.add(new Main2Blocks(subthu.get(SessionManager.KEY_THU_SUB_5),
                            ("Attended: "+getPreviousAttendedClass[e]),("Total: "+getPreviousTotalClass[e]),
                            (percentageTextView(e)+"%"),setColorOfPercentageTextView(e),e,context,attend,mark.get("fifth")));
                }
                if (cnt >= 6) {
                    blocks.add(new Main2Blocks(subthu.get(SessionManager.KEY_THU_SUB_6),
                            ("Attended: "+getPreviousAttendedClass[f]),("Total: "+getPreviousTotalClass[f]),
                            (percentageTextView(f)+"%"),setColorOfPercentageTextView(f),f,context,attend,mark.get("sixth")));
                }
                if (cnt >= 7) {
                    blocks.add(new Main2Blocks(subthu.get(SessionManager.KEY_THU_SUB_7),
                            ("Attended: "+getPreviousAttendedClass[g]),("Total: "+getPreviousTotalClass[g]),
                            (percentageTextView(g)+"%"),setColorOfPercentageTextView(g),g,context,attend,mark.get("seventh")));
                }
            }
        }

        if(todayDay.equals("Friday")) {

            cnt=sessionManager.getCountFri();

            int a=matchForSubjectNumber(subfri.get(SessionManager.KEY_FRI_SUB_1));
            int b=matchForSubjectNumber(subfri.get(SessionManager.KEY_FRI_SUB_2));
            int c=matchForSubjectNumber(subfri.get(SessionManager.KEY_FRI_SUB_3));
            int d=matchForSubjectNumber(subfri.get(SessionManager.KEY_FRI_SUB_4));
            int e=matchForSubjectNumber(subfri.get(SessionManager.KEY_FRI_SUB_5));
            int f=matchForSubjectNumber(subfri.get(SessionManager.KEY_FRI_SUB_6));
            int g=matchForSubjectNumber(subfri.get(SessionManager.KEY_FRI_SUB_7));

            if(cnt == 0){
                offLayout.setVisibility(View.VISIBLE);
            } else {
                if(cnt >= 1)
                {
                    blocks.add(new Main2Blocks(subfri.get(SessionManager.KEY_FRI_SUB_1),
                            ("Attended: "+getPreviousAttendedClass[a]),("Total: "+getPreviousTotalClass[a]),
                            (percentageTextView(a)+"%"),setColorOfPercentageTextView(a),a,context,attend,mark.get("first")));
                }
                if(cnt >= 2)
                {
                    blocks.add(new Main2Blocks(subfri.get(SessionManager.KEY_FRI_SUB_2),
                            ("Attended: "+getPreviousAttendedClass[b]),("Total: "+getPreviousTotalClass[b]),
                            (percentageTextView(b)+"%"),setColorOfPercentageTextView(b),b,context,attend,mark.get("second")));
                }
                if(cnt >= 3)
                {
                    blocks.add(new Main2Blocks(subfri.get(SessionManager.KEY_FRI_SUB_3),
                            ("Attended: "+getPreviousAttendedClass[c]),("Total: "+getPreviousTotalClass[c]),
                            (percentageTextView(c)+"%"),setColorOfPercentageTextView(c),c,context,attend,mark.get("third")));
                }
                if(cnt >= 4)
                {
                    blocks.add(new Main2Blocks(subfri.get(SessionManager.KEY_FRI_SUB_4),
                            ("Attended: "+getPreviousAttendedClass[d]),("Total: "+getPreviousTotalClass[d]),
                            (percentageTextView(d)+"%"),setColorOfPercentageTextView(d),d,context,attend,mark.get("fourth")));
                }
                if(cnt >= 5)
                {
                    blocks.add(new Main2Blocks(subfri.get(SessionManager.KEY_FRI_SUB_5),
                            ("Attended: "+getPreviousAttendedClass[e]),("Total: "+getPreviousTotalClass[e]),
                            (percentageTextView(e)+"%"),setColorOfPercentageTextView(e),e,context,attend,mark.get("fifth")));
                }
                if(cnt >= 6)
                {
                    blocks.add(new Main2Blocks(subfri.get(SessionManager.KEY_FRI_SUB_6),
                            ("Attended: "+getPreviousAttendedClass[f]),("Total: "+getPreviousTotalClass[f]),
                            (percentageTextView(f)+"%"),setColorOfPercentageTextView(f),f,context,attend,mark.get("sixth")));
                }
                if(cnt >= 7)
                {
                    blocks.add(new Main2Blocks(subfri.get(SessionManager.KEY_FRI_SUB_7),
                            ("Attended: "+getPreviousAttendedClass[g]),("Total: "+getPreviousTotalClass[g]),
                            (percentageTextView(g)+"%"),setColorOfPercentageTextView(g),g,context,attend,mark.get("seventh")));
                }
            }
        }

        if(todayDay.equals("Saturday")) {

            cnt = sessionManager.getCountSat();

            int a=matchForSubjectNumber(subsat.get(SessionManager.KEY_SAT_SUB_1));
            int b=matchForSubjectNumber(subsat.get(SessionManager.KEY_SAT_SUB_2));
            int c=matchForSubjectNumber(subsat.get(SessionManager.KEY_SAT_SUB_3));
            int d=matchForSubjectNumber(subsat.get(SessionManager.KEY_SAT_SUB_4));
            int e=matchForSubjectNumber(subsat.get(SessionManager.KEY_SAT_SUB_5));
            int f=matchForSubjectNumber(subsat.get(SessionManager.KEY_SAT_SUB_6));
            int g=matchForSubjectNumber(subsat.get(SessionManager.KEY_SAT_SUB_7));

            if(cnt == 0){
                offLayout.setVisibility(View.VISIBLE);
            } else {
                if (cnt >= 1) {
                    blocks.add(new Main2Blocks(subsat.get(SessionManager.KEY_SAT_SUB_1),
                            ("Attended: "+getPreviousAttendedClass[a]),("Total: "+getPreviousTotalClass[a]),
                            (percentageTextView(a)+"%"),setColorOfPercentageTextView(a),a,context,attend,mark.get("first")));
                }
                if (cnt >= 2) {
                    blocks.add(new Main2Blocks(subsat.get(SessionManager.KEY_SAT_SUB_2),
                            ("Attended: "+getPreviousAttendedClass[b]),("Total: "+getPreviousTotalClass[b]),
                            (percentageTextView(b)+"%"),setColorOfPercentageTextView(b),b,context,attend,mark.get("second")));
                }
                if (cnt >= 3) {
                    blocks.add(new Main2Blocks(subsat.get(SessionManager.KEY_SAT_SUB_3),
                            ("Attended: "+getPreviousAttendedClass[c]),("Total: "+getPreviousTotalClass[c]),
                            (percentageTextView(c)+"%"),setColorOfPercentageTextView(c),c,context,attend,mark.get("third")));
                }
                if (cnt >= 4) {
                    blocks.add(new Main2Blocks(subsat.get(SessionManager.KEY_SAT_SUB_4),
                            ("Attended: "+getPreviousAttendedClass[d]),("Total: "+getPreviousTotalClass[d]),
                            (percentageTextView(d)+"%"),setColorOfPercentageTextView(d),d,context,attend,mark.get("fourth")));
                }
                if (cnt >= 5) {
                    blocks.add(new Main2Blocks(subsat.get(SessionManager.KEY_SAT_SUB_5),
                            ("Attended: "+getPreviousAttendedClass[e]),("Total: "+getPreviousTotalClass[e]),
                            (percentageTextView(e)+"%"),setColorOfPercentageTextView(e),e,context,attend,mark.get("fifth")));
                }
                if (cnt >= 6) {
                    blocks.add(new Main2Blocks(subsat.get(SessionManager.KEY_SAT_SUB_6),
                            ("Attended: "+getPreviousAttendedClass[f]),("Total: "+getPreviousTotalClass[f]),
                            (percentageTextView(f)+"%"),setColorOfPercentageTextView(f),f,context,attend,mark.get("sixth")));
                }
                if (cnt >= 7) {
                    blocks.add(new Main2Blocks(subsat.get(SessionManager.KEY_SAT_SUB_7),
                            ("Attended: "+getPreviousAttendedClass[g]),("Total: "+getPreviousTotalClass[g]),
                            (percentageTextView(g)+"%"),setColorOfPercentageTextView(g),g,context,attend,mark.get("seventh")));
                }
            }

        }

        if(todayDay.equals("Sunday")){
            offLayout.setVisibility(View.VISIBLE);
        }

    }
    public int matchForSubjectNumber(String period)
    {
        //to which subject no of the entered sub list does the given subject of the day matches.
        int ret=0;
        for(int i=0;i<sizeof;i++)
        {
            if(period.equals(totalSubjects[i]))
            {
                ret=i;
                break;
            }
        }
        return ret;
    }
    public String percentageTextView(int ch)
    {
        float x=0.0f;
        String str="0";
        float x1,x2,x3;
        x1=getPreviousAttendedClass[ch];
        x2=getPreviousTotalClass[ch];
        x3=100;
        x=(x1/x2)*x3;
        if(x==100)
            str="100";
        else
            str=String.format(java.util.Locale.US,"%.1f",x);
        return str;
    }
    public String setColorOfPercentageTextView(int ch) {
        float x=0.0f;
        float x1,x2,x3,tempx,tempx1,tempx2;
        x1=getPreviousAttendedClass[ch];
        x2=getPreviousTotalClass[ch];
        x3=100;
        x=(x1/x2)*x3;
        String string="";
        if(x<attend)
        {
            //tvPercentage1.setTextColor(Color.parseColor("#B22222"));//red
            tempx=x;
            tempx1=x1;
            tempx2=x2;
            int cnt=0;
            while(tempx<attend)
            {
                tempx1++;
                tempx2++;
                cnt++;
                tempx=(tempx1/tempx2)*x3;
                if(tempx<attend)
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
            //tvPercentage1.setTextColor(Color.parseColor("#008000"));//green
            string="!!! You are on track !!!";
        }
        return string;
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        HashMap<String ,String> today=sessionManager.getDay();
        String todayDay=today.get("day_date");
        getActivity().setTitle(todayDay);
    }
}
