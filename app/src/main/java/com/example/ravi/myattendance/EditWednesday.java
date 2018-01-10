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

public class EditWednesday extends Fragment {
    Button bmon,btue,bwed,bthu,bfri,bsat,bsun,buttonOkwed;
    EditText weds1,weds2,weds3,weds4,weds5,weds6,weds7;
    String wedsub1,wedsub2,wedsub3,wedsub4,wedsub5,wedsub6,wedsub7;
    Fragment fragment=null;
    SessionManager sessionManager;
    String[] subjectOfWednesday;
    int count=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){

        View view=inflater.inflate(R.layout.wednesday,viewGroup,false);

        sessionManager=new SessionManager(getActivity());
        subjectOfWednesday=new String[7];
        final int sizeof=sessionManager.getSize();
        final String[] totalSubjects=sessionManager.loadArray("mySubject");

        bmon=(Button)view.findViewById(R.id.bmon);
        btue=(Button)view.findViewById(R.id.btue);
        bwed=(Button)view.findViewById(R.id.bwed);
        bthu=(Button)view.findViewById(R.id.bthu);
        bfri=(Button)view.findViewById(R.id.bfri);
        bsat=(Button)view.findViewById(R.id.bsat);
        bsun=(Button)view.findViewById(R.id.bsun);
        buttonOkwed=(Button)view.findViewById(R.id.buttonOkwed) ;

        weds1=(EditText)view.findViewById(R.id.weds1);
        weds2=(EditText)view.findViewById(R.id.weds2);
        weds3=(EditText)view.findViewById(R.id.weds3);
        weds4=(EditText)view.findViewById(R.id.weds4);
        weds5=(EditText)view.findViewById(R.id.weds5);
        weds6=(EditText)view.findViewById(R.id.weds6);
        weds7=(EditText)view.findViewById(R.id.weds7);

        if(sessionManager.isLoggedIn())
        {
            count=sessionManager.getCountWed();
            HashMap<String ,String> subwed=sessionManager.getWedSubjects();
            if(count>=1)
                weds1.setText(subwed.get(SessionManager.KEY_WED_SUB_1));
            if(count>=2)
                weds2.setText(subwed.get(SessionManager.KEY_WED_SUB_2));
            if(count>=3)
                weds3.setText(subwed.get(SessionManager.KEY_WED_SUB_3));
            if(count>=4)
                weds4.setText(subwed.get(SessionManager.KEY_WED_SUB_4));
            if(count>=5)
                weds5.setText(subwed.get(SessionManager.KEY_WED_SUB_5));
            if(count>=6)
                weds6.setText(subwed.get(SessionManager.KEY_WED_SUB_6));
            if(count>=7)
                weds7.setText(subwed.get(SessionManager.KEY_WED_SUB_7));
            buttonOkwed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int countWed=0;
                    int i,j,pos=0,flag=0;
                    wedsub1=weds1.getText().toString();
                    wedsub2=weds2.getText().toString();
                    wedsub3=weds3.getText().toString();
                    wedsub4=weds4.getText().toString();
                    wedsub5=weds5.getText().toString();
                    wedsub6=weds6.getText().toString();
                    wedsub7=weds7.getText().toString();

                    subjectOfWednesday[0]=wedsub1;
                    subjectOfWednesday[1]=wedsub2;
                    subjectOfWednesday[2]=wedsub3;
                    subjectOfWednesday[3]=wedsub4;
                    subjectOfWednesday[4]=wedsub5;
                    subjectOfWednesday[5]=wedsub6;
                    subjectOfWednesday[6]=wedsub7;

                    for(i=0;i<7;i++)
                    {
                        flag=0;
                        if(!subjectOfWednesday[i].equals(""))
                        {
                            for(j=0;j<sizeof;j++)
                            {
                                if(subjectOfWednesday[i].equals(totalSubjects[j]))
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

                    if(!wedsub1.equals(""))
                        countWed++;
                    if(!wedsub2.equals(""))
                        countWed++;
                    if(!wedsub3.equals(""))
                        countWed++;
                    if(!wedsub4.equals(""))
                        countWed++;
                    if(!wedsub5.equals(""))
                        countWed++;
                    if(!wedsub6.equals(""))
                        countWed++;
                    if(!wedsub7.equals(""))
                        countWed++;

                    if(flag==1)
                    {
                        new SessionManager(getContext()).wedSubjects(wedsub1,wedsub2,wedsub3,wedsub4,wedsub5,wedsub6,wedsub7);
                        new SessionManager(getContext()).setCountWed(countWed);

                        fragment = new EditThursday();
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
        getActivity().setTitle("Edit Wednesday");
    }
}
