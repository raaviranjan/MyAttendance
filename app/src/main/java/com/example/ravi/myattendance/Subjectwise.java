package com.example.ravi.myattendance;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by Ravi on 17-Nov-17.
 */

public class Subjectwise extends Fragment {
    LinearLayout LayoutSubjectWise1,LayoutSubjectWise2,LayoutSubjectWise3,LayoutSubjectWise4,LayoutSubjectWise5,LayoutSubjectWise6,
            LayoutSubjectWise7,LayoutSubjectWise8,LayoutSubjectWise9,LayoutSubjectWise10,LayoutSubjectWise11,LayoutSubjectWise12,
            LayoutSubjectWise13,LayoutSubjectWise14,LayoutSubjectWise15,LayoutSubjectWise16,LayoutSubjectWise17,LayoutSubjectWise18,
            LayoutSubjectWise19,LayoutSubjectWise20;
    TextView SubjectWiseTVSub1,SubjectWiseTVSub2,SubjectWiseTVSub3,SubjectWiseTVSub4,SubjectWiseTVSub5,SubjectWiseTVSub6,SubjectWiseTVSub7,
            SubjectWiseTVSub8,SubjectWiseTVSub9,SubjectWiseTVSub10,SubjectWiseTVSub11,SubjectWiseTVSub12,SubjectWiseTVSub13,
            SubjectWiseTVSub14,SubjectWiseTVSub15,SubjectWiseTVSub16,SubjectWiseTVSub17,SubjectWiseTVSub18,SubjectWiseTVSub19,
            SubjectWiseTVSub20,
            SubjectWisetvAttendedClass1,SubjectWisetvAttendedClass2,SubjectWisetvAttendedClass3,SubjectWisetvAttendedClass4,
            SubjectWisetvAttendedClass5,SubjectWisetvAttendedClass6,SubjectWisetvAttendedClass7,SubjectWisetvAttendedClass8,
            SubjectWisetvAttendedClass9,SubjectWisetvAttendedClass10,SubjectWisetvAttendedClass11,SubjectWisetvAttendedClass12,
            SubjectWisetvAttendedClass13,SubjectWisetvAttendedClass14,SubjectWisetvAttendedClass15,SubjectWisetvAttendedClass16,
            SubjectWisetvAttendedClass17,SubjectWisetvAttendedClass18,SubjectWisetvAttendedClass19,SubjectWisetvAttendedClass20,
            SubjectWisetvTotalClass1,SubjectWisetvTotalClass2,SubjectWisetvTotalClass3,SubjectWisetvTotalClass4,SubjectWisetvTotalClass5,
            SubjectWisetvTotalClass6,SubjectWisetvTotalClass7,SubjectWisetvTotalClass8,SubjectWisetvTotalClass9,SubjectWisetvTotalClass10,
            SubjectWisetvTotalClass11,SubjectWisetvTotalClass12,SubjectWisetvTotalClass13,SubjectWisetvTotalClass14,SubjectWisetvTotalClass15,
            SubjectWisetvTotalClass16,SubjectWisetvTotalClass17,SubjectWisetvTotalClass18,SubjectWisetvTotalClass19,SubjectWisetvTotalClass20,
            SubjectWisetvPercentage1,SubjectWisetvPercentage2,SubjectWisetvPercentage3,SubjectWisetvPercentage4,SubjectWisetvPercentage5,
            SubjectWisetvPercentage6,SubjectWisetvPercentage7,SubjectWisetvPercentage8,SubjectWisetvPercentage9,SubjectWisetvPercentage10,
            SubjectWisetvPercentage11,SubjectWisetvPercentage12,SubjectWisetvPercentage13,SubjectWisetvPercentage14,SubjectWisetvPercentage15,
            SubjectWisetvPercentage16,SubjectWisetvPercentage17,SubjectWisetvPercentage18,SubjectWisetvPercentage19,SubjectWisetvPercentage20,
            SubjectWisetvOnTrack1,SubjectWisetvOnTrack2,SubjectWisetvOnTrack3,SubjectWisetvOnTrack4,SubjectWisetvOnTrack5,SubjectWisetvOnTrack6,
            SubjectWisetvOnTrack7,SubjectWisetvOnTrack8,SubjectWisetvOnTrack9,SubjectWisetvOnTrack10,SubjectWisetvOnTrack11,SubjectWisetvOnTrack12,
            SubjectWisetvOnTrack13,SubjectWisetvOnTrack14,SubjectWisetvOnTrack15,SubjectWisetvOnTrack16,SubjectWisetvOnTrack17,SubjectWisetvOnTrack18,
            SubjectWisetvOnTrack19,SubjectWisetvOnTrack20,
            subjectWiseTVNotEntered;
    SessionManager sessionManager;
    String[] totalSubjects;
    Integer[] getPreviousAttendedClass;
    Integer[] getPreviousTotalClass;
    int sizeof;
    String att;
    float attend;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.subjectwise, viewGroup, false);

        LayoutSubjectWise1=(LinearLayout)view.findViewById(R.id.LayoutSubjectWise1);
        LayoutSubjectWise2=(LinearLayout)view.findViewById(R.id.LayoutSubjectWise2);
        LayoutSubjectWise3=(LinearLayout)view.findViewById(R.id.LayoutSubjectWise3);
        LayoutSubjectWise4=(LinearLayout)view.findViewById(R.id.LayoutSubjectWise4);
        LayoutSubjectWise5=(LinearLayout)view.findViewById(R.id.LayoutSubjectWise5);
        LayoutSubjectWise6=(LinearLayout)view.findViewById(R.id.LayoutSubjectWise6);
        LayoutSubjectWise7=(LinearLayout)view.findViewById(R.id.LayoutSubjectWise7);
        LayoutSubjectWise8=(LinearLayout)view.findViewById(R.id.LayoutSubjectWise8);
        LayoutSubjectWise9=(LinearLayout)view.findViewById(R.id.LayoutSubjectWise9);
        LayoutSubjectWise10=(LinearLayout)view.findViewById(R.id.LayoutSubjectWise10);
        LayoutSubjectWise11=(LinearLayout)view.findViewById(R.id.LayoutSubjectWise11);
        LayoutSubjectWise12=(LinearLayout)view.findViewById(R.id.LayoutSubjectWise12);
        LayoutSubjectWise13=(LinearLayout)view.findViewById(R.id.LayoutSubjectWise13);
        LayoutSubjectWise14=(LinearLayout)view.findViewById(R.id.LayoutSubjectWise14);
        LayoutSubjectWise15=(LinearLayout)view.findViewById(R.id.LayoutSubjectWise15);
        LayoutSubjectWise16=(LinearLayout)view.findViewById(R.id.LayoutSubjectWise16);
        LayoutSubjectWise17=(LinearLayout)view.findViewById(R.id.LayoutSubjectWise17);
        LayoutSubjectWise18=(LinearLayout)view.findViewById(R.id.LayoutSubjectWise18);
        LayoutSubjectWise19=(LinearLayout)view.findViewById(R.id.LayoutSubjectWise19);
        LayoutSubjectWise20=(LinearLayout)view.findViewById(R.id.LayoutSubjectWise20);

        SubjectWiseTVSub1=(TextView)view.findViewById(R.id.SubjectWiseTVSub1);
        SubjectWiseTVSub2=(TextView)view.findViewById(R.id.SubjectWiseTVSub2);
        SubjectWiseTVSub3=(TextView)view.findViewById(R.id.SubjectWiseTVSub3);
        SubjectWiseTVSub4=(TextView)view.findViewById(R.id.SubjectWiseTVSub4);
        SubjectWiseTVSub5=(TextView)view.findViewById(R.id.SubjectWiseTVSub5);
        SubjectWiseTVSub6=(TextView)view.findViewById(R.id.SubjectWiseTVSub6);
        SubjectWiseTVSub7=(TextView)view.findViewById(R.id.SubjectWiseTVSub7);
        SubjectWiseTVSub8=(TextView)view.findViewById(R.id.SubjectWiseTVSub8);
        SubjectWiseTVSub9=(TextView)view.findViewById(R.id.SubjectWiseTVSub9);
        SubjectWiseTVSub10=(TextView)view.findViewById(R.id.SubjectWiseTVSub10);
        SubjectWiseTVSub11=(TextView)view.findViewById(R.id.SubjectWiseTVSub11);
        SubjectWiseTVSub12=(TextView)view.findViewById(R.id.SubjectWiseTVSub12);
        SubjectWiseTVSub13=(TextView)view.findViewById(R.id.SubjectWiseTVSub13);
        SubjectWiseTVSub14=(TextView)view.findViewById(R.id.SubjectWiseTVSub14);
        SubjectWiseTVSub15=(TextView)view.findViewById(R.id.SubjectWiseTVSub15);
        SubjectWiseTVSub16=(TextView)view.findViewById(R.id.SubjectWiseTVSub16);
        SubjectWiseTVSub17=(TextView)view.findViewById(R.id.SubjectWiseTVSub17);
        SubjectWiseTVSub18=(TextView)view.findViewById(R.id.SubjectWiseTVSub18);
        SubjectWiseTVSub19=(TextView)view.findViewById(R.id.SubjectWiseTVSub19);
        SubjectWiseTVSub20=(TextView)view.findViewById(R.id.SubjectWiseTVSub20);

        SubjectWisetvAttendedClass1=(TextView)view.findViewById(R.id.SubjectWisetvAttendedClass1);
        SubjectWisetvAttendedClass2=(TextView)view.findViewById(R.id.SubjectWisetvAttendedClass2);
        SubjectWisetvAttendedClass3=(TextView)view.findViewById(R.id.SubjectWisetvAttendedClass3);
        SubjectWisetvAttendedClass4=(TextView)view.findViewById(R.id.SubjectWisetvAttendedClass4);
        SubjectWisetvAttendedClass5=(TextView)view.findViewById(R.id.SubjectWisetvAttendedClass5);
        SubjectWisetvAttendedClass6=(TextView)view.findViewById(R.id.SubjectWisetvAttendedClass6);
        SubjectWisetvAttendedClass7=(TextView)view.findViewById(R.id.SubjectWisetvAttendedClass7);
        SubjectWisetvAttendedClass8=(TextView)view.findViewById(R.id.SubjectWisetvAttendedClass8);
        SubjectWisetvAttendedClass9=(TextView)view.findViewById(R.id.SubjectWisetvAttendedClass9);
        SubjectWisetvAttendedClass10=(TextView)view.findViewById(R.id.SubjectWisetvAttendedClass10);
        SubjectWisetvAttendedClass11=(TextView)view.findViewById(R.id.SubjectWisetvAttendedClass11);
        SubjectWisetvAttendedClass12=(TextView)view.findViewById(R.id.SubjectWisetvAttendedClass12);
        SubjectWisetvAttendedClass13=(TextView)view.findViewById(R.id.SubjectWisetvAttendedClass13);
        SubjectWisetvAttendedClass14=(TextView)view.findViewById(R.id.SubjectWisetvAttendedClass14);
        SubjectWisetvAttendedClass15=(TextView)view.findViewById(R.id.SubjectWisetvAttendedClass15);
        SubjectWisetvAttendedClass16=(TextView)view.findViewById(R.id.SubjectWisetvAttendedClass16);
        SubjectWisetvAttendedClass17=(TextView)view.findViewById(R.id.SubjectWisetvAttendedClass17);
        SubjectWisetvAttendedClass18=(TextView)view.findViewById(R.id.SubjectWisetvAttendedClass18);
        SubjectWisetvAttendedClass19=(TextView)view.findViewById(R.id.SubjectWisetvAttendedClass19);
        SubjectWisetvAttendedClass20=(TextView)view.findViewById(R.id.SubjectWisetvAttendedClass20);

        SubjectWisetvTotalClass1=(TextView)view.findViewById(R.id.SubjectWisetvTotalClass1);
        SubjectWisetvTotalClass2=(TextView)view.findViewById(R.id.SubjectWisetvTotalClass2);
        SubjectWisetvTotalClass3=(TextView)view.findViewById(R.id.SubjectWisetvTotalClass3);
        SubjectWisetvTotalClass4=(TextView)view.findViewById(R.id.SubjectWisetvTotalClass4);
        SubjectWisetvTotalClass5=(TextView)view.findViewById(R.id.SubjectWisetvTotalClass5);
        SubjectWisetvTotalClass6=(TextView)view.findViewById(R.id.SubjectWisetvTotalClass6);
        SubjectWisetvTotalClass7=(TextView)view.findViewById(R.id.SubjectWisetvTotalClass7);
        SubjectWisetvTotalClass8=(TextView)view.findViewById(R.id.SubjectWisetvTotalClass8);
        SubjectWisetvTotalClass9=(TextView)view.findViewById(R.id.SubjectWisetvTotalClass9);
        SubjectWisetvTotalClass10=(TextView)view.findViewById(R.id.SubjectWisetvTotalClass10);
        SubjectWisetvTotalClass11=(TextView)view.findViewById(R.id.SubjectWisetvTotalClass11);
        SubjectWisetvTotalClass12=(TextView)view.findViewById(R.id.SubjectWisetvTotalClass12);
        SubjectWisetvTotalClass13=(TextView)view.findViewById(R.id.SubjectWisetvTotalClass13);
        SubjectWisetvTotalClass14=(TextView)view.findViewById(R.id.SubjectWisetvTotalClass14);
        SubjectWisetvTotalClass15=(TextView)view.findViewById(R.id.SubjectWisetvTotalClass15);
        SubjectWisetvTotalClass16=(TextView)view.findViewById(R.id.SubjectWisetvTotalClass16);
        SubjectWisetvTotalClass17=(TextView)view.findViewById(R.id.SubjectWisetvTotalClass17);
        SubjectWisetvTotalClass18=(TextView)view.findViewById(R.id.SubjectWisetvTotalClass18);
        SubjectWisetvTotalClass19=(TextView)view.findViewById(R.id.SubjectWisetvTotalClass19);
        SubjectWisetvTotalClass20=(TextView)view.findViewById(R.id.SubjectWisetvTotalClass20);

        SubjectWisetvPercentage1=(TextView)view.findViewById(R.id.SubjectWisetvPercentage1);
        SubjectWisetvPercentage2=(TextView)view.findViewById(R.id.SubjectWisetvPercentage2);
        SubjectWisetvPercentage3=(TextView)view.findViewById(R.id.SubjectWisetvPercentage3);
        SubjectWisetvPercentage4=(TextView)view.findViewById(R.id.SubjectWisetvPercentage4);
        SubjectWisetvPercentage5=(TextView)view.findViewById(R.id.SubjectWisetvPercentage5);
        SubjectWisetvPercentage6=(TextView)view.findViewById(R.id.SubjectWisetvPercentage6);
        SubjectWisetvPercentage7=(TextView)view.findViewById(R.id.SubjectWisetvPercentage7);
        SubjectWisetvPercentage8=(TextView)view.findViewById(R.id.SubjectWisetvPercentage8);
        SubjectWisetvPercentage9=(TextView)view.findViewById(R.id.SubjectWisetvPercentage9);
        SubjectWisetvPercentage10=(TextView)view.findViewById(R.id.SubjectWisetvPercentage10);
        SubjectWisetvPercentage11=(TextView)view.findViewById(R.id.SubjectWisetvPercentage11);
        SubjectWisetvPercentage12=(TextView)view.findViewById(R.id.SubjectWisetvPercentage12);
        SubjectWisetvPercentage13=(TextView)view.findViewById(R.id.SubjectWisetvPercentage13);
        SubjectWisetvPercentage14=(TextView)view.findViewById(R.id.SubjectWisetvPercentage14);
        SubjectWisetvPercentage15=(TextView)view.findViewById(R.id.SubjectWisetvPercentage15);
        SubjectWisetvPercentage16=(TextView)view.findViewById(R.id.SubjectWisetvPercentage16);
        SubjectWisetvPercentage17=(TextView)view.findViewById(R.id.SubjectWisetvPercentage17);
        SubjectWisetvPercentage18=(TextView)view.findViewById(R.id.SubjectWisetvPercentage18);
        SubjectWisetvPercentage19=(TextView)view.findViewById(R.id.SubjectWisetvPercentage19);
        SubjectWisetvPercentage20=(TextView)view.findViewById(R.id.SubjectWisetvPercentage20);

        SubjectWisetvOnTrack1=(TextView)view.findViewById(R.id.SubjectWisetvOnTrack1);
        SubjectWisetvOnTrack2=(TextView)view.findViewById(R.id.SubjectWisetvOnTrack2);
        SubjectWisetvOnTrack3=(TextView)view.findViewById(R.id.SubjectWisetvOnTrack3);
        SubjectWisetvOnTrack4=(TextView)view.findViewById(R.id.SubjectWisetvOnTrack4);
        SubjectWisetvOnTrack5=(TextView)view.findViewById(R.id.SubjectWisetvOnTrack5);
        SubjectWisetvOnTrack6=(TextView)view.findViewById(R.id.SubjectWisetvOnTrack6);
        SubjectWisetvOnTrack7=(TextView)view.findViewById(R.id.SubjectWisetvOnTrack7);
        SubjectWisetvOnTrack8=(TextView)view.findViewById(R.id.SubjectWisetvOnTrack8);
        SubjectWisetvOnTrack9=(TextView)view.findViewById(R.id.SubjectWisetvOnTrack9);
        SubjectWisetvOnTrack10=(TextView)view.findViewById(R.id.SubjectWisetvOnTrack10);
        SubjectWisetvOnTrack11=(TextView)view.findViewById(R.id.SubjectWisetvOnTrack11);
        SubjectWisetvOnTrack12=(TextView)view.findViewById(R.id.SubjectWisetvOnTrack12);
        SubjectWisetvOnTrack13=(TextView)view.findViewById(R.id.SubjectWisetvOnTrack13);
        SubjectWisetvOnTrack14=(TextView)view.findViewById(R.id.SubjectWisetvOnTrack14);
        SubjectWisetvOnTrack15=(TextView)view.findViewById(R.id.SubjectWisetvOnTrack15);
        SubjectWisetvOnTrack16=(TextView)view.findViewById(R.id.SubjectWisetvOnTrack16);
        SubjectWisetvOnTrack17=(TextView)view.findViewById(R.id.SubjectWisetvOnTrack17);
        SubjectWisetvOnTrack18=(TextView)view.findViewById(R.id.SubjectWisetvOnTrack18);
        SubjectWisetvOnTrack19=(TextView)view.findViewById(R.id.SubjectWisetvOnTrack19);
        SubjectWisetvOnTrack20=(TextView)view.findViewById(R.id.SubjectWisetvOnTrack20);

        subjectWiseTVNotEntered=(TextView)view.findViewById(R.id.subjectWiseTVNotEntered);



        sessionManager=new SessionManager(getActivity());
        totalSubjects=sessionManager.loadArray("mySubject");
        getPreviousAttendedClass=sessionManager.getAttended("classAttended");
        getPreviousTotalClass=sessionManager.getTotal("classTotal");
        sizeof=sessionManager.getSize();

        HashMap<String ,String> str=sessionManager.getUserDetails();
        att=str.get(SessionManager.KEY_ATTENDANCE);
        attend=Float.parseFloat(att);

        if(sizeof>0)
        {
            if(sizeof>=1)
            {
                LayoutSubjectWise1.setVisibility(View.VISIBLE);
                SubjectWiseTVSub1.setText(totalSubjects[0]);
                SubjectWisetvAttendedClass1.setText("Attended: "+getPreviousAttendedClass[0]);
                SubjectWisetvTotalClass1.setText("Total: "+getPreviousTotalClass[0]);
            }
            if(sizeof>=2)
            {
                LayoutSubjectWise2.setVisibility(View.VISIBLE);
                SubjectWiseTVSub2.setText(totalSubjects[1]);
                SubjectWisetvAttendedClass2.setText("Attended: "+getPreviousAttendedClass[1]);
                SubjectWisetvTotalClass2.setText("Total: "+getPreviousTotalClass[1]);
            }
            if(sizeof>=3)
            {
                LayoutSubjectWise3.setVisibility(View.VISIBLE);
                SubjectWiseTVSub3.setText(totalSubjects[2]);
                SubjectWisetvAttendedClass3.setText("Attended: "+getPreviousAttendedClass[2]);
                SubjectWisetvTotalClass3.setText("Total: "+getPreviousTotalClass[2]);
            }
            if(sizeof>=4)
            {
                LayoutSubjectWise4.setVisibility(View.VISIBLE);
                SubjectWiseTVSub4.setText(totalSubjects[3]);
                SubjectWisetvAttendedClass4.setText("Attended: "+getPreviousAttendedClass[3]);
                SubjectWisetvTotalClass4.setText("Total: "+getPreviousTotalClass[3]);
            }
            if(sizeof>=5)
            {
                LayoutSubjectWise5.setVisibility(View.VISIBLE);
                SubjectWiseTVSub5.setText(totalSubjects[4]);
                SubjectWisetvAttendedClass5.setText("Attended: "+getPreviousAttendedClass[4]);
                SubjectWisetvTotalClass5.setText("Total: "+getPreviousTotalClass[4]);
            }
            if(sizeof>=6)
            {
                LayoutSubjectWise6.setVisibility(View.VISIBLE);
                SubjectWiseTVSub6.setText(totalSubjects[5]);
                SubjectWisetvAttendedClass6.setText("Attended: "+getPreviousAttendedClass[5]);
                SubjectWisetvTotalClass6.setText("Total: "+getPreviousTotalClass[5]);
            }
            if(sizeof>=7)
            {
                LayoutSubjectWise7.setVisibility(View.VISIBLE);
                SubjectWiseTVSub7.setText(totalSubjects[6]);
                SubjectWisetvAttendedClass7.setText("Attended: "+getPreviousAttendedClass[6]);
                SubjectWisetvTotalClass7.setText("Total: "+getPreviousTotalClass[6]);
            }
            if(sizeof>=8)
            {
                LayoutSubjectWise8.setVisibility(View.VISIBLE);
                SubjectWiseTVSub8.setText(totalSubjects[7]);
                SubjectWisetvAttendedClass8.setText("Attended: "+getPreviousAttendedClass[7]);
                SubjectWisetvTotalClass8.setText("Total: "+getPreviousTotalClass[7]);
            }
            if(sizeof>=9)
            {
                LayoutSubjectWise9.setVisibility(View.VISIBLE);
                SubjectWiseTVSub9.setText(totalSubjects[8]);
                SubjectWisetvAttendedClass9.setText("Attended: "+getPreviousAttendedClass[8]);
                SubjectWisetvTotalClass9.setText("Total: "+getPreviousTotalClass[8]);
            }
            if(sizeof>=10)
            {
                LayoutSubjectWise10.setVisibility(View.VISIBLE);
                SubjectWiseTVSub10.setText(totalSubjects[9]);
                SubjectWisetvAttendedClass10.setText("Attended: "+getPreviousAttendedClass[9]);
                SubjectWisetvTotalClass10.setText("Total: "+getPreviousTotalClass[9]);
            }
            if(sizeof>=11)
            {
                LayoutSubjectWise11.setVisibility(View.VISIBLE);
                SubjectWiseTVSub11.setText(totalSubjects[10]);
                SubjectWisetvAttendedClass11.setText("Attended: "+getPreviousAttendedClass[10]);
                SubjectWisetvTotalClass11.setText("Total: "+getPreviousTotalClass[10]);
            }
            if(sizeof>=12)
            {
                LayoutSubjectWise12.setVisibility(View.VISIBLE);
                SubjectWiseTVSub12.setText(totalSubjects[11]);
                SubjectWisetvAttendedClass12.setText("Attended: "+getPreviousAttendedClass[11]);
                SubjectWisetvTotalClass12.setText("Total: "+getPreviousTotalClass[11]);
            }
            if(sizeof>=13)
            {
                LayoutSubjectWise13.setVisibility(View.VISIBLE);
                SubjectWiseTVSub13.setText(totalSubjects[12]);
                SubjectWisetvAttendedClass13.setText("Attended: "+getPreviousAttendedClass[12]);
                SubjectWisetvTotalClass13.setText("Total: "+getPreviousTotalClass[12]);
            }
            if(sizeof>=14)
            {
                LayoutSubjectWise14.setVisibility(View.VISIBLE);
                SubjectWiseTVSub14.setText(totalSubjects[13]);
                SubjectWisetvAttendedClass14.setText("Attended: "+getPreviousAttendedClass[13]);
                SubjectWisetvTotalClass14.setText("Total: "+getPreviousTotalClass[13]);
            }
            if(sizeof>=15)
            {
                LayoutSubjectWise15.setVisibility(View.VISIBLE);
                SubjectWiseTVSub15.setText(totalSubjects[14]);
                SubjectWisetvAttendedClass15.setText("Attended: "+getPreviousAttendedClass[14]);
                SubjectWisetvTotalClass15.setText("Total: "+getPreviousTotalClass[14]);
            }
            if(sizeof>=16)
            {
                LayoutSubjectWise16.setVisibility(View.VISIBLE);
                SubjectWiseTVSub16.setText(totalSubjects[15]);
                SubjectWisetvAttendedClass16.setText("Attended: "+getPreviousAttendedClass[15]);
                SubjectWisetvTotalClass16.setText("Total: "+getPreviousTotalClass[15]);
            }
            if(sizeof>=17)
            {
                LayoutSubjectWise17.setVisibility(View.VISIBLE);
                SubjectWiseTVSub17.setText(totalSubjects[16]);
                SubjectWisetvAttendedClass17.setText("Attended: "+getPreviousAttendedClass[16]);
                SubjectWisetvTotalClass17.setText("Total: "+getPreviousTotalClass[16]);
            }
            if(sizeof>=18)
            {
                LayoutSubjectWise18.setVisibility(View.VISIBLE);
                SubjectWiseTVSub18.setText(totalSubjects[17]);
                SubjectWisetvAttendedClass18.setText("Attended: "+getPreviousAttendedClass[17]);
                SubjectWisetvTotalClass18.setText("Total: "+getPreviousTotalClass[17]);
            }
            if(sizeof>=19)
            {
                LayoutSubjectWise19.setVisibility(View.VISIBLE);
                SubjectWiseTVSub19.setText(totalSubjects[18]);
                SubjectWisetvAttendedClass19.setText("Attended: "+getPreviousAttendedClass[18]);
                SubjectWisetvTotalClass19.setText("Total: "+getPreviousTotalClass[18]);
            }
            if(sizeof>=20)
            {
                LayoutSubjectWise20.setVisibility(View.VISIBLE);
                SubjectWiseTVSub20.setText(totalSubjects[19]);
                SubjectWisetvAttendedClass20.setText("Attended: "+getPreviousAttendedClass[19]);
                SubjectWisetvTotalClass20.setText("Total: "+getPreviousTotalClass[19]);
            }
        }
        else
        {
            subjectWiseTVNotEntered.setVisibility(View.VISIBLE);
        }
        setPercentageTextViewColor();
        return view;
    }
    public void setPercentageTextViewColor()
    {
        Float[] per=new Float[20];
        String[] str=new String[20];
        String[] strOnTrack=new String[20];
        float temp1,temp2;
        int i;
        for(i=0;i<20;i++)
        {
            per[i]=0.0f;
            str[i]="0.0";
        }
        for(i=0;i<sizeof;i++)
        {
            temp1=getPreviousAttendedClass[i];
            temp2=getPreviousTotalClass[i];
            per[i]=(temp1/temp2)*100;
            if(per[i]==100)
                str[i]="100";
            else
                str[i]=String.format(java.util.Locale.US,"%.1f",per[i]);
            strOnTrack[i]=onTrackTV(per[i],temp1,temp2);
        }
        SubjectWisetvPercentage1.setText(str[0]+"%");
        SubjectWisetvPercentage2.setText(str[1]+"%");
        SubjectWisetvPercentage3.setText(str[2]+"%");
        SubjectWisetvPercentage4.setText(str[3]+"%");
        SubjectWisetvPercentage5.setText(str[4]+"%");
        SubjectWisetvPercentage6.setText(str[5]+"%");
        SubjectWisetvPercentage7.setText(str[6]+"%");
        SubjectWisetvPercentage8.setText(str[7]+"%");
        SubjectWisetvPercentage9.setText(str[8]+"%");
        SubjectWisetvPercentage10.setText(str[9]+"%");
        SubjectWisetvPercentage11.setText(str[10]+"%");
        SubjectWisetvPercentage12.setText(str[11]+"%");
        SubjectWisetvPercentage13.setText(str[12]+"%");
        SubjectWisetvPercentage14.setText(str[13]+"%");
        SubjectWisetvPercentage15.setText(str[14]+"%");
        SubjectWisetvPercentage16.setText(str[15]+"%");
        SubjectWisetvPercentage17.setText(str[16]+"%");
        SubjectWisetvPercentage18.setText(str[17]+"%");
        SubjectWisetvPercentage19.setText(str[18]+"%");
        SubjectWisetvPercentage20.setText(str[19]+"%");

        SubjectWisetvOnTrack1.setText(strOnTrack[0]);
        SubjectWisetvOnTrack2.setText(strOnTrack[1]);
        SubjectWisetvOnTrack3.setText(strOnTrack[2]);
        SubjectWisetvOnTrack4.setText(strOnTrack[3]);
        SubjectWisetvOnTrack5.setText(strOnTrack[4]);
        SubjectWisetvOnTrack6.setText(strOnTrack[5]);
        SubjectWisetvOnTrack7.setText(strOnTrack[6]);
        SubjectWisetvOnTrack8.setText(strOnTrack[7]);
        SubjectWisetvOnTrack9.setText(strOnTrack[8]);
        SubjectWisetvOnTrack10.setText(strOnTrack[9]);
        SubjectWisetvOnTrack11.setText(strOnTrack[10]);
        SubjectWisetvOnTrack12.setText(strOnTrack[11]);
        SubjectWisetvOnTrack13.setText(strOnTrack[12]);
        SubjectWisetvOnTrack14.setText(strOnTrack[13]);
        SubjectWisetvOnTrack15.setText(strOnTrack[14]);
        SubjectWisetvOnTrack16.setText(strOnTrack[15]);
        SubjectWisetvOnTrack17.setText(strOnTrack[16]);
        SubjectWisetvOnTrack18.setText(strOnTrack[17]);
        SubjectWisetvOnTrack19.setText(strOnTrack[18]);
        SubjectWisetvOnTrack20.setText(strOnTrack[19]);

        if(per[0]<attend)
            SubjectWisetvPercentage1.setTextColor(Color.parseColor("#B22222"));//red
        else
            SubjectWisetvPercentage1.setTextColor(Color.parseColor("#008000"));//green
        if(per[1]<attend)
            SubjectWisetvPercentage2.setTextColor(Color.parseColor("#B22222"));//red
        else
            SubjectWisetvPercentage2.setTextColor(Color.parseColor("#008000"));//green
        if(per[2]<attend)
            SubjectWisetvPercentage3.setTextColor(Color.parseColor("#B22222"));//red
        else
            SubjectWisetvPercentage3.setTextColor(Color.parseColor("#008000"));//green
        if(per[3]<attend)
            SubjectWisetvPercentage4.setTextColor(Color.parseColor("#B22222"));//red
        else
            SubjectWisetvPercentage4.setTextColor(Color.parseColor("#008000"));//green
        if(per[4]<attend)
            SubjectWisetvPercentage5.setTextColor(Color.parseColor("#B22222"));//red
        else
            SubjectWisetvPercentage5.setTextColor(Color.parseColor("#008000"));//green
        if(per[5]<attend)
            SubjectWisetvPercentage6.setTextColor(Color.parseColor("#B22222"));//red
        else
            SubjectWisetvPercentage6.setTextColor(Color.parseColor("#008000"));//green
        if(per[6]<attend)
            SubjectWisetvPercentage7.setTextColor(Color.parseColor("#B22222"));//red
        else
            SubjectWisetvPercentage7.setTextColor(Color.parseColor("#008000"));//green
        if(per[7]<attend)
            SubjectWisetvPercentage8.setTextColor(Color.parseColor("#B22222"));//red
        else
            SubjectWisetvPercentage8.setTextColor(Color.parseColor("#008000"));//green
        if(per[8]<attend)
            SubjectWisetvPercentage9.setTextColor(Color.parseColor("#B22222"));//red
        else
            SubjectWisetvPercentage9.setTextColor(Color.parseColor("#008000"));//green
        if(per[9]<attend)
            SubjectWisetvPercentage10.setTextColor(Color.parseColor("#B22222"));//red
        else
            SubjectWisetvPercentage10.setTextColor(Color.parseColor("#008000"));//green
        if(per[10]<attend)
            SubjectWisetvPercentage11.setTextColor(Color.parseColor("#B22222"));//red
        else
            SubjectWisetvPercentage11.setTextColor(Color.parseColor("#008000"));//green
        if(per[11]<attend)
            SubjectWisetvPercentage12.setTextColor(Color.parseColor("#B22222"));//red
        else
            SubjectWisetvPercentage12.setTextColor(Color.parseColor("#008000"));//green
        if(per[12]<attend)
            SubjectWisetvPercentage13.setTextColor(Color.parseColor("#B22222"));//red
        else
            SubjectWisetvPercentage13.setTextColor(Color.parseColor("#008000"));//green
        if(per[13]<attend)
            SubjectWisetvPercentage14.setTextColor(Color.parseColor("#B22222"));//red
        else
            SubjectWisetvPercentage14.setTextColor(Color.parseColor("#008000"));//green
        if(per[14]<attend)
            SubjectWisetvPercentage15.setTextColor(Color.parseColor("#B22222"));//red
        else
            SubjectWisetvPercentage15.setTextColor(Color.parseColor("#008000"));//green
        if(per[15]<attend)
            SubjectWisetvPercentage16.setTextColor(Color.parseColor("#B22222"));//red
        else
            SubjectWisetvPercentage16.setTextColor(Color.parseColor("#008000"));//green
        if(per[16]<attend)
            SubjectWisetvPercentage17.setTextColor(Color.parseColor("#B22222"));//red
        else
            SubjectWisetvPercentage17.setTextColor(Color.parseColor("#008000"));//green
        if(per[17]<attend)
            SubjectWisetvPercentage18.setTextColor(Color.parseColor("#B22222"));//red
        else
            SubjectWisetvPercentage18.setTextColor(Color.parseColor("#008000"));//green
        if(per[18]<attend)
            SubjectWisetvPercentage19.setTextColor(Color.parseColor("#B22222"));//red
        else
            SubjectWisetvPercentage19.setTextColor(Color.parseColor("#008000"));//green
        if(per[19]<attend)
            SubjectWisetvPercentage20.setTextColor(Color.parseColor("#B22222"));//red
        else
            SubjectWisetvPercentage20.setTextColor(Color.parseColor("#008000"));//green
    }
    public String onTrackTV(float a,float b,float c)
    {
        float tempx,tempx1,tempx2;
        String string="";
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
            string="!!! You are on track !!!";
        return string;
    }
    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        getActivity().setTitle("SubjectWise Attendance");
    }
}
