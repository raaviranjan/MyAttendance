package com.example.ravi.myattendance;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ravi on 03-Oct-17.
 */

public class Subjects extends Fragment {
    Button buttonDone;
    //EditText e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13;
    //String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13;
    Fragment fragment=null;
    LinearLayout linearLayout;
    EditText ed1;
    List<EditText> allEds;
    String[] data;
    String s1;
    static int totalEditTexts = 1;
    SessionManager sessionManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){

        View view= inflater.inflate(R.layout.subjects,viewGroup,false);

        linearLayout=(LinearLayout)view.findViewById(R.id.mLayout);
        buttonDone=(Button)view.findViewById(R.id.buttonDone);
        ImageButton plus = (ImageButton) view.findViewById(R.id.plus);
        ed1=(EditText)view.findViewById(R.id.ed1);
        sessionManager=new SessionManager(getActivity());

        allEds = new ArrayList<EditText>();
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalEditTexts++;
                if(totalEditTexts>20)
                    return;
                EditText editText=new EditText(getActivity());
                linearLayout.addView(editText);
                editText.setGravity(Gravity.CENTER);
                LinearLayout.LayoutParams layoutParams=(LinearLayout.LayoutParams)editText.getLayoutParams();
                layoutParams.width=LinearLayout.LayoutParams.MATCH_PARENT;
                editText.setLayoutParams(layoutParams);
                editText.setId(totalEditTexts);
                editText.setHint("Subject " + totalEditTexts);
                editText.setTextColor(Color.parseColor("#FFFFFF"));
                allEds.add(editText);

            }
        });

        data=new String[20];
        for(int j=0;j<20;j++)
            data[j]="";

        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                s1=ed1.getText().toString();
                if(s1.equals(""))
                    Toast.makeText(getActivity(), "Enter all subject", Toast.LENGTH_SHORT).show();
                else
                {
                    data[0]=s1;
                    int count=0;
                    for(int i=1; i <=allEds.size(); i++){
                        data[i] = allEds.get(i-1).getText().toString();
                    }
                    for(int k=0;k<20;k++){
                        if(!data[k].equals(""))
                            count++;
                        else
                            break;
                    }
                    //Toast.makeText(getActivity(), count+" "+data[0]+data[1]+data[2], Toast.LENGTH_SHORT).show();
                    sessionManager.setSize(count);
                    sessionManager.allSubjects(data,"mySubject");
                    fragment = new Monday();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.content_frame, fragment);
                    ft.commit();
                }

            }
        });
        return view;
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        getActivity().setTitle("Subjects");
    }
}
