package com.example.ravi.myattendance;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Ravi on 10-Nov-17.
 */

public class Main extends Fragment {
    Button buttonToMark1,buttonToMark2,buttonToMark3,buttonToMark4,buttonToMark5,buttonToMark6,buttonToMark7;
    ImageButton iBReset1,iBWrong1,iBRight1,iBReset2,iBWrong2,iBRight2,iBReset3,iBWrong3,iBRight3,iBReset4,iBWrong4,iBRight4,
            iBReset5,iBWrong5,iBRight5,iBReset6,iBWrong6,iBRight6,iBReset7,iBWrong7,iBRight7;
    LinearLayout linearLayoutToMark1,linearLayoutToMark2,linearLayoutToMark3,linearLayoutToMark4,linearLayoutToMark5,linearLayoutToMark6,linearLayoutToMark7,
            sub1Layout,sub2Layout,sub3Layout,sub4Layout,sub5Layout,sub6Layout,sub7Layout,offLayout;
    ImageView ivAfterMark1,ivAfterMark2,ivAfterMark3,ivAfterMark4,ivAfterMark5,ivAfterMark6,ivAfterMark7;
    TextView mainTVSub1,mainTVSub2,mainTVSub3,mainTVSub4,mainTVSub5,mainTVSub6,mainTVSub7,
            tvAttendedClass1,tvAttendedClass2,tvAttendedClass3,tvAttendedClass4,tvAttendedClass5,tvAttendedClass6,tvAttendedClass7,
            tvTotalClass1,tvTotalClass2,tvTotalClass3,tvTotalClass4,tvTotalClass5,tvTotalClass6,tvTotalClass7,
            tvPercentage1,tvPercentage2,tvPercentage3,tvPercentage4,tvPercentage5,tvPercentage6,tvPercentage7,
            tvOnTrack1,tvOnTrack2,tvOnTrack3,tvOnTrack4,tvOnTrack5,tvOnTrack6,tvOnTrack7;
    SessionManager sessionManager;
    Integer[] getPreviousAttendedClass;
    Integer[] getPreviousTotalClass;
    String[] totalSubjects;
    Calendar calendar;
    HashMap<String ,String> subj;
    HashMap<String ,String> subtue;
    HashMap<String ,String> subwed;
    HashMap<String ,String> subthu;
    HashMap<String ,String> subfri;
    HashMap<String ,String> subsat;
    int a,sizeof,present1=0,absent1=0,present2=0,absent2=0,present3=0,absent3=0,present4=0,absent4=0,present5=0,absent5=0,
            present6=0,absent6=0,present7=0,absent7=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.main,viewGroup,false);

        sub1Layout=(LinearLayout)view.findViewById(R.id.sub1Layout);
        sub2Layout=(LinearLayout)view.findViewById(R.id.sub2Layout);
        sub3Layout=(LinearLayout)view.findViewById(R.id.sub3Layout);
        sub4Layout=(LinearLayout)view.findViewById(R.id.sub4Layout);
        sub5Layout=(LinearLayout)view.findViewById(R.id.sub5Layout);
        sub6Layout=(LinearLayout)view.findViewById(R.id.sub6Layout);
        sub7Layout=(LinearLayout)view.findViewById(R.id.sub7Layout);

        offLayout=(LinearLayout)view.findViewById(R.id.offLayout);

        tvTotalClass1=(TextView)view.findViewById(R.id.tvTotalClass1);
        tvTotalClass2=(TextView)view.findViewById(R.id.tvTotalClass2);
        tvTotalClass3=(TextView)view.findViewById(R.id.tvTotalClass3);
        tvTotalClass4=(TextView)view.findViewById(R.id.tvTotalClass4);
        tvTotalClass5=(TextView)view.findViewById(R.id.tvTotalClass5);
        tvTotalClass6=(TextView)view.findViewById(R.id.tvTotalClass6);
        tvTotalClass7=(TextView)view.findViewById(R.id.tvTotalClass7);

        tvAttendedClass1=(TextView)view.findViewById(R.id.tvAttendedClass1);
        tvAttendedClass2=(TextView)view.findViewById(R.id.tvAttendedClass2);
        tvAttendedClass3=(TextView)view.findViewById(R.id.tvAttendedClass3);
        tvAttendedClass4=(TextView)view.findViewById(R.id.tvAttendedClass4);
        tvAttendedClass5=(TextView)view.findViewById(R.id.tvAttendedClass5);
        tvAttendedClass6=(TextView)view.findViewById(R.id.tvAttendedClass6);
        tvAttendedClass7=(TextView)view.findViewById(R.id.tvAttendedClass7);

        tvPercentage1=(TextView)view.findViewById(R.id.tvPercentage1);
        tvPercentage2=(TextView)view.findViewById(R.id.tvPercentage2);
        tvPercentage3=(TextView)view.findViewById(R.id.tvPercentage3);
        tvPercentage4=(TextView)view.findViewById(R.id.tvPercentage4);
        tvPercentage5=(TextView)view.findViewById(R.id.tvPercentage5);
        tvPercentage6=(TextView)view.findViewById(R.id.tvPercentage6);
        tvPercentage7=(TextView)view.findViewById(R.id.tvPercentage7);

        tvOnTrack1=(TextView)view.findViewById(R.id.tvOnTrack1);
        tvOnTrack2=(TextView)view.findViewById(R.id.tvOnTrack2);
        tvOnTrack3=(TextView)view.findViewById(R.id.tvOnTrack3);
        tvOnTrack4=(TextView)view.findViewById(R.id.tvOnTrack4);
        tvOnTrack5=(TextView)view.findViewById(R.id.tvOnTrack5);
        tvOnTrack6=(TextView)view.findViewById(R.id.tvOnTrack6);
        tvOnTrack7=(TextView)view.findViewById(R.id.tvOnTrack7);

        mainTVSub1=(TextView)view.findViewById(R.id.mainTVSub1);
        mainTVSub2=(TextView)view.findViewById(R.id.mainTVSub2);
        mainTVSub3=(TextView)view.findViewById(R.id.mainTVSub3);
        mainTVSub4=(TextView)view.findViewById(R.id.mainTVSub4);
        mainTVSub5=(TextView)view.findViewById(R.id.mainTVSub5);
        mainTVSub6=(TextView)view.findViewById(R.id.mainTVSub6);
        mainTVSub7=(TextView)view.findViewById(R.id.mainTVSub7);

        sessionManager=new SessionManager(getActivity());
        subj=sessionManager.getMonSubjects();
        subtue=sessionManager.getTueSubjects();
        subwed=sessionManager.getWedSubjects();
        subthu=sessionManager.getThuSubjects();
        subfri=sessionManager.getFriSubjects();
        subsat=sessionManager.getSatSubjects();

        calendar=Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        String dayOfTheWeek = sdf.format(d);
        SimpleDateFormat sdf1 = new SimpleDateFormat("EEEE, dd MMM yyyy");
        Date d1 = new Date();
        String dayAndDate = sdf1.format(d1);
        sessionManager.setCalendarDetails(dayOfTheWeek,dayAndDate);

        getPreviousAttendedClass=sessionManager.getAttended("classAttended");
        getPreviousTotalClass=sessionManager.getTotal("classTotal");
        totalSubjects=sessionManager.loadArray("mySubject");
        sizeof=sessionManager.getSize();

        //Subject 1
        buttonToMark1=(Button)view.findViewById(R.id.buttonToMark1);
        linearLayoutToMark1=(LinearLayout)view.findViewById(R.id.linearLayoutToMark1);
        iBReset1=(ImageButton)view.findViewById(R.id.iBReset1);
        iBWrong1=(ImageButton)view.findViewById(R.id.iBWrong1);
        iBRight1=(ImageButton)view.findViewById(R.id.iBRight1);
        ivAfterMark1=(ImageView)view.findViewById(R.id.ivAfterMarking1);

        buttonToMark1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayoutToMark1.setVisibility(View.VISIBLE);
            }
        });
        iBRight1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                present1++;
                int b;
                buttonToMark1.setText("Attendance Marked. Reset?");
                linearLayoutToMark1.setVisibility(View.GONE);
                ivAfterMark1.setImageResource(R.drawable.right);
                b=matchForSubjectWiseMarking(0);
                getPreviousAttendedClass[b]++;
                getPreviousTotalClass[b]++;
                tvAttendedClass1.setText("Attended: "+getPreviousAttendedClass[b]);
                tvTotalClass1.setText("Total: "+getPreviousTotalClass[b]);
                tvPercentage1.setText(percentageTextView(b)+"%");
                setColorOfPercentageTextView(b,b,40,40,40,40,40,40);
                sessionManager.setAttended(getPreviousAttendedClass,"classAttended");
                sessionManager.setTotal(getPreviousTotalClass,"classTotal");
                String string=mainTVSub1.getText().toString();
                Toast.makeText(getActivity(), "Attended "+string, Toast.LENGTH_SHORT).show();
            }
        });
        iBWrong1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                absent1++;
                int b;
                buttonToMark1.setText("Attendance Marked. Reset?");
                linearLayoutToMark1.setVisibility(View.GONE);
                ivAfterMark1.setImageResource(R.drawable.wrong);
                b=matchForSubjectWiseMarking(0);
                getPreviousTotalClass[b]++;
                tvAttendedClass1.setText("Attended: "+getPreviousAttendedClass[b]);
                tvTotalClass1.setText("Total: "+getPreviousTotalClass[b]);
                tvPercentage1.setText(percentageTextView(b)+"%");
                setColorOfPercentageTextView(b,b,40,40,40,40,40,40);
                sessionManager.setAttended(getPreviousAttendedClass,"classAttended");
                sessionManager.setTotal(getPreviousTotalClass,"classTotal");
                String string=mainTVSub1.getText().toString();
                Toast.makeText(getActivity(), "Missed "+string, Toast.LENGTH_SHORT).show();
            }
        });
        iBReset1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int b;
                buttonToMark1.setText("Click To Mark Attendance");
                linearLayoutToMark1.setVisibility(View.GONE);
                ivAfterMark1.setImageResource(R.drawable.unchecked);
                b=matchForSubjectWiseMarking(0);
                getPreviousTotalClass[b]-=(present1+absent1);
                getPreviousAttendedClass[b]-=present1;
                present1=0;
                absent1=0;
                tvAttendedClass1.setText("Attended: "+getPreviousAttendedClass[b]);
                tvTotalClass1.setText("Total: "+getPreviousTotalClass[b]);
                tvPercentage1.setText(percentageTextView(b)+"%");
                setColorOfPercentageTextView(b,b,40,40,40,40,40,40);
                sessionManager.setAttended(getPreviousAttendedClass,"classAttended");
                sessionManager.setTotal(getPreviousTotalClass,"classTotal");
                Toast.makeText(getActivity(), "Reset", Toast.LENGTH_SHORT).show();
            }
        });
        //Subject 2
        buttonToMark2=(Button)view.findViewById(R.id.buttonToMark2);
        linearLayoutToMark2=(LinearLayout)view.findViewById(R.id.linearLayoutToMark2);
        iBReset2=(ImageButton)view.findViewById(R.id.iBReset2);
        iBWrong2=(ImageButton)view.findViewById(R.id.iBWrong2);
        iBRight2=(ImageButton)view.findViewById(R.id.iBRight2);
        ivAfterMark2=(ImageView)view.findViewById(R.id.ivAfterMarking2);

        buttonToMark2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayoutToMark2.setVisibility(View.VISIBLE);
            }
        });
        iBRight2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                present2++;
                int b;
                buttonToMark2.setText("Attendance Marked. Reset?");
                linearLayoutToMark2.setVisibility(View.GONE);
                ivAfterMark2.setImageResource(R.drawable.right);
                b=matchForSubjectWiseMarking(1);
                getPreviousAttendedClass[b]++;
                getPreviousTotalClass[b]++;
                tvAttendedClass2.setText("Attended: "+getPreviousAttendedClass[b]);
                tvTotalClass2.setText("Total: "+getPreviousTotalClass[b]);
                tvPercentage2.setText(percentageTextView(b)+"%");
                setColorOfPercentageTextView(b,40,b,40,40,40,40,40);
                sessionManager.setAttended(getPreviousAttendedClass,"classAttended");
                sessionManager.setTotal(getPreviousTotalClass,"classTotal");
                String string=mainTVSub2.getText().toString();
                Toast.makeText(getActivity(), "Attended "+string, Toast.LENGTH_SHORT).show();
            }
        });
        iBWrong2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                absent2++;
                int b;
                buttonToMark2.setText("Attendance Marked. Reset?");
                linearLayoutToMark2.setVisibility(View.GONE);
                ivAfterMark2.setImageResource(R.drawable.wrong);
                b=matchForSubjectWiseMarking(1);
                getPreviousTotalClass[b]++;
                tvAttendedClass2.setText("Attended: "+getPreviousAttendedClass[b]);
                tvTotalClass2.setText("Total: "+getPreviousTotalClass[b]);
                tvPercentage2.setText(percentageTextView(b)+"%");
                setColorOfPercentageTextView(b,40,b,40,40,40,40,40);
                sessionManager.setAttended(getPreviousAttendedClass,"classAttended");
                sessionManager.setTotal(getPreviousTotalClass,"classTotal");
                String string=mainTVSub2.getText().toString();
                Toast.makeText(getActivity(), "Missed "+string, Toast.LENGTH_SHORT).show();
            }
        });
        iBReset2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int b;
                buttonToMark2.setText("Click To Mark Attendance");
                linearLayoutToMark2.setVisibility(View.GONE);
                ivAfterMark2.setImageResource(R.drawable.unchecked);
                b=matchForSubjectWiseMarking(1);
                getPreviousTotalClass[b]-=(present2+absent2);
                getPreviousAttendedClass[b]-=present2;
                present2=0;
                absent2=0;
                tvAttendedClass2.setText("Attended: "+getPreviousAttendedClass[b]);
                tvTotalClass2.setText("Total: "+getPreviousTotalClass[b]);
                tvPercentage2.setText(percentageTextView(b)+"%");
                setColorOfPercentageTextView(b,40,b,40,40,40,40,40);
                sessionManager.setAttended(getPreviousAttendedClass,"classAttended");
                sessionManager.setTotal(getPreviousTotalClass,"classTotal");
                Toast.makeText(getActivity(), "Reset", Toast.LENGTH_SHORT).show();
            }
        });

        //Subject 3
        buttonToMark3=(Button)view.findViewById(R.id.buttonToMark3);
        linearLayoutToMark3=(LinearLayout)view.findViewById(R.id.linearLayoutToMark3);
        iBReset3=(ImageButton)view.findViewById(R.id.iBReset3);
        iBWrong3=(ImageButton)view.findViewById(R.id.iBWrong3);
        iBRight3=(ImageButton)view.findViewById(R.id.iBRight3);
        ivAfterMark3=(ImageView)view.findViewById(R.id.ivAfterMarking3);

        buttonToMark3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayoutToMark3.setVisibility(View.VISIBLE);
            }
        });
        iBRight3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                present3++;
                int b;
                buttonToMark3.setText("Attendance Marked. Reset?");
                linearLayoutToMark3.setVisibility(View.GONE);
                ivAfterMark3.setImageResource(R.drawable.right);
                b=matchForSubjectWiseMarking(2);
                getPreviousAttendedClass[b]++;
                getPreviousTotalClass[b]++;
                tvAttendedClass3.setText("Attended: "+getPreviousAttendedClass[b]);
                tvTotalClass3.setText("Total: "+getPreviousTotalClass[b]);
                tvPercentage3.setText(percentageTextView(b)+"%");
                setColorOfPercentageTextView(b,40,40,b,40,40,40,40);
                sessionManager.setAttended(getPreviousAttendedClass,"classAttended");
                sessionManager.setTotal(getPreviousTotalClass,"classTotal");
                String string=mainTVSub3.getText().toString();
                Toast.makeText(getActivity(), "Attended "+string, Toast.LENGTH_SHORT).show();
            }
        });
        iBWrong3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                absent3++;
                int b;
                buttonToMark3.setText("Attendance Marked. Reset?");
                linearLayoutToMark3.setVisibility(View.GONE);
                ivAfterMark3.setImageResource(R.drawable.wrong);
                b=matchForSubjectWiseMarking(2);
                getPreviousTotalClass[b]++;
                tvAttendedClass3.setText("Attended: "+getPreviousAttendedClass[b]);
                tvTotalClass3.setText("Total: "+getPreviousTotalClass[b]);
                tvPercentage3.setText(percentageTextView(b)+"%");
                setColorOfPercentageTextView(b,40,40,b,40,40,40,40);
                sessionManager.setAttended(getPreviousAttendedClass,"classAttended");
                sessionManager.setTotal(getPreviousTotalClass,"classTotal");
                String string=mainTVSub3.getText().toString();
                Toast.makeText(getActivity(), "Missed "+string, Toast.LENGTH_SHORT).show();
            }
        });
        iBReset3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int b;
                buttonToMark3.setText("Click To Mark Attendance");
                linearLayoutToMark3.setVisibility(View.GONE);
                ivAfterMark3.setImageResource(R.drawable.unchecked);
                b=matchForSubjectWiseMarking(2);
                getPreviousTotalClass[b]-=(present3+absent3);
                getPreviousAttendedClass[b]-=present3;
                present3=0;
                absent3=0;
                tvAttendedClass3.setText("Attended: "+getPreviousAttendedClass[b]);
                tvTotalClass3.setText("Total: "+getPreviousTotalClass[b]);
                tvPercentage3.setText(percentageTextView(b)+"%");
                setColorOfPercentageTextView(b,40,40,b,40,40,40,40);
                sessionManager.setAttended(getPreviousAttendedClass,"classAttended");
                sessionManager.setTotal(getPreviousTotalClass,"classTotal");
                Toast.makeText(getActivity(), "Reset", Toast.LENGTH_SHORT).show();
            }
        });

        //Subject 4
        buttonToMark4=(Button)view.findViewById(R.id.buttonToMark4);
        linearLayoutToMark4=(LinearLayout)view.findViewById(R.id.linearLayoutToMark4);
        iBReset4=(ImageButton)view.findViewById(R.id.iBReset4);
        iBWrong4=(ImageButton)view.findViewById(R.id.iBWrong4);
        iBRight4=(ImageButton)view.findViewById(R.id.iBRight4);
        ivAfterMark4=(ImageView)view.findViewById(R.id.ivAfterMarking4);

        buttonToMark4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayoutToMark4.setVisibility(View.VISIBLE);
            }
        });
        iBRight4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                present4++;
                int b;
                buttonToMark4.setText("Attendance Marked. Reset?");
                linearLayoutToMark4.setVisibility(View.GONE);
                ivAfterMark4.setImageResource(R.drawable.right);
                b=matchForSubjectWiseMarking(3);
                getPreviousAttendedClass[b]++;
                getPreviousTotalClass[b]++;
                tvAttendedClass4.setText("Attended: "+getPreviousAttendedClass[b]);
                tvTotalClass4.setText("Total: "+getPreviousTotalClass[b]);
                tvPercentage4.setText(percentageTextView(b)+"%");
                setColorOfPercentageTextView(b,40,40,40,b,40,40,40);
                sessionManager.setAttended(getPreviousAttendedClass,"classAttended");
                sessionManager.setTotal(getPreviousTotalClass,"classTotal");
                String string=mainTVSub4.getText().toString();
                Toast.makeText(getActivity(), "Attended "+string, Toast.LENGTH_SHORT).show();
            }
        });
        iBWrong4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                absent4++;
                int b;
                buttonToMark4.setText("Attendance Marked. Reset?");
                linearLayoutToMark4.setVisibility(View.GONE);
                ivAfterMark4.setImageResource(R.drawable.wrong);
                b=matchForSubjectWiseMarking(3);
                getPreviousTotalClass[b]++;
                tvAttendedClass4.setText("Attended: "+getPreviousAttendedClass[b]);
                tvTotalClass4.setText("Total: "+getPreviousTotalClass[b]);
                tvPercentage4.setText(percentageTextView(b)+"%");
                setColorOfPercentageTextView(b,40,40,40,b,40,40,40);
                sessionManager.setAttended(getPreviousAttendedClass,"classAttended");
                sessionManager.setTotal(getPreviousTotalClass,"classTotal");
                String string=mainTVSub4.getText().toString();
                Toast.makeText(getActivity(), "Missed "+string, Toast.LENGTH_SHORT).show();
            }
        });
        iBReset4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int b;
                buttonToMark4.setText("Click To Mark Attendance");
                linearLayoutToMark4.setVisibility(View.GONE);
                ivAfterMark4.setImageResource(R.drawable.unchecked);
                b=matchForSubjectWiseMarking(3);
                getPreviousTotalClass[b]-=(present4+absent4);
                getPreviousAttendedClass[b]-=present4;
                present4=0;
                absent4=0;
                tvAttendedClass4.setText("Attended: "+getPreviousAttendedClass[b]);
                tvTotalClass4.setText("Total: "+getPreviousTotalClass[b]);
                tvPercentage4.setText(percentageTextView(b)+"%");
                setColorOfPercentageTextView(b,40,40,40,b,40,40,40);
                sessionManager.setAttended(getPreviousAttendedClass,"classAttended");
                sessionManager.setTotal(getPreviousTotalClass,"classTotal");
                Toast.makeText(getActivity(), "Reset", Toast.LENGTH_SHORT).show();
            }
        });

        //Subject 5
        buttonToMark5=(Button)view.findViewById(R.id.buttonToMark5);
        linearLayoutToMark5=(LinearLayout)view.findViewById(R.id.linearLayoutToMark5);
        iBReset5=(ImageButton)view.findViewById(R.id.iBReset5);
        iBWrong5=(ImageButton)view.findViewById(R.id.iBWrong5);
        iBRight5=(ImageButton)view.findViewById(R.id.iBRight5);
        ivAfterMark5=(ImageView)view.findViewById(R.id.ivAfterMarking5);

        buttonToMark5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayoutToMark5.setVisibility(View.VISIBLE);
            }
        });
        iBRight5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                present5++;
                int b;
                buttonToMark5.setText("Attendance Marked. Reset?");
                linearLayoutToMark5.setVisibility(View.GONE);
                ivAfterMark5.setImageResource(R.drawable.right);
                b=matchForSubjectWiseMarking(4);
                getPreviousAttendedClass[b]++;
                getPreviousTotalClass[b]++;
                tvAttendedClass5.setText("Attended: "+getPreviousAttendedClass[b]);
                tvTotalClass5.setText("Total: "+getPreviousTotalClass[b]);
                tvPercentage5.setText(percentageTextView(b)+"%");
                setColorOfPercentageTextView(b,40,40,40,40,b,40,40);
                sessionManager.setAttended(getPreviousAttendedClass,"classAttended");
                sessionManager.setTotal(getPreviousTotalClass,"classTotal");
                String string=mainTVSub5.getText().toString();
                Toast.makeText(getActivity(), "Attended "+string, Toast.LENGTH_SHORT).show();
            }
        });
        iBWrong5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                absent5++;
                int b;
                buttonToMark5.setText("Attendance Marked. Reset?");
                linearLayoutToMark5.setVisibility(View.GONE);
                ivAfterMark5.setImageResource(R.drawable.wrong);
                b=matchForSubjectWiseMarking(4);
                getPreviousTotalClass[b]++;
                tvAttendedClass5.setText("Attended: "+getPreviousAttendedClass[b]);
                tvTotalClass5.setText("Total: "+getPreviousTotalClass[b]);
                tvPercentage5.setText(percentageTextView(b)+"%");
                setColorOfPercentageTextView(b,40,40,40,40,b,40,40);
                sessionManager.setAttended(getPreviousAttendedClass,"classAttended");
                sessionManager.setTotal(getPreviousTotalClass,"classTotal");
                String string=mainTVSub5.getText().toString();
                Toast.makeText(getActivity(), "Missed "+string, Toast.LENGTH_SHORT).show();
            }
        });
        iBReset5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int b;
                buttonToMark5.setText("Click To Mark Attendance");
                linearLayoutToMark5.setVisibility(View.GONE);
                ivAfterMark5.setImageResource(R.drawable.unchecked);
                b=matchForSubjectWiseMarking(4);
                getPreviousTotalClass[b]-=(present5+absent5);
                getPreviousAttendedClass[b]-=present5;
                present5=0;
                absent5=0;
                tvAttendedClass5.setText("Attended: "+getPreviousAttendedClass[b]);
                tvTotalClass5.setText("Total: "+getPreviousTotalClass[b]);
                tvPercentage5.setText(percentageTextView(b)+"%");
                setColorOfPercentageTextView(b,40,40,40,40,b,40,40);
                sessionManager.setAttended(getPreviousAttendedClass,"classAttended");
                sessionManager.setTotal(getPreviousTotalClass,"classTotal");
                Toast.makeText(getActivity(), "Reset", Toast.LENGTH_SHORT).show();
            }
        });

        //Subject 6
        buttonToMark6=(Button)view.findViewById(R.id.buttonToMark6);
        linearLayoutToMark6=(LinearLayout)view.findViewById(R.id.linearLayoutToMark6);
        iBReset6=(ImageButton)view.findViewById(R.id.iBReset6);
        iBWrong6=(ImageButton)view.findViewById(R.id.iBWrong6);
        iBRight6=(ImageButton)view.findViewById(R.id.iBRight6);
        ivAfterMark6=(ImageView)view.findViewById(R.id.ivAfterMarking6);

        buttonToMark6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayoutToMark6.setVisibility(View.VISIBLE);
            }
        });
        iBRight6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                present6++;
                int b;
                buttonToMark6.setText("Attendance Marked. Reset?");
                linearLayoutToMark6.setVisibility(View.GONE);
                ivAfterMark6.setImageResource(R.drawable.right);
                b=matchForSubjectWiseMarking(5);
                getPreviousAttendedClass[b]++;
                getPreviousTotalClass[b]++;
                tvAttendedClass6.setText("Attended: "+getPreviousAttendedClass[b]);
                tvTotalClass6.setText("Total: "+getPreviousTotalClass[b]);
                tvPercentage6.setText(percentageTextView(b)+"%");
                setColorOfPercentageTextView(b,40,40,40,40,40,b,40);
                sessionManager.setAttended(getPreviousAttendedClass,"classAttended");
                sessionManager.setTotal(getPreviousTotalClass,"classTotal");
                String string=mainTVSub6.getText().toString();
                Toast.makeText(getActivity(), "Attended "+string, Toast.LENGTH_SHORT).show();
            }
        });
        iBWrong6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                absent6++;
                int b;
                buttonToMark6.setText("Attendance Marked. Reset?");
                linearLayoutToMark6.setVisibility(View.GONE);
                ivAfterMark6.setImageResource(R.drawable.wrong);
                b=matchForSubjectWiseMarking(5);
                getPreviousTotalClass[b]++;
                tvAttendedClass6.setText("Attended: "+getPreviousAttendedClass[b]);
                tvTotalClass6.setText("Total: "+getPreviousTotalClass[b]);
                tvPercentage6.setText(percentageTextView(b)+"%");
                setColorOfPercentageTextView(b,40,40,40,40,40,b,40);
                sessionManager.setAttended(getPreviousAttendedClass,"classAttended");
                sessionManager.setTotal(getPreviousTotalClass,"classTotal");
                String string=mainTVSub6.getText().toString();
                Toast.makeText(getActivity(), "Missed "+string, Toast.LENGTH_SHORT).show();
            }
        });
        iBReset6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int b;
                buttonToMark6.setText("Click To Mark Attendance");
                linearLayoutToMark6.setVisibility(View.GONE);
                ivAfterMark6.setImageResource(R.drawable.unchecked);
                b=matchForSubjectWiseMarking(5);
                getPreviousTotalClass[b]-=(present6+absent6);
                getPreviousAttendedClass[b]-=present6;
                present6=0;
                absent6=0;
                tvAttendedClass6.setText("Attended: "+getPreviousAttendedClass[b]);
                tvTotalClass6.setText("Total: "+getPreviousTotalClass[b]);
                tvPercentage6.setText(percentageTextView(b)+"%");
                setColorOfPercentageTextView(b,40,40,40,40,40,b,40);
                sessionManager.setAttended(getPreviousAttendedClass,"classAttended");
                sessionManager.setTotal(getPreviousTotalClass,"classTotal");
                Toast.makeText(getActivity(), "Reset", Toast.LENGTH_SHORT).show();
            }
        });

        //Subject 7
        buttonToMark7=(Button)view.findViewById(R.id.buttonToMark7);
        linearLayoutToMark7=(LinearLayout)view.findViewById(R.id.linearLayoutToMark7);
        iBReset7=(ImageButton)view.findViewById(R.id.iBReset7);
        iBWrong7=(ImageButton)view.findViewById(R.id.iBWrong7);
        iBRight7=(ImageButton)view.findViewById(R.id.iBRight7);
        ivAfterMark7=(ImageView)view.findViewById(R.id.ivAfterMarking7);

        buttonToMark7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayoutToMark7.setVisibility(View.VISIBLE);
            }
        });
        iBRight7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                present7++;
                int b;
                buttonToMark7.setText("Attendance Marked. Reset?");
                linearLayoutToMark7.setVisibility(View.GONE);
                ivAfterMark7.setImageResource(R.drawable.right);
                b=matchForSubjectWiseMarking(6);
                getPreviousAttendedClass[b]++;
                getPreviousTotalClass[b]++;
                tvAttendedClass7.setText("Attended: "+getPreviousAttendedClass[b]);
                tvTotalClass7.setText("Total: "+getPreviousTotalClass[b]);
                tvPercentage7.setText(percentageTextView(b)+"%");
                setColorOfPercentageTextView(b,40,40,40,40,40,40,b);
                sessionManager.setAttended(getPreviousAttendedClass,"classAttended");
                sessionManager.setTotal(getPreviousTotalClass,"classTotal");
                String string=mainTVSub7.getText().toString();
                Toast.makeText(getActivity(), "Attended "+string, Toast.LENGTH_SHORT).show();
            }
        });
        iBWrong7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                absent7++;
                int b;
                buttonToMark7.setText("Attendance Marked. Reset?");
                linearLayoutToMark7.setVisibility(View.GONE);
                ivAfterMark7.setImageResource(R.drawable.wrong);
                b=matchForSubjectWiseMarking(6);
                getPreviousTotalClass[b]++;
                tvAttendedClass7.setText("Attended: "+getPreviousAttendedClass[b]);
                tvTotalClass7.setText("Total: "+getPreviousTotalClass[b]);
                tvPercentage7.setText(percentageTextView(b)+"%");
                setColorOfPercentageTextView(b,40,40,40,40,40,40,b);
                sessionManager.setAttended(getPreviousAttendedClass,"classAttended");
                sessionManager.setTotal(getPreviousTotalClass,"classTotal");
                String string=mainTVSub7.getText().toString();
                Toast.makeText(getActivity(), "Missed "+string, Toast.LENGTH_SHORT).show();
            }
        });
        iBReset7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int b;
                buttonToMark7.setText("Click To Mark Attendance");
                linearLayoutToMark7.setVisibility(View.GONE);
                ivAfterMark7.setImageResource(R.drawable.unchecked);
                b=matchForSubjectWiseMarking(6);
                getPreviousTotalClass[b]-=(present7+absent7);
                getPreviousAttendedClass[b]-=present7;
                present7=0;
                absent7=0;
                tvAttendedClass7.setText("Attended: "+getPreviousAttendedClass[b]);
                tvTotalClass7.setText("Total: "+getPreviousTotalClass[b]);
                tvPercentage7.setText(percentageTextView(b)+"%");
                setColorOfPercentageTextView(b,40,40,40,40,40,40,b);
                sessionManager.setAttended(getPreviousAttendedClass,"classAttended");
                sessionManager.setTotal(getPreviousTotalClass,"classTotal");
                Toast.makeText(getActivity(), "Reset", Toast.LENGTH_SHORT).show();
            }
        });

        getSchedule();
        return view;
    }
    public void getSchedule(){
        int cnt=0;
        HashMap<String ,String> today=sessionManager.getDay();
        String todayDay=today.get("day");
        if(todayDay.equals("Sunday"))
        {
            cnt=0;
            sub1Layout.setVisibility(View.GONE);
            offLayout.setVisibility(View.VISIBLE);
        }
        else if(todayDay.equals("Monday"))
        {
            cnt=sessionManager.getCountMon();
            int a=setPreAttendance(subj.get(SessionManager.KEY_MON_SUB_1));
            int b=setPreAttendance(subj.get(SessionManager.KEY_MON_SUB_2));
            int c=setPreAttendance(subj.get(SessionManager.KEY_MON_SUB_3));
            int d=setPreAttendance(subj.get(SessionManager.KEY_MON_SUB_4));
            int e=setPreAttendance(subj.get(SessionManager.KEY_MON_SUB_5));
            int f=setPreAttendance(subj.get(SessionManager.KEY_MON_SUB_6));
            int g=setPreAttendance(subj.get(SessionManager.KEY_MON_SUB_7));
            tvPercentage1.setText(percentageTextView(a)+"%");
            tvPercentage2.setText(percentageTextView(b)+"%");
            tvPercentage3.setText(percentageTextView(c)+"%");
            tvPercentage4.setText(percentageTextView(d)+"%");
            tvPercentage5.setText(percentageTextView(e)+"%");
            tvPercentage6.setText(percentageTextView(f)+"%");
            tvPercentage7.setText(percentageTextView(g)+"%");
            setColorOfPercentageTextView(a,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(b,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(c,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(d,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(e,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(f,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(g,a,b,c,d,e,f,g);
            if(cnt>=1)
            {
                sub1Layout.setVisibility(View.VISIBLE);
                mainTVSub1.setText(subj.get(SessionManager.KEY_MON_SUB_1));
                tvAttendedClass1.setText("Attended: "+getPreviousAttendedClass[a]);
                tvTotalClass1.setText("Total: "+getPreviousTotalClass[a]);
            }
            if(cnt>=2)
            {
                sub2Layout.setVisibility(View.VISIBLE);
                mainTVSub2.setText(subj.get(SessionManager.KEY_MON_SUB_2));
                tvAttendedClass2.setText("Attended: "+getPreviousAttendedClass[b]);
                tvTotalClass2.setText("Total: "+getPreviousTotalClass[b]);
            }
            if(cnt>=3)
            {
                sub3Layout.setVisibility(View.VISIBLE);
                mainTVSub3.setText(subj.get(SessionManager.KEY_MON_SUB_3));
                tvAttendedClass3.setText("Attended: "+getPreviousAttendedClass[c]);
                tvTotalClass3.setText("Total: "+getPreviousTotalClass[c]);

            }
            if(cnt>=4)
            {
                sub4Layout.setVisibility(View.VISIBLE);
                mainTVSub4.setText(subj.get(SessionManager.KEY_MON_SUB_4));
                tvAttendedClass4.setText("Attended: "+getPreviousAttendedClass[d]);
                tvTotalClass4.setText("Total: "+getPreviousTotalClass[d]);
            }
            if(cnt>=5)
            {
                sub5Layout.setVisibility(View.VISIBLE);
                mainTVSub5.setText(subj.get(SessionManager.KEY_MON_SUB_5));
                tvAttendedClass5.setText("Attended: "+getPreviousAttendedClass[e]);
                tvTotalClass5.setText("Total: "+getPreviousTotalClass[e]);
            }
            if(cnt>=6)
            {
                sub6Layout.setVisibility(View.VISIBLE);
                mainTVSub6.setText(subj.get(SessionManager.KEY_MON_SUB_6));
                tvAttendedClass6.setText("Attended: "+getPreviousAttendedClass[f]);
                tvTotalClass6.setText("Total: "+getPreviousTotalClass[f]);
            }
            if(cnt>=7)
            {
                sub7Layout.setVisibility(View.VISIBLE);
                mainTVSub7.setText(subj.get(SessionManager.KEY_MON_SUB_7));
                tvAttendedClass7.setText("Attended: "+getPreviousAttendedClass[g]);
                tvTotalClass7.setText("Total: "+getPreviousTotalClass[g]);
            }
        }
        else if(todayDay.equals("Tuesday"))
        {
            cnt=sessionManager.getCountTue();
            int a=setPreAttendance(subtue.get(SessionManager.KEY_TUE_SUB_1));
            int b=setPreAttendance(subtue.get(SessionManager.KEY_TUE_SUB_2));
            int c=setPreAttendance(subtue.get(SessionManager.KEY_TUE_SUB_3));
            int d=setPreAttendance(subtue.get(SessionManager.KEY_TUE_SUB_4));
            int e=setPreAttendance(subtue.get(SessionManager.KEY_TUE_SUB_5));
            int f=setPreAttendance(subtue.get(SessionManager.KEY_TUE_SUB_6));
            int g=setPreAttendance(subtue.get(SessionManager.KEY_TUE_SUB_7));
            tvPercentage1.setText(percentageTextView(a)+"%");
            tvPercentage2.setText(percentageTextView(b)+"%");
            tvPercentage3.setText(percentageTextView(c)+"%");
            tvPercentage4.setText(percentageTextView(d)+"%");
            tvPercentage5.setText(percentageTextView(e)+"%");
            tvPercentage6.setText(percentageTextView(f)+"%");
            tvPercentage7.setText(percentageTextView(g)+"%");
            setColorOfPercentageTextView(a,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(b,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(c,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(d,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(e,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(f,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(g,a,b,c,d,e,f,g);
            if(cnt>=1)
            {
                sub1Layout.setVisibility(View.VISIBLE);
                mainTVSub1.setText(subtue.get(SessionManager.KEY_TUE_SUB_1));
                tvAttendedClass1.setText("Attended: "+getPreviousAttendedClass[a]);
                tvTotalClass1.setText("Total: "+getPreviousTotalClass[a]);

            }
            if(cnt>=2)
            {
                sub2Layout.setVisibility(View.VISIBLE);
                mainTVSub2.setText(subtue.get(SessionManager.KEY_TUE_SUB_2));
                tvAttendedClass2.setText("Attended: "+getPreviousAttendedClass[b]);
                tvTotalClass2.setText("Total: "+getPreviousTotalClass[b]);
            }
            if(cnt>=3)
            {
                sub3Layout.setVisibility(View.VISIBLE);
                mainTVSub3.setText(subtue.get(SessionManager.KEY_TUE_SUB_3));
                tvAttendedClass3.setText("Attended: "+getPreviousAttendedClass[c]);
                tvTotalClass3.setText("Total: "+getPreviousTotalClass[c]);
            }
            if(cnt>=4)
            {
                sub4Layout.setVisibility(View.VISIBLE);
                mainTVSub4.setText(subtue.get(SessionManager.KEY_TUE_SUB_4));
                tvAttendedClass4.setText("Attended: "+getPreviousAttendedClass[d]);
                tvTotalClass4.setText("Total: "+getPreviousTotalClass[d]);
            }
            if(cnt>=5)
            {
                sub5Layout.setVisibility(View.VISIBLE);
                mainTVSub5.setText(subtue.get(SessionManager.KEY_TUE_SUB_5));
                tvAttendedClass5.setText("Attended: "+getPreviousAttendedClass[e]);
                tvTotalClass5.setText("Total: "+getPreviousTotalClass[e]);
            }
            if(cnt>=6)
            {
                sub6Layout.setVisibility(View.VISIBLE);
                mainTVSub6.setText(subtue.get(SessionManager.KEY_TUE_SUB_6));
                tvAttendedClass6.setText("Attended: "+getPreviousAttendedClass[f]);
                tvTotalClass6.setText("Total: "+getPreviousTotalClass[f]);
            }
            if(cnt>=7)
            {
                sub7Layout.setVisibility(View.VISIBLE);
                mainTVSub7.setText(subtue.get(SessionManager.KEY_TUE_SUB_7));
                tvAttendedClass7.setText("Attended: "+getPreviousAttendedClass[g]);
                tvTotalClass7.setText("Total: "+getPreviousTotalClass[g]);
            }
        }
        else if(todayDay.equals("Wednesday"))
        {
            cnt=sessionManager.getCountWed();
            int a=setPreAttendance(subwed.get(SessionManager.KEY_WED_SUB_1));
            int b=setPreAttendance(subwed.get(SessionManager.KEY_WED_SUB_2));
            int c=setPreAttendance(subwed.get(SessionManager.KEY_WED_SUB_3));
            int d=setPreAttendance(subwed.get(SessionManager.KEY_WED_SUB_4));
            int e=setPreAttendance(subwed.get(SessionManager.KEY_WED_SUB_5));
            int f=setPreAttendance(subwed.get(SessionManager.KEY_WED_SUB_6));
            int g=setPreAttendance(subwed.get(SessionManager.KEY_WED_SUB_7));
            tvPercentage1.setText(percentageTextView(a)+"%");
            tvPercentage2.setText(percentageTextView(b)+"%");
            tvPercentage3.setText(percentageTextView(c)+"%");
            tvPercentage4.setText(percentageTextView(d)+"%");
            tvPercentage5.setText(percentageTextView(e)+"%");
            tvPercentage6.setText(percentageTextView(f)+"%");
            tvPercentage7.setText(percentageTextView(g)+"%");
            setColorOfPercentageTextView(a,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(b,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(c,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(d,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(e,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(f,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(g,a,b,c,d,e,f,g);

            if(cnt>=1)
            {
                sub1Layout.setVisibility(View.VISIBLE);
                mainTVSub1.setText(subwed.get(SessionManager.KEY_WED_SUB_1));
                tvAttendedClass1.setText("Attended: "+getPreviousAttendedClass[a]);
                tvTotalClass1.setText("Total: "+getPreviousTotalClass[a]);

            }
            if(cnt>=2)
            {
                sub2Layout.setVisibility(View.VISIBLE);
                mainTVSub2.setText(subwed.get(SessionManager.KEY_WED_SUB_2));
                tvAttendedClass2.setText("Attended: "+getPreviousAttendedClass[b]);
                tvTotalClass2.setText("Total: "+getPreviousTotalClass[b]);
            }
            if(cnt>=3)
            {
                sub3Layout.setVisibility(View.VISIBLE);
                mainTVSub3.setText(subwed.get(SessionManager.KEY_WED_SUB_3));
                tvAttendedClass3.setText("Attended: "+getPreviousAttendedClass[c]);
                tvTotalClass3.setText("Total: "+getPreviousTotalClass[c]);
            }
            if(cnt>=4)
            {
                sub4Layout.setVisibility(View.VISIBLE);
                mainTVSub4.setText(subwed.get(SessionManager.KEY_WED_SUB_4));
                tvAttendedClass4.setText("Attended: "+getPreviousAttendedClass[d]);
                tvTotalClass4.setText("Total: "+getPreviousTotalClass[d]);
            }
            if(cnt>=5)
            {
                sub5Layout.setVisibility(View.VISIBLE);
                mainTVSub5.setText(subwed.get(SessionManager.KEY_WED_SUB_5));
                tvAttendedClass5.setText("Attended: "+getPreviousAttendedClass[e]);
                tvTotalClass5.setText("Total: "+getPreviousTotalClass[e]);
            }
            if(cnt>=6)
            {
                sub6Layout.setVisibility(View.VISIBLE);
                mainTVSub6.setText(subwed.get(SessionManager.KEY_WED_SUB_6));
                tvAttendedClass6.setText("Attended: "+getPreviousAttendedClass[f]);
                tvTotalClass6.setText("Total: "+getPreviousTotalClass[f]);
            }
            if(cnt>=7)
            {
                sub7Layout.setVisibility(View.VISIBLE);
                mainTVSub7.setText(subwed.get(SessionManager.KEY_WED_SUB_7));
                tvAttendedClass7.setText("Attended: "+getPreviousAttendedClass[g]);
                tvTotalClass7.setText("Total: "+getPreviousTotalClass[g]);
            }
        }
        else if(todayDay.equals("Thursday"))
        {
            cnt=sessionManager.getCountThu();
            int a=setPreAttendance(subthu.get(SessionManager.KEY_THU_SUB_1));
            int b=setPreAttendance(subthu.get(SessionManager.KEY_THU_SUB_2));
            int c=setPreAttendance(subthu.get(SessionManager.KEY_THU_SUB_3));
            int d=setPreAttendance(subthu.get(SessionManager.KEY_THU_SUB_4));
            int e=setPreAttendance(subthu.get(SessionManager.KEY_THU_SUB_5));
            int f=setPreAttendance(subthu.get(SessionManager.KEY_THU_SUB_6));
            int g=setPreAttendance(subthu.get(SessionManager.KEY_THU_SUB_7));
            tvPercentage1.setText(percentageTextView(a)+"%");
            tvPercentage2.setText(percentageTextView(b)+"%");
            tvPercentage3.setText(percentageTextView(c)+"%");
            tvPercentage4.setText(percentageTextView(d)+"%");
            tvPercentage5.setText(percentageTextView(e)+"%");
            tvPercentage6.setText(percentageTextView(f)+"%");
            tvPercentage7.setText(percentageTextView(g)+"%");
            setColorOfPercentageTextView(a,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(b,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(c,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(d,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(e,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(f,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(g,a,b,c,d,e,f,g);
            if(cnt>=1)
            {
                sub1Layout.setVisibility(View.VISIBLE);
                mainTVSub1.setText(subthu.get(SessionManager.KEY_THU_SUB_1));
                tvAttendedClass1.setText("Attended: "+getPreviousAttendedClass[a]);
                tvTotalClass1.setText("Total: "+getPreviousTotalClass[a]);

            }
            if(cnt>=2)
            {
                sub2Layout.setVisibility(View.VISIBLE);
                mainTVSub2.setText(subthu.get(SessionManager.KEY_THU_SUB_2));
                tvAttendedClass2.setText("Attended: "+getPreviousAttendedClass[b]);
                tvTotalClass2.setText("Total: "+getPreviousTotalClass[b]);
            }
            if(cnt>=3)
            {
                sub3Layout.setVisibility(View.VISIBLE);
                mainTVSub3.setText(subthu.get(SessionManager.KEY_THU_SUB_3));
                tvAttendedClass3.setText("Attended: "+getPreviousAttendedClass[c]);
                tvTotalClass3.setText("Total: "+getPreviousTotalClass[c]);
            }
            if(cnt>=4)
            {
                sub4Layout.setVisibility(View.VISIBLE);
                mainTVSub4.setText(subthu.get(SessionManager.KEY_THU_SUB_4));
                tvAttendedClass4.setText("Attended: "+getPreviousAttendedClass[d]);
                tvTotalClass4.setText("Total: "+getPreviousTotalClass[d]);
            }
            if(cnt>=5)
            {
                sub5Layout.setVisibility(View.VISIBLE);
                mainTVSub5.setText(subthu.get(SessionManager.KEY_THU_SUB_5));
                tvAttendedClass5.setText("Attended: "+getPreviousAttendedClass[e]);
                tvTotalClass5.setText("Total: "+getPreviousTotalClass[e]);
            }
            if(cnt>=6)
            {
                sub6Layout.setVisibility(View.VISIBLE);
                mainTVSub6.setText(subthu.get(SessionManager.KEY_THU_SUB_6));
                tvAttendedClass6.setText("Attended: "+getPreviousAttendedClass[f]);
                tvTotalClass6.setText("Total: "+getPreviousTotalClass[f]);
            }
            if(cnt>=7)
            {
                sub7Layout.setVisibility(View.VISIBLE);
                mainTVSub7.setText(subthu.get(SessionManager.KEY_THU_SUB_7));
                tvAttendedClass7.setText("Attended: "+getPreviousAttendedClass[g]);
                tvTotalClass7.setText("Total: "+getPreviousTotalClass[g]);
            }
        }
        else if(todayDay.equals("Friday"))
        {
            cnt=sessionManager.getCountFri();
            int a=setPreAttendance(subfri.get(SessionManager.KEY_FRI_SUB_1));
            int b=setPreAttendance(subfri.get(SessionManager.KEY_FRI_SUB_2));
            int c=setPreAttendance(subfri.get(SessionManager.KEY_FRI_SUB_3));
            int d=setPreAttendance(subfri.get(SessionManager.KEY_FRI_SUB_4));
            int e=setPreAttendance(subfri.get(SessionManager.KEY_FRI_SUB_5));
            int f=setPreAttendance(subfri.get(SessionManager.KEY_FRI_SUB_6));
            int g=setPreAttendance(subfri.get(SessionManager.KEY_FRI_SUB_7));
            tvPercentage1.setText(percentageTextView(a)+"%");
            tvPercentage2.setText(percentageTextView(b)+"%");
            tvPercentage3.setText(percentageTextView(c)+"%");
            tvPercentage4.setText(percentageTextView(d)+"%");
            tvPercentage5.setText(percentageTextView(e)+"%");
            tvPercentage6.setText(percentageTextView(f)+"%");
            tvPercentage7.setText(percentageTextView(g)+"%");
            setColorOfPercentageTextView(a,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(b,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(c,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(d,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(e,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(f,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(g,a,b,c,d,e,f,g);
            if(cnt>=1)
            {
                sub1Layout.setVisibility(View.VISIBLE);
                mainTVSub1.setText(subfri.get(SessionManager.KEY_FRI_SUB_1));
                tvAttendedClass1.setText("Attended: "+getPreviousAttendedClass[a]);
                tvTotalClass1.setText("Total: "+getPreviousTotalClass[a]);

            }
            if(cnt>=2)
            {
                sub2Layout.setVisibility(View.VISIBLE);
                mainTVSub2.setText(subfri.get(SessionManager.KEY_FRI_SUB_2));
                tvAttendedClass2.setText("Attended: "+getPreviousAttendedClass[b]);
                tvTotalClass2.setText("Total: "+getPreviousTotalClass[b]);
            }
            if(cnt>=3)
            {
                sub3Layout.setVisibility(View.VISIBLE);
                mainTVSub3.setText(subfri.get(SessionManager.KEY_FRI_SUB_3));
                tvAttendedClass3.setText("Attended: "+getPreviousAttendedClass[c]);
                tvTotalClass3.setText("Total: "+getPreviousTotalClass[c]);
            }
            if(cnt>=4)
            {
                sub4Layout.setVisibility(View.VISIBLE);
                mainTVSub4.setText(subfri.get(SessionManager.KEY_FRI_SUB_4));
                tvAttendedClass4.setText("Attended: "+getPreviousAttendedClass[d]);
                tvTotalClass4.setText("Total: "+getPreviousTotalClass[d]);
            }
            if(cnt>=5)
            {
                sub5Layout.setVisibility(View.VISIBLE);
                mainTVSub5.setText(subfri.get(SessionManager.KEY_FRI_SUB_5));
                tvAttendedClass5.setText("Attended: "+getPreviousAttendedClass[e]);
                tvTotalClass5.setText("Total: "+getPreviousTotalClass[e]);
            }
            if(cnt>=6)
            {
                sub6Layout.setVisibility(View.VISIBLE);
                mainTVSub6.setText(subfri.get(SessionManager.KEY_FRI_SUB_6));
                tvAttendedClass6.setText("Attended: "+getPreviousAttendedClass[f]);
                tvTotalClass6.setText("Total: "+getPreviousTotalClass[f]);
            }
            if(cnt>=7)
            {
                sub7Layout.setVisibility(View.VISIBLE);
                mainTVSub7.setText(subfri.get(SessionManager.KEY_FRI_SUB_7));
                tvAttendedClass7.setText("Attended: "+getPreviousAttendedClass[g]);
                tvTotalClass7.setText("Total: "+getPreviousTotalClass[g]);
            }
        }
        else if(todayDay.equals("Saturday"))
        {
            cnt=sessionManager.getCountSat();
            int a=setPreAttendance(subsat.get(SessionManager.KEY_SAT_SUB_1));
            int b=setPreAttendance(subsat.get(SessionManager.KEY_SAT_SUB_2));
            int c=setPreAttendance(subsat.get(SessionManager.KEY_SAT_SUB_3));
            int d=setPreAttendance(subsat.get(SessionManager.KEY_SAT_SUB_4));
            int e=setPreAttendance(subsat.get(SessionManager.KEY_SAT_SUB_5));
            int f=setPreAttendance(subsat.get(SessionManager.KEY_SAT_SUB_6));
            int g=setPreAttendance(subsat.get(SessionManager.KEY_SAT_SUB_7));
            tvPercentage1.setText(percentageTextView(a)+"%");
            tvPercentage2.setText(percentageTextView(b)+"%");
            tvPercentage3.setText(percentageTextView(c)+"%");
            tvPercentage4.setText(percentageTextView(d)+"%");
            tvPercentage5.setText(percentageTextView(e)+"%");
            tvPercentage6.setText(percentageTextView(f)+"%");
            tvPercentage7.setText(percentageTextView(g)+"%");
            setColorOfPercentageTextView(a,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(b,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(c,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(d,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(e,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(f,a,b,c,d,e,f,g);
            setColorOfPercentageTextView(g,a,b,c,d,e,f,g);
            if(cnt==0)
            {
                sub1Layout.setVisibility(View.GONE);
                offLayout.setVisibility(View.VISIBLE);
            }
            if(cnt>=1)
            {
                sub1Layout.setVisibility(View.VISIBLE);
                mainTVSub1.setText(subsat.get(SessionManager.KEY_SAT_SUB_1));
                tvAttendedClass1.setText("Attended: "+getPreviousAttendedClass[a]);
                tvTotalClass1.setText("Total: "+getPreviousTotalClass[a]);

            }
            if(cnt>=2)
            {
                sub2Layout.setVisibility(View.VISIBLE);
                mainTVSub2.setText(subsat.get(SessionManager.KEY_SAT_SUB_2));
                tvAttendedClass2.setText("Attended: "+getPreviousAttendedClass[b]);
                tvTotalClass2.setText("Total: "+getPreviousTotalClass[b]);
            }
            if(cnt>=3)
            {
                sub3Layout.setVisibility(View.VISIBLE);
                mainTVSub3.setText(subsat.get(SessionManager.KEY_SAT_SUB_3));
                tvAttendedClass3.setText("Attended: "+getPreviousAttendedClass[c]);
                tvTotalClass3.setText("Total: "+getPreviousTotalClass[c]);
            }
            if(cnt>=4)
            {
                sub4Layout.setVisibility(View.VISIBLE);
                mainTVSub4.setText(subsat.get(SessionManager.KEY_SAT_SUB_4));
                tvAttendedClass4.setText("Attended: "+getPreviousAttendedClass[d]);
                tvTotalClass4.setText("Total: "+getPreviousTotalClass[d]);
            }
            if(cnt>=5)
            {
                sub5Layout.setVisibility(View.VISIBLE);
                mainTVSub5.setText(subsat.get(SessionManager.KEY_SAT_SUB_5));
                tvAttendedClass5.setText("Attended: "+getPreviousAttendedClass[e]);
                tvTotalClass5.setText("Total: "+getPreviousTotalClass[e]);
            }
            if(cnt>=6)
            {
                sub6Layout.setVisibility(View.VISIBLE);
                mainTVSub6.setText(subsat.get(SessionManager.KEY_SAT_SUB_6));
                tvAttendedClass6.setText("Attended: "+getPreviousAttendedClass[f]);
                tvTotalClass6.setText("Total: "+getPreviousTotalClass[f]);
            }
            if(cnt>=7)
            {
                sub7Layout.setVisibility(View.VISIBLE);
                mainTVSub7.setText(subsat.get(SessionManager.KEY_SAT_SUB_7));
                tvAttendedClass7.setText("Attended: "+getPreviousAttendedClass[g]);
                tvTotalClass7.setText("Total: "+getPreviousTotalClass[g]);
            }
        }
    }
    public int setPreAttendance(String period)
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
    public int matchForSubjectWiseMarking(int i)
    {
        //used in all the three marking buttons of a particular subject to mark attendance.
        int a=0;
        HashMap<String ,String> today=sessionManager.getDay();
        String todayDay=today.get("day");
        if(todayDay.equals("Monday"))
        {
            //a=setPreAttendance(mondaySubjects[i]);
            if(i==0)
                a=setPreAttendance(subj.get(SessionManager.KEY_MON_SUB_1));
            else if(i==1)
                a=setPreAttendance(subj.get(SessionManager.KEY_MON_SUB_2));
            else if(i==2)
                a=setPreAttendance(subj.get(SessionManager.KEY_MON_SUB_3));
            else if(i==3)
                a=setPreAttendance(subj.get(SessionManager.KEY_MON_SUB_4));
            else if(i==4)
                a=setPreAttendance(subj.get(SessionManager.KEY_MON_SUB_5));
            else if(i==5)
                a=setPreAttendance(subj.get(SessionManager.KEY_MON_SUB_6));
            else if(i==6)
                a=setPreAttendance(subj.get(SessionManager.KEY_MON_SUB_7));
            return a;
        }
        else if(todayDay.equals("Tuesday"))
        {
            //a=setPreAttendance(tuesdaySubjects[i]);
            if(i==0)
                a=setPreAttendance(subtue.get(SessionManager.KEY_TUE_SUB_1));
            else if(i==1)
                a=setPreAttendance(subtue.get(SessionManager.KEY_TUE_SUB_2));
            else if(i==2)
                a=setPreAttendance(subtue.get(SessionManager.KEY_TUE_SUB_3));
            else if(i==3)
                a=setPreAttendance(subtue.get(SessionManager.KEY_TUE_SUB_4));
            else if(i==4)
                a=setPreAttendance(subtue.get(SessionManager.KEY_TUE_SUB_5));
            else if(i==5)
                a=setPreAttendance(subtue.get(SessionManager.KEY_TUE_SUB_6));
            else if(i==6)
                a=setPreAttendance(subtue.get(SessionManager.KEY_TUE_SUB_7));
            return a;
        }
        else if(todayDay.equals("Wednesday"))
        {
            //a=setPreAttendance(wednesdaySubjects[i]);
            if(i==0)
                a=setPreAttendance(subwed.get(SessionManager.KEY_WED_SUB_1));
            else if(i==1)
                a=setPreAttendance(subwed.get(SessionManager.KEY_WED_SUB_2));
            else if(i==2)
                a=setPreAttendance(subwed.get(SessionManager.KEY_WED_SUB_3));
            else if(i==3)
                a=setPreAttendance(subwed.get(SessionManager.KEY_WED_SUB_4));
            else if(i==4)
                a=setPreAttendance(subwed.get(SessionManager.KEY_WED_SUB_5));
            else if(i==5)
                a=setPreAttendance(subwed.get(SessionManager.KEY_WED_SUB_6));
            else if(i==6)
                a=setPreAttendance(subwed.get(SessionManager.KEY_WED_SUB_7));
            return a;
        }
        else if(todayDay.equals("Thursday"))
        {
            //a=setPreAttendance(thursdaySubjects[i]);
            if(i==0)
                a=setPreAttendance(subthu.get(SessionManager.KEY_THU_SUB_1));
            else if(i==1)
                a=setPreAttendance(subthu.get(SessionManager.KEY_THU_SUB_2));
            else if(i==2)
                a=setPreAttendance(subthu.get(SessionManager.KEY_THU_SUB_3));
            else if(i==3)
                a=setPreAttendance(subthu.get(SessionManager.KEY_THU_SUB_4));
            else if(i==4)
                a=setPreAttendance(subthu.get(SessionManager.KEY_THU_SUB_5));
            else if(i==5)
                a=setPreAttendance(subthu.get(SessionManager.KEY_THU_SUB_6));
            else if(i==6)
                a=setPreAttendance(subthu.get(SessionManager.KEY_THU_SUB_7));
            return a;
        }
        else if(todayDay.equals("Friday"))
        {
            //a=setPreAttendance(fridaySubjects[i]);
            if(i==0)
                a=setPreAttendance(subfri.get(SessionManager.KEY_FRI_SUB_1));
            else if(i==1)
                a=setPreAttendance(subfri.get(SessionManager.KEY_FRI_SUB_2));
            else if(i==2)
                a=setPreAttendance(subfri.get(SessionManager.KEY_FRI_SUB_3));
            else if(i==3)
                a=setPreAttendance(subfri.get(SessionManager.KEY_FRI_SUB_4));
            else if(i==4)
                a=setPreAttendance(subfri.get(SessionManager.KEY_FRI_SUB_5));
            else if(i==5)
                a=setPreAttendance(subfri.get(SessionManager.KEY_FRI_SUB_6));
            else if(i==6)
                a=setPreAttendance(subfri.get(SessionManager.KEY_FRI_SUB_7));
            return a;
        }
        else if(todayDay.equals("Saturday"))
        {
            //a=setPreAttendance(saturdaySubjects[i]);
            if(i==0)
                a=setPreAttendance(subsat.get(SessionManager.KEY_SAT_SUB_1));
            else if(i==1)
                a=setPreAttendance(subsat.get(SessionManager.KEY_SAT_SUB_2));
            else if(i==2)
                a=setPreAttendance(subsat.get(SessionManager.KEY_SAT_SUB_3));
            else if(i==3)
                a=setPreAttendance(subsat.get(SessionManager.KEY_SAT_SUB_4));
            else if(i==4)
                a=setPreAttendance(subsat.get(SessionManager.KEY_SAT_SUB_5));
            else if(i==5)
                a=setPreAttendance(subsat.get(SessionManager.KEY_SAT_SUB_6));
            else if(i==6)
                a=setPreAttendance(subsat.get(SessionManager.KEY_SAT_SUB_7));
            return a;
        }
        return a;
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
    public void setColorOfPercentageTextView(int zz,int a,int b,int c,int d,int e,int f,int g)
    {
        HashMap<String ,String> str=sessionManager.getUserDetails();
        String att=str.get(SessionManager.KEY_ATTENDANCE);
        float attend=Float.parseFloat(att);
        float x=0.0f;
        float x1,x2,x3,tempx,tempx1,tempx2;
        x1=getPreviousAttendedClass[zz];
        x2=getPreviousTotalClass[zz];
        x3=100;
        x=(x1/x2)*x3;
        if(zz==a)
        {
            if(x<attend)
            {
                tvPercentage1.setTextColor(Color.parseColor("#B22222"));//red
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
                            tvOnTrack1.setText("!!! Attend next class !!!");
                        else
                            tvOnTrack1.setText("!!! Attend next "+cnt+" classes !!!");
                        break;
                    }

                }
            }
            else
            {
                tvPercentage1.setTextColor(Color.parseColor("#008000"));//green
                tvOnTrack1.setText("!!! You are on track !!!");
            }
        }
        else if(zz==b)
        {
            if(x<attend)
            {
                tvPercentage2.setTextColor(Color.parseColor("#B22222"));//red
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
                            tvOnTrack2.setText("!!! Attend next class !!!");
                        else
                            tvOnTrack2.setText("!!! Attend next "+cnt+" classes !!!");
                        break;
                    }

                }
            }
            else
            {
                tvPercentage2.setTextColor(Color.parseColor("#008000"));//green
                tvOnTrack2.setText("!!! You are on track !!!");
            }
        }
        else if(zz==c)
        {
            if(x<attend)
            {
                tvPercentage3.setTextColor(Color.parseColor("#B22222"));//red
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
                            tvOnTrack3.setText("!!! Attend next class !!!");
                        else
                            tvOnTrack3.setText("!!! Attend next "+cnt+" classes !!!");
                        break;
                    }

                }
            }
            else
            {
                tvPercentage3.setTextColor(Color.parseColor("#008000"));//green
                tvOnTrack3.setText("!!! You are on track !!!");
            }
        }
        else if(zz==d)
        {
            if(x<attend)
            {
                tvPercentage4.setTextColor(Color.parseColor("#B22222"));//red
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
                            tvOnTrack4.setText("!!! Attend next class !!!");
                        else
                            tvOnTrack4.setText("!!! Attend next "+cnt+" classes !!!");
                        break;
                    }

                }
            }
            else
            {
                tvPercentage4.setTextColor(Color.parseColor("#008000"));//green
                tvOnTrack4.setText("!!! You are on track !!!");
            }
        }
        else if(zz==e)
        {
            if(x<attend)
            {
                tvPercentage5.setTextColor(Color.parseColor("#B22222"));//red
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
                            tvOnTrack5.setText("!!! Attend next class !!!");
                        else
                            tvOnTrack5.setText("!!! Attend next "+cnt+" classes !!!");
                        break;
                    }

                }
            }
            else
            {
                tvPercentage5.setTextColor(Color.parseColor("#008000"));//green
                tvOnTrack5.setText("!!! You are on track !!!");
            }
        }
        else if(zz==f)
        {
            if(x<attend)
            {
                tvPercentage6.setTextColor(Color.parseColor("#B22222"));//red
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
                            tvOnTrack6.setText("!!! Attend next class !!!");
                        else
                            tvOnTrack6.setText("!!! Attend next "+cnt+" classes !!!");
                        break;
                    }

                }
            }
            else
            {
                tvPercentage6.setTextColor(Color.parseColor("#008000"));//green
                tvOnTrack6.setText("!!! You are on track !!!");
            }
        }
        else if(zz==g)
        {
            if(x<attend)
            {
                tvPercentage7.setTextColor(Color.parseColor("#B22222"));//red
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
                            tvOnTrack7.setText("!!! Attend next class !!!");
                        else
                            tvOnTrack7.setText("!!! Attend next "+cnt+" classes !!!");
                        break;
                    }

                }
            }
            else
            {
                tvPercentage7.setTextColor(Color.parseColor("#008000"));//green
                tvOnTrack7.setText("!!! You are on track !!!");
            }
        }
    }
    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        HashMap<String ,String> today=sessionManager.getDay();
        String todayDay=today.get("day_date");
        getActivity().setTitle(todayDay);
    }
}
