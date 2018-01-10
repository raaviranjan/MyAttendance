package com.example.ravi.myattendance;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ravi on 23-Nov-17.
 */

public class EditSubjects extends Fragment {
    Button buttonDone;
    Fragment fragment=null;
    LinearLayout linearLayout;
    EditText ed1;
    List<EditText> allEds;
    String[] data;
    String s1;
    String[] totalSubjects;
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

        if(sessionManager.isLoggedIn())
        {
            totalEditTexts=sessionManager.getSize()-1;
            totalSubjects=sessionManager.loadArray("mySubject");
            ed1.setText(totalSubjects[0]);
            if(totalEditTexts>=1)
            {
                addEditText(totalSubjects[1]);
            }
            if(totalEditTexts>=2)
            {
                addEditText(totalSubjects[2]);
            }
            if(totalEditTexts>=3)
            {
                addEditText(totalSubjects[3]);
            }
            if(totalEditTexts>=4)
            {
                addEditText(totalSubjects[4]);
            }
            if(totalEditTexts>=5)
            {
                addEditText(totalSubjects[5]);
            }
            if(totalEditTexts>=6)
            {
                addEditText(totalSubjects[6]);
            }
            if(totalEditTexts>=7)
            {
                addEditText(totalSubjects[7]);
            }
            totalEditTexts++;
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
                    Toast.makeText(getActivity(), "Edit schedule accordingly", Toast.LENGTH_SHORT).show();
                    sessionManager.setSize(count);
                    sessionManager.allSubjects(data,"mySubject");
                    fragment = new Monday();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.content_frame, fragment);
                    ft.commit();
                }
            });
        }
        else
            Toast.makeText(getActivity(), "Subjects not entered yet", Toast.LENGTH_SHORT).show();
        return view;
    }
    public void addEditText(String str)
    {
        EditText editText=new EditText(getActivity());
        linearLayout.addView(editText);
        editText.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams layoutParams=(LinearLayout.LayoutParams)editText.getLayoutParams();
        layoutParams.width=LinearLayout.LayoutParams.MATCH_PARENT;
        editText.setLayoutParams(layoutParams);
        editText.setText(str);
        editText.setTextColor(Color.parseColor("#FFFFFF"));
        allEds.add(editText);
    }
    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        getActivity().setTitle("Edit Subjects");
    }
}
