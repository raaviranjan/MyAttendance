package com.example.ravi.myattendance;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ravi on 11-Jan-18.
 */

public class EditMon extends Fragment {
    Button bmon,btue,bwed,bthu,bfri,bsat,bsun,buttonOk;
    TextView mons1,mons2,mons3,mons4,mons5,mons6,mons7;
    ImageButton IBd1,IBd2,IBd3,IBd4,IBd5,IBd6,IBd7,IBAddSub;
    Fragment fragment=null;
    SessionManager sessionManager;
    int sizeof,count;
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

        mons1=(TextView) view.findViewById(R.id.mons1);
        mons2=(TextView) view.findViewById(R.id.mons2);
        mons3=(TextView) view.findViewById(R.id.mons3);
        mons4=(TextView) view.findViewById(R.id.mons4);
        mons5=(TextView) view.findViewById(R.id.mons5);
        mons6=(TextView) view.findViewById(R.id.mons6);
        mons7=(TextView) view.findViewById(R.id.mons7);

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
                builder.setTitle("Make your selection");
                builder.setItems(exactSub, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        // Do something with the selection
                        //count++;
                        if(mons1.getText().equals(""))
                        {
                            IBd1.setVisibility(View.VISIBLE);
                            mons1.setText(exactSub[item]);
                        }
                        else if(mons2.getText().equals(""))
                        {
                            IBd2.setVisibility(View.VISIBLE);
                            mons2.setText(exactSub[item]);
                        }
                        else if(mons3.getText().equals(""))
                        {
                            IBd3.setVisibility(View.VISIBLE);
                            mons3.setText(exactSub[item]);
                        }
                        else if(mons4.getText().equals(""))
                        {
                            IBd4.setVisibility(View.VISIBLE);
                            mons4.setText(exactSub[item]);
                        }
                        else if(mons5.getText().equals(""))
                        {
                            IBd5.setVisibility(View.VISIBLE);
                            mons5.setText(exactSub[item]);
                        }
                        else if(mons6.getText().equals(""))
                        {
                            IBd6.setVisibility(View.VISIBLE);
                            mons6.setText(exactSub[item]);
                        }
                        else if(mons7.getText().equals(""))
                        {
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
                mons1.setText("");
                IBd1.setVisibility(View.GONE);
            }
        });
        IBd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mons2.setText("");
                IBd2.setVisibility(View.GONE);
            }
        });
        IBd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mons3.setText("");
                IBd3.setVisibility(View.GONE);
            }
        });
        IBd4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mons4.setText("");
                IBd4.setVisibility(View.GONE);
            }
        });
        IBd5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mons5.setText("");
                IBd5.setVisibility(View.GONE);
            }
        });
        IBd6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mons6.setText("");
                IBd6.setVisibility(View.GONE);
            }
        });
        IBd7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mons7.setText("");
                IBd7.setVisibility(View.GONE);
            }
        });

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count=0;
                if(!mons1.getText().toString().equals(""))
                    count++;
                if(!mons2.getText().toString().equals(""))
                    count++;
                if(!mons3.getText().toString().equals(""))
                    count++;
                if(!mons4.getText().toString().equals(""))
                    count++;
                if(!mons5.getText().toString().equals(""))
                    count++;
                if(!mons6.getText().toString().equals(""))
                    count++;
                if(!mons7.getText().toString().equals(""))
                    count++;
                String as=String.valueOf(count);
                Toast.makeText(getActivity(), as, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
