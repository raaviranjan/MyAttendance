package com.example.ravi.myattendance;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Ravi on 20-Nov-17.
 */

public class ExtraClass extends Fragment {
    Button ExtraClassButtonSub1,ExtraClassButtonSub2,ExtraClassButtonSub3,ExtraClassButtonSub4,ExtraClassButtonSub5,ExtraClassButtonSub6,
            ExtraClassButtonSub7,ExtraClassButtonSub8,ExtraClassButtonSub9,ExtraClassButtonSub10,ExtraClassButtonSub11,ExtraClassButtonSub12,
            ExtraClassButtonSub13,ExtraClassButtonSub14,ExtraClassButtonSub15,ExtraClassButtonSub16,ExtraClassButtonSub17,ExtraClassButtonSub18,
            ExtraClassButtonSub19,ExtraClassButtonSub20;
    SessionManager sessionManager;
    Integer[] getPreviousAttendedClass;
    Integer[] getPreviousTotalClass;
    String[] totalSubjects;
    int sizeof;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.extra_class, viewGroup, false);

        ExtraClassButtonSub1=(Button)view.findViewById(R.id.ExtraClassButtonSub1);
        ExtraClassButtonSub2=(Button)view.findViewById(R.id.ExtraClassButtonSub2);
        ExtraClassButtonSub3=(Button)view.findViewById(R.id.ExtraClassButtonSub3);
        ExtraClassButtonSub4=(Button)view.findViewById(R.id.ExtraClassButtonSub4);
        ExtraClassButtonSub5=(Button)view.findViewById(R.id.ExtraClassButtonSub5);
        ExtraClassButtonSub6=(Button)view.findViewById(R.id.ExtraClassButtonSub6);
        ExtraClassButtonSub7=(Button)view.findViewById(R.id.ExtraClassButtonSub7);
        ExtraClassButtonSub8=(Button)view.findViewById(R.id.ExtraClassButtonSub8);
        ExtraClassButtonSub9=(Button)view.findViewById(R.id.ExtraClassButtonSub9);
        ExtraClassButtonSub10=(Button)view.findViewById(R.id.ExtraClassButtonSub10);
        ExtraClassButtonSub11=(Button)view.findViewById(R.id.ExtraClassButtonSub11);
        ExtraClassButtonSub12=(Button)view.findViewById(R.id.ExtraClassButtonSub12);
        ExtraClassButtonSub13=(Button)view.findViewById(R.id.ExtraClassButtonSub13);
        ExtraClassButtonSub14=(Button)view.findViewById(R.id.ExtraClassButtonSub14);
        ExtraClassButtonSub15=(Button)view.findViewById(R.id.ExtraClassButtonSub15);
        ExtraClassButtonSub16=(Button)view.findViewById(R.id.ExtraClassButtonSub16);
        ExtraClassButtonSub17=(Button)view.findViewById(R.id.ExtraClassButtonSub17);
        ExtraClassButtonSub18=(Button)view.findViewById(R.id.ExtraClassButtonSub18);
        ExtraClassButtonSub19=(Button)view.findViewById(R.id.ExtraClassButtonSub19);
        ExtraClassButtonSub20=(Button)view.findViewById(R.id.ExtraClassButtonSub20);

        sessionManager=new SessionManager(getActivity());
        getPreviousAttendedClass=sessionManager.getAttended("classAttended");
        getPreviousTotalClass=sessionManager.getTotal("classTotal");
        totalSubjects=sessionManager.loadArray("mySubject");
        sizeof=sessionManager.getSize();

        if(sizeof>0)
        {
            if(sizeof>=1)
            {
                ExtraClassButtonSub1.setVisibility(View.VISIBLE);
                ExtraClassButtonSub1.setText(totalSubjects[0]);
                ExtraClassButtonSub1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog(0);
                    }
                });
            }
            if(sizeof>=2)
            {
                ExtraClassButtonSub2.setVisibility(View.VISIBLE);
                ExtraClassButtonSub2.setText(totalSubjects[1]);
                ExtraClassButtonSub2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog(1);
                    }
                });
            }
            if(sizeof>=3)
            {
                ExtraClassButtonSub3.setVisibility(View.VISIBLE);
                ExtraClassButtonSub3.setText(totalSubjects[2]);
                ExtraClassButtonSub3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog(2);
                    }
                });
            }
            if(sizeof>=4)
            {
                ExtraClassButtonSub4.setVisibility(View.VISIBLE);
                ExtraClassButtonSub4.setText(totalSubjects[3]);
                ExtraClassButtonSub4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog(3);
                    }
                });
            }
            if(sizeof>=5)
            {
                ExtraClassButtonSub5.setVisibility(View.VISIBLE);
                ExtraClassButtonSub5.setText(totalSubjects[4]);
                ExtraClassButtonSub5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog(4);
                    }
                });
            }
            if(sizeof>=6)
            {
                ExtraClassButtonSub6.setVisibility(View.VISIBLE);
                ExtraClassButtonSub6.setText(totalSubjects[5]);
                ExtraClassButtonSub6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog(5);
                    }
                });
            }
            if(sizeof>=7)
            {
                ExtraClassButtonSub7.setVisibility(View.VISIBLE);
                ExtraClassButtonSub7.setText(totalSubjects[6]);
                ExtraClassButtonSub7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog(6);
                    }
                });
            }
            if(sizeof>=8)
            {
                ExtraClassButtonSub8.setVisibility(View.VISIBLE);
                ExtraClassButtonSub8.setText(totalSubjects[7]);
                ExtraClassButtonSub8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog(7);
                    }
                });
            }
            if(sizeof>=9)
            {
                ExtraClassButtonSub9.setVisibility(View.VISIBLE);
                ExtraClassButtonSub9.setText(totalSubjects[8]);
                ExtraClassButtonSub9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog(8);
                    }
                });
            }
            if(sizeof>=10)
            {
                ExtraClassButtonSub10.setVisibility(View.VISIBLE);
                ExtraClassButtonSub10.setText(totalSubjects[9]);
                ExtraClassButtonSub10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog(9);
                    }
                });
            }
            if(sizeof>=11)
            {
                ExtraClassButtonSub11.setVisibility(View.VISIBLE);
                ExtraClassButtonSub11.setText(totalSubjects[10]);
                ExtraClassButtonSub11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog(10);
                    }
                });
            }
            if(sizeof>=12)
            {
                ExtraClassButtonSub12.setVisibility(View.VISIBLE);
                ExtraClassButtonSub12.setText(totalSubjects[11]);
                ExtraClassButtonSub12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog(11);
                    }
                });
            }
            if(sizeof>=13)
            {
                ExtraClassButtonSub13.setVisibility(View.VISIBLE);
                ExtraClassButtonSub13.setText(totalSubjects[12]);
                ExtraClassButtonSub13.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog(12);
                    }
                });
            }
            if(sizeof>=14)
            {
                ExtraClassButtonSub14.setVisibility(View.VISIBLE);
                ExtraClassButtonSub14.setText(totalSubjects[13]);
                ExtraClassButtonSub14.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog(13);
                    }
                });
            }
            if(sizeof>=15)
            {
                ExtraClassButtonSub15.setVisibility(View.VISIBLE);
                ExtraClassButtonSub15.setText(totalSubjects[14]);
                ExtraClassButtonSub15.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog(14);
                    }
                });
            }
            if(sizeof>=16)
            {
                ExtraClassButtonSub16.setVisibility(View.VISIBLE);
                ExtraClassButtonSub16.setText(totalSubjects[15]);
                ExtraClassButtonSub16.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog(15);
                    }
                });
            }
            if(sizeof>=17)
            {
                ExtraClassButtonSub17.setVisibility(View.VISIBLE);
                ExtraClassButtonSub17.setText(totalSubjects[16]);
                ExtraClassButtonSub17.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog(16);
                    }
                });
            }
            if(sizeof>=18)
            {
                ExtraClassButtonSub18.setVisibility(View.VISIBLE);
                ExtraClassButtonSub18.setText(totalSubjects[17]);
                ExtraClassButtonSub18.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog(17);
                    }
                });
            }
            if(sizeof>=19)
            {
                ExtraClassButtonSub19.setVisibility(View.VISIBLE);
                ExtraClassButtonSub19.setText(totalSubjects[18]);
                ExtraClassButtonSub19.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog(18);
                    }
                });
            }
            if(sizeof>=20)
            {
                ExtraClassButtonSub20.setVisibility(View.VISIBLE);
                ExtraClassButtonSub20.setText(totalSubjects[19]);
                ExtraClassButtonSub20.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog(19);
                    }
                });
            }
        }
        else
            Toast.makeText(getActivity(), "No subjects to display", Toast.LENGTH_SHORT).show();

        return view;
    }
    public void dialog(final int a)
    {
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("Extra Class Attendance");
        alertDialog.setMessage(totalSubjects[a]);
        alertDialog.setPositiveButton("Present",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                getPreviousAttendedClass[a]++;
                getPreviousTotalClass[a]++;
                sessionManager.setAttended(getPreviousAttendedClass,"classAttended");
                sessionManager.setTotal(getPreviousTotalClass,"classTotal");
                Toast.makeText(getActivity(), "Class Attended", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.setNegativeButton("Absent",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                getPreviousTotalClass[a]++;
                sessionManager.setAttended(getPreviousAttendedClass,"classAttended");
                sessionManager.setTotal(getPreviousTotalClass,"classTotal");
                Toast.makeText(getActivity(), "Class Missed", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog al=alertDialog.create();
        al.show();
    }
    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        getActivity().setTitle("Extra Class");
    }
}
