package com.abcd.ravi.myattendance;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Ravi on 04-Oct-17.
 */

public class Friday extends Fragment {
    Button bmon,btue,bwed,bthu,bfri,bsat,bsun,buttonOk,buttonOkFri,buttonNo;
    TextView mons1,mons2,mons3,mons4,mons5,mons6,mons7,clickPlus,scheduleTV;
    String msub1,msub2,msub3,msub4,msub5,msub6,msub7;
    ImageButton IBd1,IBd2,IBd3,IBd4,IBd5,IBd6,IBd7,IBAddSub;
    LinearLayout LLSatWorkingDay;
    Fragment fragment=null;
    SessionManager sessionManager;
    int sizeof,count=0,cnt;
    String[] totalSubjects;
    String[] exactSub;
    Integer[] attended;
    Integer[] total;
    Calendar calendar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){

        View view=inflater.inflate(R.layout.mon,viewGroup,false);

        sessionManager=new SessionManager(getActivity());
        sizeof=sessionManager.getSize();
        totalSubjects=sessionManager.loadArray("mySubject");
        exactSub=new String[sizeof];
        for(int i=0;i<sizeof;i++)
            exactSub[i]=totalSubjects[i];

        bmon=(Button)view.findViewById(R.id.bmon);
        btue=(Button)view.findViewById(R.id.btue);
        bwed=(Button)view.findViewById(R.id.bwed);
        bthu=(Button)view.findViewById(R.id.bthu);
        bfri=(Button)view.findViewById(R.id.bfri);
        bsat=(Button)view.findViewById(R.id.bsat);
        bsun=(Button)view.findViewById(R.id.bsun);
        buttonOk=(Button)view.findViewById(R.id.buttonOk);
        buttonOkFri=(Button)view.findViewById(R.id.buttonOkfri);
        buttonNo=(Button)view.findViewById(R.id.bNo);

        LLSatWorkingDay=(LinearLayout)view.findViewById(R.id.LLSatWorkingDay);
        LLSatWorkingDay.setVisibility(View.VISIBLE);
        buttonOk.setVisibility(View.GONE);

        mons1=(TextView)view.findViewById(R.id.mons1);
        mons2=(TextView)view.findViewById(R.id.mons2);
        mons3=(TextView)view.findViewById(R.id.mons3);
        mons4=(TextView)view.findViewById(R.id.mons4);
        mons5=(TextView)view.findViewById(R.id.mons5);
        mons6=(TextView)view.findViewById(R.id.mons6);
        mons7=(TextView)view.findViewById(R.id.mons7);
        clickPlus=(TextView) view.findViewById(R.id.clickPlus);
        scheduleTV=(TextView) view.findViewById(R.id.scheduleTV);

        bfri.setTextColor(Color.parseColor("#FF4081"));
        scheduleTV.setText("Friday Schedule");

        IBd1=(ImageButton)view.findViewById(R.id.IBd1);
        IBd2=(ImageButton)view.findViewById(R.id.IBd2);
        IBd3=(ImageButton)view.findViewById(R.id.IBd3);
        IBd4=(ImageButton)view.findViewById(R.id.IBd4);
        IBd5=(ImageButton)view.findViewById(R.id.IBd5);
        IBd6=(ImageButton)view.findViewById(R.id.IBd6);
        IBd7=(ImageButton)view.findViewById(R.id.IBd7);
        IBAddSub=(ImageButton)view.findViewById(R.id.IBAddSub);

        IBd1.setVisibility(View.GONE);
        IBd2.setVisibility(View.GONE);
        IBd3.setVisibility(View.GONE);
        IBd4.setVisibility(View.GONE);
        IBd5.setVisibility(View.GONE);
        IBd6.setVisibility(View.GONE);
        IBd7.setVisibility(View.GONE);

        IBAddSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Select Subjects for Friday");
                builder.setItems(exactSub, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        // Do something with the selection
                        //count++;
                        clickPlus.setVisibility(View.GONE);
                        if(mons1.getText().equals(""))
                        {
                            mons1.setVisibility(View.VISIBLE);
                            IBd1.setVisibility(View.VISIBLE);
                            mons1.setText(exactSub[item]);
                        }
                        else if(mons2.getText().equals(""))
                        {
                            mons2.setVisibility(View.VISIBLE);
                            IBd2.setVisibility(View.VISIBLE);
                            mons2.setText(exactSub[item]);
                        }
                        else if(mons3.getText().equals(""))
                        {
                            mons3.setVisibility(View.VISIBLE);
                            IBd3.setVisibility(View.VISIBLE);
                            mons3.setText(exactSub[item]);
                        }
                        else if(mons4.getText().equals(""))
                        {
                            mons4.setVisibility(View.VISIBLE);
                            IBd4.setVisibility(View.VISIBLE);
                            mons4.setText(exactSub[item]);
                        }
                        else if(mons5.getText().equals(""))
                        {
                            mons5.setVisibility(View.VISIBLE);
                            IBd5.setVisibility(View.VISIBLE);
                            mons5.setText(exactSub[item]);
                        }
                        else if(mons6.getText().equals(""))
                        {
                            mons6.setVisibility(View.VISIBLE);
                            IBd6.setVisibility(View.VISIBLE);
                            mons6.setText(exactSub[item]);
                        }
                        else if(mons7.getText().equals(""))
                        {
                            mons7.setVisibility(View.VISIBLE);
                            IBd7.setVisibility(View.VISIBLE);
                            mons7.setText(exactSub[item]);
                        }
                        else
                            Toast.makeText(getActivity(), "Only 7 lectures allowed", Toast.LENGTH_SHORT).show();
                        //Toast.makeText(getActivity(), exactSub[item], Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        IBd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mons1.setVisibility(View.VISIBLE);
                mons1.setText("");
                IBd1.setVisibility(View.INVISIBLE);
            }
        });
        IBd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mons2.setVisibility(View.VISIBLE);
                mons2.setText("");
                IBd2.setVisibility(View.INVISIBLE);
            }
        });
        IBd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mons3.setVisibility(View.VISIBLE);
                mons3.setText("");
                IBd3.setVisibility(View.INVISIBLE);
            }
        });
        IBd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mons4.setVisibility(View.VISIBLE);
                mons4.setText("");
                IBd4.setVisibility(View.INVISIBLE);
            }
        });
        IBd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mons5.setVisibility(View.VISIBLE);
                mons5.setText("");
                IBd5.setVisibility(View.INVISIBLE);
            }
        });
        IBd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mons6.setVisibility(View.VISIBLE);
                mons6.setText("");
                IBd6.setVisibility(View.INVISIBLE);
            }
        });
        IBd7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mons7.setVisibility(View.VISIBLE);
                mons7.setText("");
                IBd7.setVisibility(View.INVISIBLE);
            }
        });

        buttonOkFri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getEnteredSubjects();
                sessionManager.friSubjects(msub1,msub2,msub3,msub4,msub5,msub6,msub7);
                sessionManager.setCountFri(cnt);

                fragment = new Saturday();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, fragment);
                ft.commit();

            }
        });

        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getEnteredSubjects();
                sessionManager.friSubjects(msub1,msub2,msub3,msub4,msub5,msub6,msub7);
                sessionManager.setCountFri(cnt);

                sessionManager.satSubjects("","","","","","","");
                sessionManager.setCountSat(0);

                AlertDialog.Builder alertDialog=new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("Enter Previous Attendance?");
                alertDialog.setPositiveButton("Yes",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        fragment = new PreAttendance();
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.content_frame, fragment);
                        ft.commit();
                    }
                });
                alertDialog.setNegativeButton("No",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        attended=new Integer[20];
                        total=new Integer[20];
                        for(int j=0;j<20;j++)
                        {
                            attended[j]=0;
                            total[j]=0;
                        }
                        sessionManager.setAttended(attended,"classAttended");
                        sessionManager.setTotal(total,"classTotal");
                        sessionManager.makeLogin();
                        sessionManager.setFlag(true);

                        /*calendar= Calendar.getInstance();

                        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
                        Date d = new Date();
                        String dayOfTheWeek = sdf.format(d);
                        sessionManager.setOpenDay(dayOfTheWeek);*/

                        fragment=new Main2();
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.content_frame, fragment);
                        ft.commit();
                    }
                });
                AlertDialog al=alertDialog.create();
                al.show();

            }
        });
        return view;
    }

    public void getEnteredSubjects()
    {
        cnt=0;
        msub1=mons1.getText().toString();
        msub2=mons2.getText().toString();
        msub3=mons3.getText().toString();
        msub4=mons4.getText().toString();
        msub5=mons5.getText().toString();
        msub6=mons6.getText().toString();
        msub7=mons7.getText().toString();

        if(!msub1.equals(""))
            cnt++;
        if(!msub2.equals(""))
            cnt++;
        if(!msub3.equals(""))
            cnt++;
        if(!msub4.equals(""))
            cnt++;
        if(!msub5.equals(""))
            cnt++;
        if(!msub6.equals(""))
            cnt++;
        if(!msub7.equals(""))
            cnt++;
    }
    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        getActivity().setTitle("Time Table");
    }
}
