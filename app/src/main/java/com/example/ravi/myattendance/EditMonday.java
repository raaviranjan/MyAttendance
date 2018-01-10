package com.example.ravi.myattendance;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by Ravi on 23-Nov-17.
 */

public class EditMonday extends Fragment {
    Button bmon,btue,bwed,bthu,bfri,bsat,bsun,buttonOk;
    EditText mons1,mons2,mons3,mons4,mons5,mons6,mons7;
    String msub1,msub2,msub3,msub4,msub5,msub6,msub7;
    Fragment fragment=null;
    SessionManager sessionManager;
    String[] subjectOfMonday;
    int count=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){

        View view=inflater.inflate(R.layout.monday,viewGroup,false);

        sessionManager=new SessionManager(getActivity());
        subjectOfMonday=new String[7];
        final int sizeof=sessionManager.getSize();
        final String[] totalSubjects=sessionManager.loadArray("mySubject");

        bmon=(Button)view.findViewById(R.id.bmon);
        btue=(Button)view.findViewById(R.id.btue);
        bwed=(Button)view.findViewById(R.id.bwed);
        bthu=(Button)view.findViewById(R.id.bthu);
        bfri=(Button)view.findViewById(R.id.bfri);
        bsat=(Button)view.findViewById(R.id.bsat);
        bsun=(Button)view.findViewById(R.id.bsun);
        buttonOk=(Button)view.findViewById(R.id.buttonOk);

        mons1=(EditText)view.findViewById(R.id.mons1);
        mons2=(EditText)view.findViewById(R.id.mons2);
        mons3=(EditText)view.findViewById(R.id.mons3);
        mons4=(EditText)view.findViewById(R.id.mons4);
        mons5=(EditText)view.findViewById(R.id.mons5);
        mons6=(EditText)view.findViewById(R.id.mons6);
        mons7=(EditText)view.findViewById(R.id.mons7);

        if(sessionManager.isLoggedIn())
        {
            count=sessionManager.getCountMon();
            HashMap<String ,String> subj=sessionManager.getMonSubjects();
            if(count>=1)
                mons1.setText(subj.get(SessionManager.KEY_MON_SUB_1));
            if(count>=2)
                mons2.setText(subj.get(SessionManager.KEY_MON_SUB_2));
            if(count>=3)
                mons3.setText(subj.get(SessionManager.KEY_MON_SUB_3));
            if(count>=4)
                mons4.setText(subj.get(SessionManager.KEY_MON_SUB_4));
            if(count>=5)
                mons5.setText(subj.get(SessionManager.KEY_MON_SUB_5));
            if(count>=6)
                mons6.setText(subj.get(SessionManager.KEY_MON_SUB_6));
            if(count>=7)
                mons7.setText(subj.get(SessionManager.KEY_MON_SUB_7));
            buttonOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int i,j,pos=0,count=0,flag=0;
                    msub1=mons1.getText().toString();
                    msub2=mons2.getText().toString();
                    msub3=mons3.getText().toString();
                    msub4=mons4.getText().toString();
                    msub5=mons5.getText().toString();
                    msub6=mons6.getText().toString();
                    msub7=mons7.getText().toString();

                    subjectOfMonday[0]=msub1;
                    subjectOfMonday[1]=msub2;
                    subjectOfMonday[2]=msub3;
                    subjectOfMonday[3]=msub4;
                    subjectOfMonday[4]=msub5;
                    subjectOfMonday[5]=msub6;
                    subjectOfMonday[6]=msub7;

                    for(i=0;i<7;i++)
                    {
                        flag=0;
                        if(!subjectOfMonday[i].equals(""))
                        {
                            for(j=0;j<sizeof;j++)
                            {
                                if(subjectOfMonday[i].equals(totalSubjects[j]))
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

                    if(!msub1.equals(""))
                        count++;
                    if(!msub2.equals(""))
                        count++;
                    if(!msub3.equals(""))
                        count++;
                    if(!msub4.equals(""))
                        count++;
                    if(!msub5.equals(""))
                        count++;
                    if(!msub6.equals(""))
                        count++;
                    if(!msub7.equals(""))
                        count++;

                    if(flag==1)
                    {
                        new SessionManager(getContext()).monSubjects(msub1,msub2,msub3,msub4,msub5,msub6,msub7);
                        new SessionManager(getContext()).setCountMon(count);

                        fragment = new EditTuesday();
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
        }
        else
            Toast.makeText(getActivity(), "Subjects not entered yet", Toast.LENGTH_SHORT).show();


        return view;
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        getActivity().setTitle("Edit Monday");
    }
}
