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

/**
 * Created by Ravi on 04-Oct-17.
 */

public class Thursday extends Fragment {
    Button bmon,btue,bwed,bthu,bfri,bsat,bsun,buttonOkthu;
    EditText thus1,thus2,thus3,thus4,thus5,thus6,thus7;
    String thusub1,thusub2,thusub3,thusub4,thusub5,thusub6,thusub7;
    Fragment fragment=null;
    SessionManager sessionManager;
    String[] subjectOfThursday;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){

        View view=inflater.inflate(R.layout.thursday,viewGroup,false);

        sessionManager=new SessionManager(getActivity());
        subjectOfThursday=new String[7];
        final int sizeof=sessionManager.getSize();
        final String[] totalSubjects=sessionManager.loadArray("mySubject");

        bmon=(Button)view.findViewById(R.id.bmon);
        btue=(Button)view.findViewById(R.id.btue);
        bwed=(Button)view.findViewById(R.id.bwed);
        bthu=(Button)view.findViewById(R.id.bthu);
        bfri=(Button)view.findViewById(R.id.bfri);
        bsat=(Button)view.findViewById(R.id.bsat);
        bsun=(Button)view.findViewById(R.id.bsun);
        buttonOkthu=(Button)view.findViewById(R.id.buttonOkthu);

        thus1=(EditText)view.findViewById(R.id.thus1);
        thus2=(EditText)view.findViewById(R.id.thus2);
        thus3=(EditText)view.findViewById(R.id.thus3);
        thus4=(EditText)view.findViewById(R.id.thus4);
        thus5=(EditText)view.findViewById(R.id.thus5);
        thus6=(EditText)view.findViewById(R.id.thus6);
        thus7=(EditText)view.findViewById(R.id.thus7);

        buttonOkthu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int countThu=0;
                int i,j,pos=0,flag=0;
                thusub1=thus1.getText().toString();
                thusub2=thus2.getText().toString();
                thusub3=thus3.getText().toString();
                thusub4=thus4.getText().toString();
                thusub5=thus5.getText().toString();
                thusub6=thus6.getText().toString();
                thusub7=thus7.getText().toString();

                subjectOfThursday[0]=thusub1;
                subjectOfThursday[1]=thusub2;
                subjectOfThursday[2]=thusub3;
                subjectOfThursday[3]=thusub4;
                subjectOfThursday[4]=thusub5;
                subjectOfThursday[5]=thusub6;
                subjectOfThursday[6]=thusub7;

                for(i=0;i<7;i++)
                {
                    flag=0;
                    if(!subjectOfThursday[i].equals(""))
                    {
                        for(j=0;j<sizeof;j++)
                        {
                            if(subjectOfThursday[i].equals(totalSubjects[j]))
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

                if(!thusub1.equals(""))
                    countThu++;
                if(!thusub2.equals(""))
                    countThu++;
                if(!thusub3.equals(""))
                    countThu++;
                if(!thusub4.equals(""))
                    countThu++;
                if(!thusub5.equals(""))
                    countThu++;
                if(!thusub6.equals(""))
                    countThu++;
                if(!thusub7.equals(""))
                    countThu++;

                if(flag==1)
                {
                    new SessionManager(getContext()).thuSubjects(thusub1,thusub2,thusub3,thusub4,thusub5,thusub6,thusub7);
                    new SessionManager(getContext()).setCountThu(countThu);

                    fragment = new Friday();
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
