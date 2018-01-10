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

public class Saturday extends Fragment {
    Button bmon,btue,bwed,bthu,bfri,bsat,bsun,buttonDone;
    EditText sats1,sats2,sats3,sats4,sats5,sats6,sats7;
    String satsub1,satsub2,satsub3,satsub4,satsub5,satsub6,satsub7;
    Fragment fragment=null;
    SessionManager sessionManager;
    String[] subjectOfSaturday;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){

        View view=inflater.inflate(R.layout.saturday,viewGroup,false);

        sessionManager=new SessionManager(getActivity());
        subjectOfSaturday=new String[7];
        final int sizeof=sessionManager.getSize();
        final String[] totalSubjects=sessionManager.loadArray("mySubject");

        bmon=(Button)view.findViewById(R.id.bmon);
        btue=(Button)view.findViewById(R.id.btue);
        bwed=(Button)view.findViewById(R.id.bwed);
        bthu=(Button)view.findViewById(R.id.bthu);
        bfri=(Button)view.findViewById(R.id.bfri);
        bsat=(Button)view.findViewById(R.id.bsat);
        bsun=(Button)view.findViewById(R.id.bsun);
        buttonDone=(Button)view.findViewById(R.id.buttonOksat);

        sats1=(EditText)view.findViewById(R.id.sats1);
        sats2=(EditText)view.findViewById(R.id.sats2);
        sats3=(EditText)view.findViewById(R.id.sats3);
        sats4=(EditText)view.findViewById(R.id.sats4);
        sats5=(EditText)view.findViewById(R.id.sats5);
        sats6=(EditText)view.findViewById(R.id.sats6);
        sats7=(EditText)view.findViewById(R.id.sats7);

        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int countSat=0;
                int i,j,pos=0,flag=0;
                satsub1=sats1.getText().toString();
                satsub2=sats2.getText().toString();
                satsub3=sats3.getText().toString();
                satsub4=sats4.getText().toString();
                satsub5=sats5.getText().toString();
                satsub6=sats6.getText().toString();
                satsub7=sats7.getText().toString();

                subjectOfSaturday[0]=satsub1;
                subjectOfSaturday[1]=satsub2;
                subjectOfSaturday[2]=satsub3;
                subjectOfSaturday[3]=satsub4;
                subjectOfSaturday[4]=satsub5;
                subjectOfSaturday[5]=satsub6;
                subjectOfSaturday[6]=satsub7;


                for(i=0;i<7;i++)
                {
                    flag=0;
                    if(!subjectOfSaturday[i].equals(""))
                    {
                        for(j=0;j<sizeof;j++)
                        {
                            if(subjectOfSaturday[i].equals(totalSubjects[j]))
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

                if(!satsub1.equals(""))
                    countSat++;
                if(!satsub2.equals(""))
                    countSat++;
                if(!satsub3.equals(""))
                    countSat++;
                if(!satsub4.equals(""))
                    countSat++;
                if(!satsub5.equals(""))
                    countSat++;
                if(!satsub6.equals(""))
                    countSat++;
                if(!satsub7.equals(""))
                    countSat++;

                if(flag==1)
                {
                    new SessionManager(getContext()).satSubjects(satsub1,satsub2,satsub3,satsub4,satsub5,satsub6,satsub7);
                    new SessionManager(getContext()).setCountSat(countSat);

                    fragment = new EnterPreAtten();
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
                Toast.makeText(getActivity(), "Kindly press DONE to proceed", Toast.LENGTH_SHORT).show();
            }
        });
        btue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Kindly press DONE to proceed", Toast.LENGTH_SHORT).show();
            }
        });
        bwed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Kindly press DONE to proceed", Toast.LENGTH_SHORT).show();
            }
        });
        bthu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Kindly press DONE to proceed", Toast.LENGTH_SHORT).show();
            }
        });
        bfri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Kindly press DONE to proceed", Toast.LENGTH_SHORT).show();
            }
        });
        bsat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Kindly press DONE to proceed", Toast.LENGTH_SHORT).show();
            }
        });
        bsun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Kindly press DONE to proceed", Toast.LENGTH_SHORT).show();
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
