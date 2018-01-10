package com.example.ravi.myattendance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Ravi on 04-Oct-17.
 */

public class Tuesday extends Fragment {
    Button bmon,btue,bwed,bthu,bfri,bsat,bsun,buttonOktue;
    EditText tues1,tues2,tues3,tues4,tues5,tues6,tues7;
    String tuesub1,tuesub2,tuesub3,tuesub4,tuesub5,tuesub6,tuesub7;
    Fragment fragment=null;
    SessionManager sessionManager;
    String[] subjectOfTuesday;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){

        View view=inflater.inflate(R.layout.tuesday,viewGroup,false);

        sessionManager=new SessionManager(getActivity());
        subjectOfTuesday=new String[7];
        final int sizeof=sessionManager.getSize();
        final String[] totalSubjects=sessionManager.loadArray("mySubject");

        bmon=(Button)view.findViewById(R.id.bmon);
        btue=(Button)view.findViewById(R.id.btue);
        bwed=(Button)view.findViewById(R.id.bwed);
        bthu=(Button)view.findViewById(R.id.bthu);
        bfri=(Button)view.findViewById(R.id.bfri);
        bsat=(Button)view.findViewById(R.id.bsat);
        bsun=(Button)view.findViewById(R.id.bsun);
        buttonOktue=(Button) view.findViewById(R.id.buttonOktue);

        tues1=(EditText)view.findViewById(R.id.tues1);
        tues2=(EditText)view.findViewById(R.id.tues2);
        tues3=(EditText)view.findViewById(R.id.tues3);
        tues4=(EditText)view.findViewById(R.id.tues4);
        tues5=(EditText)view.findViewById(R.id.tues5);
        tues6=(EditText)view.findViewById(R.id.tues6);
        tues7=(EditText)view.findViewById(R.id.tues7);

        buttonOktue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int countTue=0;
                int i,j,pos=0,flag=0;
                tuesub1=tues1.getText().toString();
                tuesub2=tues2.getText().toString();
                tuesub3=tues3.getText().toString();
                tuesub4=tues4.getText().toString();
                tuesub5=tues5.getText().toString();
                tuesub6=tues6.getText().toString();
                tuesub7=tues7.getText().toString();

                subjectOfTuesday[0]=tuesub1;
                subjectOfTuesday[1]=tuesub2;
                subjectOfTuesday[2]=tuesub3;
                subjectOfTuesday[3]=tuesub4;
                subjectOfTuesday[4]=tuesub5;
                subjectOfTuesday[5]=tuesub6;
                subjectOfTuesday[6]=tuesub7;

                for(i=0;i<7;i++)
                {
                    flag=0;
                    if(!subjectOfTuesday[i].equals(""))
                    {
                        for(j=0;j<sizeof;j++)
                        {
                            if(subjectOfTuesday[i].equals(totalSubjects[j]))
                            {
                                flag=1;
                                break;
                            }
                        }
                    }
                    else
                        flag=1;
                    if(flag==0)
                    {
                        pos=i+1;
                        break;
                    }
                }

                if(!tuesub1.equals(""))
                    countTue++;
                if(!tuesub2.equals(""))
                    countTue++;
                if(!tuesub3.equals(""))
                    countTue++;
                if(!tuesub4.equals(""))
                    countTue++;
                if(!tuesub5.equals(""))
                    countTue++;
                if(!tuesub6.equals(""))
                    countTue++;
                if(!tuesub7.equals(""))
                    countTue++;

                if(flag==1)
                {
                    new SessionManager(getContext()).tueSubjects(tuesub1,tuesub2,tuesub3,tuesub4,tuesub5,tuesub6,tuesub7);
                    new SessionManager(getContext()).setCountTue(countTue);

                    fragment = new Wednesday();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.content_frame, fragment);
                    ft.commit();
                }
                else
                {
                    Toast.makeText(getActivity(), "Subject "+pos+" doesn't match with entered subjects", Toast.LENGTH_LONG).show();
                }


            }
        });
        bmon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Kindly press OK to go to next day", Toast.LENGTH_SHORT).show();
            }
        });
        btue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Kindly press OK to go to next day", Toast.LENGTH_SHORT).show();
            }
        });
        bwed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Kindly press OK to go to next day", Toast.LENGTH_SHORT).show();
            }
        });
        bthu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Kindly press OK to go to next day", Toast.LENGTH_SHORT).show();
            }
        });
        bfri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Kindly press OK to go to next day", Toast.LENGTH_SHORT).show();
            }
        });
        bsat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Kindly press OK to go to next day", Toast.LENGTH_SHORT).show();
            }
        });
        bsun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Kindly press OK to go to next day", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        getActivity().setTitle("Time Table");
    }
}
