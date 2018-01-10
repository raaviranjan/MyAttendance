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

public class EditFriday extends Fragment {
    Button bmon,btue,bwed,bthu,bfri,bsat,bsun,buttonOkfri,buttonNo;
    EditText fris1,fris2,fris3,fris4,fris5,fris6,fris7;
    String frisub1,frisub2,frisub3,frisub4,frisub5,frisub6,frisub7;
    Fragment fragment=null;
    SessionManager sessionManager;
    String[] subjectOfFriday;
    int sizeof;
    String[] totalSubjects;
    int count=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){

        View view=inflater.inflate(R.layout.friday,viewGroup,false);

        sessionManager=new SessionManager(getActivity());
        subjectOfFriday=new String[7];
        sizeof=sessionManager.getSize();
        totalSubjects=sessionManager.loadArray("mySubject");

        bmon=(Button)view.findViewById(R.id.bmon);
        btue=(Button)view.findViewById(R.id.btue);
        bwed=(Button)view.findViewById(R.id.bwed);
        bthu=(Button)view.findViewById(R.id.bthu);
        bfri=(Button)view.findViewById(R.id.bfri);
        bsat=(Button)view.findViewById(R.id.bsat);
        bsun=(Button)view.findViewById(R.id.bsun);
        buttonOkfri=(Button)view.findViewById(R.id.buttonOkfri);
        buttonNo=(Button)view.findViewById(R.id.bNo);

        fris1=(EditText)view.findViewById(R.id.fris1);
        fris2=(EditText)view.findViewById(R.id.fris2);
        fris3=(EditText)view.findViewById(R.id.fris3);
        fris4=(EditText)view.findViewById(R.id.fris4);
        fris5=(EditText)view.findViewById(R.id.fris5);
        fris6=(EditText)view.findViewById(R.id.fris6);
        fris7=(EditText)view.findViewById(R.id.fris7);

        if(sessionManager.isLoggedIn())
        {
            count=sessionManager.getCountFri();
            HashMap<String ,String> subfri=sessionManager.getFriSubjects();
            if(count>=1)
                fris1.setText(subfri.get(SessionManager.KEY_FRI_SUB_1));
            if(count>=2)
                fris2.setText(subfri.get(SessionManager.KEY_FRI_SUB_2));
            if(count>=3)
                fris3.setText(subfri.get(SessionManager.KEY_FRI_SUB_3));
            if(count>=4)
                fris4.setText(subfri.get(SessionManager.KEY_FRI_SUB_4));
            if(count>=5)
                fris5.setText(subfri.get(SessionManager.KEY_FRI_SUB_5));
            if(count>=6)
                fris6.setText(subfri.get(SessionManager.KEY_FRI_SUB_6));
            if(count>=7)
                fris7.setText(subfri.get(SessionManager.KEY_FRI_SUB_7));
            buttonOkfri.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int abc=save();

                    if(abc==1)
                    {
                        fragment = new EditSaturday();
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.content_frame, fragment);
                        ft.commit();
                    }

                }
            });

            buttonNo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int abc=save();

                    if(abc==1)
                    {
                        fragment = new Main();
                        FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.content_frame, fragment);
                        ft.commit();
                    }
                }
            });
            bmon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(), "Kindly press YES to go to next day or NO to proceed", Toast.LENGTH_SHORT).show();
                }
            });
            btue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(), "Kindly press YES to go to next day or NO to proceed", Toast.LENGTH_SHORT).show();
                }
            });
            bwed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(), "Kindly press YES to go to next day or NO to proceed", Toast.LENGTH_SHORT).show();
                }
            });
            bthu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(), "Kindly press YES to go to next day or NO to proceed", Toast.LENGTH_SHORT).show();
                }
            });
            bfri.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(), "Kindly press YES to go to next day or NO to proceed", Toast.LENGTH_SHORT).show();
                }
            });
            bsat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(), "Kindly press YES to go to next day or NO to proceed", Toast.LENGTH_SHORT).show();
                }
            });
            bsun.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(), "Kindly press YES to go to next day or NO to proceed", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else
            Toast.makeText(getActivity(), "Subjects not entered yet", Toast.LENGTH_SHORT).show();


        return view;
    }
    public int save(){
        int countFri=0;
        int i,j,pos=0,flag=0;
        frisub1=fris1.getText().toString();
        frisub2=fris2.getText().toString();
        frisub3=fris3.getText().toString();
        frisub4=fris4.getText().toString();
        frisub5=fris5.getText().toString();
        frisub6=fris6.getText().toString();
        frisub7=fris7.getText().toString();

        subjectOfFriday[0]=frisub1;
        subjectOfFriday[1]=frisub2;
        subjectOfFriday[2]=frisub3;
        subjectOfFriday[3]=frisub4;
        subjectOfFriday[4]=frisub5;
        subjectOfFriday[5]=frisub6;
        subjectOfFriday[6]=frisub7;

        for(i=0;i<7;i++)
        {
            flag=0;
            if(!subjectOfFriday[i].equals(""))
            {
                for(j=0;j<sizeof;j++)
                {
                    if(subjectOfFriday[i].equals(totalSubjects[j]))
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

        if(!frisub1.equals(""))
            countFri++;
        if(!frisub2.equals(""))
            countFri++;
        if(!frisub3.equals(""))
            countFri++;
        if(!frisub4.equals(""))
            countFri++;
        if(!frisub5.equals(""))
            countFri++;
        if(!frisub6.equals(""))
            countFri++;
        if(!frisub7.equals(""))
            countFri++;

        if(flag==1)
        {
            new SessionManager(getContext()).friSubjects(frisub1,frisub2,frisub3,frisub4,frisub5,frisub6,frisub7);
            new SessionManager(getContext()).setCountFri(countFri);
        }
        else
        {
            Toast.makeText(getActivity(), "Subject "+pos+" doesn't match with entered subjects", Toast.LENGTH_LONG).show();
        }
        return flag;
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        getActivity().setTitle("Edit Friday");
    }
}
