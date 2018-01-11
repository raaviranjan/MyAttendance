package com.example.ravi.myattendance;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by Ravi on 11-Jan-18.
 */

public class EditMon extends Fragment {
    Button bmon,btue,bwed,bthu,bfri,bsat,bsun,buttonOk;
    EditText mons1,mons2,mons3,mons4,mons5,mons6,mons7;
    ImageButton IBd1,IBd2,IBd3,IBd4,IBd5,IBd6,IBd7;
    Fragment fragment=null;
    SessionManager sessionManager;
    int sizeof,count=0;
    String[] totalSubjects;
    String[] exactSub;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.mon, viewGroup, false);
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

        mons1=(EditText)view.findViewById(R.id.mons1);
        mons2=(EditText)view.findViewById(R.id.mons2);
        mons3=(EditText)view.findViewById(R.id.mons3);
        mons4=(EditText)view.findViewById(R.id.mons4);
        mons5=(EditText)view.findViewById(R.id.mons5);
        mons6=(EditText)view.findViewById(R.id.mons6);
        mons7=(EditText)view.findViewById(R.id.mons7);

        IBd1=(ImageButton)view.findViewById(R.id.IBd1);
        IBd2=(ImageButton)view.findViewById(R.id.IBd2);
        IBd3=(ImageButton)view.findViewById(R.id.IBd3);
        IBd4=(ImageButton)view.findViewById(R.id.IBd4);
        IBd5=(ImageButton)view.findViewById(R.id.IBd5);
        IBd6=(ImageButton)view.findViewById(R.id.IBd6);
        IBd7=(ImageButton)view.findViewById(R.id.IBd7);

        IBd1.setVisibility(View.GONE);
        IBd2.setVisibility(View.GONE);
        IBd3.setVisibility(View.GONE);
        IBd4.setVisibility(View.GONE);
        IBd5.setVisibility(View.GONE);
        IBd6.setVisibility(View.GONE);
        IBd7.setVisibility(View.GONE);

        mons1.setVisibility(View.GONE);
        mons2.setVisibility(View.GONE);
        mons3.setVisibility(View.GONE);
        mons4.setVisibility(View.GONE);
        mons5.setVisibility(View.GONE);
        mons6.setVisibility(View.GONE);
        mons7.setVisibility(View.GONE);

        bsun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Make your selection");
                builder.setItems(exactSub, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        // Do something with the selection
                        count++;
                        if(count==1)
                        {
                            mons1.setVisibility(View.VISIBLE);
                            mons1.setText(exactSub[item]);
                        }
                        else if(count==2)
                        {
                            mons2.setVisibility(View.VISIBLE);
                            mons2.setText(exactSub[item]);
                        }
                        else if(count==3)
                        {
                            mons3.setVisibility(View.VISIBLE);
                            mons3.setText(exactSub[item]);
                        }
                        else if(count==4)
                        {
                            mons4.setVisibility(View.VISIBLE);
                            mons4.setText(exactSub[item]);
                        }
                        else if(count==5)
                        {
                            mons5.setVisibility(View.VISIBLE);
                            mons5.setText(exactSub[item]);
                        }
                        else if(count==6)
                        {
                            mons6.setVisibility(View.VISIBLE);
                            mons6.setText(exactSub[item]);
                        }
                        else if(count==7)
                        {
                            mons7.setVisibility(View.VISIBLE);
                            mons7.setText(exactSub[item]);
                        }
                        Toast.makeText(getActivity(), exactSub[item], Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        return view;
    }
}
