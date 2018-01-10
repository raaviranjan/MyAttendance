package com.example.ravi.myattendance;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import static android.R.attr.fragment;
import static android.R.attr.searchHintIcon;

/**
 * Created by Ravi on 07-Oct-17.
 */

public class Welcome extends Fragment {
    TextView t,t1,t2,tv,t3,t4,t5,t6,t7;
    Button b;
    SessionManager sessionManager;
    String sssssssss="";
    String abcde="";
    String sss="";
    String ssss="";
    Calendar calendar;
    Integer gCountMon,gCountTue,gCountWed,gCountThu,gCountFri,gCountSat;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.welcome,viewGroup,false);
        tv=(TextView)view.findViewById(R.id.tname);
        t=(TextView)view.findViewById(R.id.tgender);
        t1=(TextView)view.findViewById(R.id.tattend);
        t2=(TextView)view.findViewById(R.id.tmon);
        t3=(TextView)view.findViewById(R.id.ttue);
        t4=(TextView)view.findViewById(R.id.twed);
        t5=(TextView)view.findViewById(R.id.tthu);
        t6=(TextView)view.findViewById(R.id.tfri);
        t7=(TextView)view.findViewById(R.id.tsat);
        b=(Button)view.findViewById(R.id.buttonToGoToHomePage);
        sessionManager=new SessionManager(getActivity());


        HashMap<String ,String> str=sessionManager.getUserDetails();
        String string =str.get(SessionManager.KEY_NAME);
        String st=str.get(SessionManager.KEY_GENDER);
        String at=str.get(SessionManager.KEY_ATTENDANCE);

        HashMap<String ,String> subj=sessionManager.getMonSubjects();
        String sub=subj.get(SessionManager.KEY_MON_SUB_1)+" "+subj.get(SessionManager.KEY_MON_SUB_2)
                +" "+subj.get(SessionManager.KEY_MON_SUB_3) +" "+subj.get(SessionManager.KEY_MON_SUB_4)
                +" "+subj.get(SessionManager.KEY_MON_SUB_5)+" "+subj.get(SessionManager.KEY_MON_SUB_6)
                +" "+subj.get(SessionManager.KEY_MON_SUB_7);
        //String[] abcd=sessionManager.getMonSubjects("MondaySubjects");

        HashMap<String ,String> subtue=sessionManager.getTueSubjects();
        String subtuesday=subtue.get(SessionManager.KEY_TUE_SUB_1)+" "+subtue.get(SessionManager.KEY_TUE_SUB_2)
                +" "+subtue.get(SessionManager.KEY_TUE_SUB_3) +" "+subtue.get(SessionManager.KEY_TUE_SUB_4)
                +" "+subtue.get(SessionManager.KEY_TUE_SUB_5)+" "+subtue.get(SessionManager.KEY_TUE_SUB_6)
                +" "+subtue.get(SessionManager.KEY_TUE_SUB_7);

        HashMap<String ,String> subwed=sessionManager.getWedSubjects();
        String subwednesday=subwed.get(SessionManager.KEY_WED_SUB_1)+" "+subwed.get(SessionManager.KEY_WED_SUB_2)
                +" "+subwed.get(SessionManager.KEY_WED_SUB_3) +" "+subwed.get(SessionManager.KEY_WED_SUB_4)
                +" "+subwed.get(SessionManager.KEY_WED_SUB_5)+" "+subwed.get(SessionManager.KEY_WED_SUB_6)
                +" "+subwed.get(SessionManager.KEY_WED_SUB_7);

        HashMap<String ,String> subthu=sessionManager.getThuSubjects();
        String subthurs=subthu.get(SessionManager.KEY_THU_SUB_1)+" "+subthu.get(SessionManager.KEY_THU_SUB_2)
                +" "+subthu.get(SessionManager.KEY_THU_SUB_3) +" "+subthu.get(SessionManager.KEY_THU_SUB_4)
                +" "+subthu.get(SessionManager.KEY_THU_SUB_5)+" "+subthu.get(SessionManager.KEY_THU_SUB_6)
                +" "+subthu.get(SessionManager.KEY_THU_SUB_7);

        HashMap<String ,String> subfri=sessionManager.getFriSubjects();
        String subfriday=subfri.get(SessionManager.KEY_FRI_SUB_1)+" "+subfri.get(SessionManager.KEY_FRI_SUB_2)
                +" "+subfri.get(SessionManager.KEY_FRI_SUB_3) +" "+subfri.get(SessionManager.KEY_FRI_SUB_4)
                +" "+subfri.get(SessionManager.KEY_FRI_SUB_5)+" "+subfri.get(SessionManager.KEY_FRI_SUB_6)
                +" "+subfri.get(SessionManager.KEY_FRI_SUB_7);

        HashMap<String ,String> subsat=sessionManager.getSatSubjects();
        String subsatur=subsat.get(SessionManager.KEY_SAT_SUB_1)+" "+subsat.get(SessionManager.KEY_SAT_SUB_2)
                +" "+subsat.get(SessionManager.KEY_SAT_SUB_3) +" "+subsat.get(SessionManager.KEY_SAT_SUB_4)
                +" "+subsat.get(SessionManager.KEY_SAT_SUB_5)+" "+subsat.get(SessionManager.KEY_SAT_SUB_6)
                +" "+subsat.get(SessionManager.KEY_SAT_SUB_7);


        int sizeof=sessionManager.getSize();
        String[] totalSubjects=sessionManager.loadArray("mySubject");
        for(int i=0;i<sizeof;i++){
            sssssssss+=totalSubjects[i]+" ";
        }
        /*for(int i=0;i<sizeof;i++){
            abcde+=abcd[i]+" ";
        }*/
        Integer[] clsAttend=sessionManager.getAttended("classAttended");
        Integer[] clsTotal=sessionManager.getTotal("classTotal");
        for(int j=0;j<sizeof;j++){
            sss+=String.valueOf(clsAttend[j])+" ";
            ssss+=String.valueOf(clsTotal[j])+" ";
        }

        gCountMon=sessionManager.getCountMon();
        gCountTue=sessionManager.getCountTue();
        gCountWed=sessionManager.getCountWed();
        gCountThu=sessionManager.getCountThu();
        gCountFri=sessionManager.getCountFri();
        gCountSat=sessionManager.getCountSat();

        calendar=Calendar.getInstance();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
                Date d = new Date();
                String dayOfTheWeek = sdf.format(d);
                SimpleDateFormat sdf1 = new SimpleDateFormat("EEEE, dd MMM yyyy");
                Date d1 = new Date();
                String dayAndDate = sdf1.format(d1);
                sessionManager.setCalendarDetails(dayOfTheWeek,dayAndDate);
                HashMap<String ,String> today=sessionManager.getDay();
                String todayDate=today.get("day")+" "+today.get("day_date");
                int cnt=0;
                //Toast.makeText(getActivity(), dayOfTheWeek+" "+dayAndDate, Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), cnt+" "+todayDate+" "+gCountMon+" "+gCountTue+" "+gCountWed+" "+gCountThu+" "+gCountFri+" "+gCountSat, Toast.LENGTH_LONG).show();
                Fragment fragment1=new Main();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, fragment1);
                ft.commit();
            }
        });

        tv.setText(string);
        t.setText(st);
        t1.setText(at);
        t2.setText(sssssssss);
        t3.setText(subtuesday);
        t4.setText(subwednesday);
        t5.setText(subthurs);
        t6.setText(subfriday);
        t7.setText(sss+" "+ssss);

        return view;

    }
    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        getActivity().setTitle("Home Page");
    }
}
