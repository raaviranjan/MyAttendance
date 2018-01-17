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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Ravi on 08-Nov-17.
 */

public class PreAttendance extends Fragment {
    Button buttonGo,buttonMore;
    TextView tvSub1,tvSub2,tvSub3,tvSub4,tvSub5,tvSub6,tvSub7,tvSub8,tvSub9,tvSub10,tvSub11,tvSub12,tvSub13,tvSub14,tvSub15,tvSub16,tvSub17,tvSub18,tvSub19,tvSub20;
    EditText etPresentSub1,etPresentSub2,etPresentSub3,etPresentSub4,etPresentSub5,etPresentSub6,etPresentSub7,etPresentSub8,etPresentSub9,etPresentSub10
            ,etPresentSub11,etPresentSub12,etPresentSub13,etPresentSub14,etPresentSub15,etPresentSub16,etPresentSub17,etPresentSub18,etPresentSub19,etPresentSub20;
    EditText etTotalSub1,etTotalSub2,etTotalSub3,etTotalSub4,etTotalSub5,etTotalSub6,etTotalSub7,etTotalSub8,etTotalSub9,etTotalSub10,etTotalSub11
            ,etTotalSub12,etTotalSub13,etTotalSub14,etTotalSub15,etTotalSub16,etTotalSub17,etTotalSub18,etTotalSub19,etTotalSub20;
    LinearLayout a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,rr,s,t;
    int count=1;
    int totalSub;
    String[] exactTotalSub;
    String[] tempAttended;
    String[] tempTotal;
    Integer[] attended;
    Integer[] total;
    SessionManager sessionManager;
    Calendar calendar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.pre_attendance, viewGroup, false);
        buttonGo=(Button)view.findViewById(R.id.buttonGo);
        buttonMore=(Button)view.findViewById(R.id.buttonMore);

        etPresentSub1=(EditText)view.findViewById(R.id.etPresentSub1);
        etPresentSub2=(EditText)view.findViewById(R.id.etPresentSub2);
        etPresentSub3=(EditText)view.findViewById(R.id.etPresentSub3);
        etPresentSub4=(EditText)view.findViewById(R.id.etPresentSub4);
        etPresentSub5=(EditText)view.findViewById(R.id.etPresentSub5);
        etPresentSub6=(EditText)view.findViewById(R.id.etPresentSub6);
        etPresentSub7=(EditText)view.findViewById(R.id.etPresentSub7);
        etPresentSub8=(EditText)view.findViewById(R.id.etPresentSub8);
        etPresentSub9=(EditText)view.findViewById(R.id.etPresentSub9);
        etPresentSub10=(EditText)view.findViewById(R.id.etPresentSub10);
        etPresentSub11=(EditText)view.findViewById(R.id.etPresentSub11);
        etPresentSub12=(EditText)view.findViewById(R.id.etPresentSub12);
        etPresentSub13=(EditText)view.findViewById(R.id.etPresentSub13);
        etPresentSub14=(EditText)view.findViewById(R.id.etPresentSub14);
        etPresentSub15=(EditText)view.findViewById(R.id.etPresentSub15);
        etPresentSub16=(EditText)view.findViewById(R.id.etPresentSub16);
        etPresentSub17=(EditText)view.findViewById(R.id.etPresentSub17);
        etPresentSub18=(EditText)view.findViewById(R.id.etPresentSub18);
        etPresentSub19=(EditText)view.findViewById(R.id.etPresentSub19);
        etPresentSub20=(EditText)view.findViewById(R.id.etPresentSub20);


        etTotalSub1=(EditText)view.findViewById(R.id.etTotalSub1);
        etTotalSub2=(EditText)view.findViewById(R.id.etTotalSub2);
        etTotalSub3=(EditText)view.findViewById(R.id.etTotalSub3);
        etTotalSub4=(EditText)view.findViewById(R.id.etTotalSub4);
        etTotalSub5=(EditText)view.findViewById(R.id.etTotalSub5);
        etTotalSub6=(EditText)view.findViewById(R.id.etTotalSub6);
        etTotalSub7=(EditText)view.findViewById(R.id.etTotalSub7);
        etTotalSub8=(EditText)view.findViewById(R.id.etTotalSub8);
        etTotalSub9=(EditText)view.findViewById(R.id.etTotalSub9);
        etTotalSub10=(EditText)view.findViewById(R.id.etTotalSub10);
        etTotalSub11=(EditText)view.findViewById(R.id.etTotalSub11);
        etTotalSub12=(EditText)view.findViewById(R.id.etTotalSub12);
        etTotalSub13=(EditText)view.findViewById(R.id.etTotalSub13);
        etTotalSub14=(EditText)view.findViewById(R.id.etTotalSub14);
        etTotalSub15=(EditText)view.findViewById(R.id.etTotalSub15);
        etTotalSub16=(EditText)view.findViewById(R.id.etTotalSub16);
        etTotalSub17=(EditText)view.findViewById(R.id.etTotalSub17);
        etTotalSub18=(EditText)view.findViewById(R.id.etTotalSub18);
        etTotalSub19=(EditText)view.findViewById(R.id.etTotalSub19);
        etTotalSub20=(EditText)view.findViewById(R.id.etTotalSub20);

        tvSub1=(TextView)view.findViewById(R.id.tvSub1);
        tvSub2=(TextView)view.findViewById(R.id.tvSub2);
        tvSub3=(TextView)view.findViewById(R.id.tvSub3);
        tvSub4=(TextView)view.findViewById(R.id.tvSub4);
        tvSub5=(TextView)view.findViewById(R.id.tvSub5);
        tvSub6=(TextView)view.findViewById(R.id.tvSub6);
        tvSub7=(TextView)view.findViewById(R.id.tvSub7);
        tvSub8=(TextView)view.findViewById(R.id.tvSub8);
        tvSub9=(TextView)view.findViewById(R.id.tvSub9);
        tvSub10=(TextView)view.findViewById(R.id.tvSub10);
        tvSub11=(TextView)view.findViewById(R.id.tvSub11);
        tvSub12=(TextView)view.findViewById(R.id.tvSub12);
        tvSub13=(TextView)view.findViewById(R.id.tvSub13);
        tvSub14=(TextView)view.findViewById(R.id.tvSub14);
        tvSub15=(TextView)view.findViewById(R.id.tvSub15);
        tvSub16=(TextView)view.findViewById(R.id.tvSub16);
        tvSub17=(TextView)view.findViewById(R.id.tvSub17);
        tvSub18=(TextView)view.findViewById(R.id.tvSub18);
        tvSub19=(TextView)view.findViewById(R.id.tvSub19);
        tvSub20=(TextView)view.findViewById(R.id.tvSub20);

        a=(LinearLayout)view.findViewById(R.id.linearLayout1);
        b=(LinearLayout)view.findViewById(R.id.linearLayout2);
        c=(LinearLayout)view.findViewById(R.id.linearLayout3);
        d=(LinearLayout)view.findViewById(R.id.linearLayout4);
        e=(LinearLayout)view.findViewById(R.id.linearLayout5);
        f=(LinearLayout)view.findViewById(R.id.linearLayout6);
        g=(LinearLayout)view.findViewById(R.id.linearLayout7);
        h=(LinearLayout)view.findViewById(R.id.linearLayout8);
        i=(LinearLayout)view.findViewById(R.id.linearLayout9);
        j=(LinearLayout)view.findViewById(R.id.linearLayout10);
        k=(LinearLayout)view.findViewById(R.id.linearLayout11);
        l=(LinearLayout)view.findViewById(R.id.linearLayout12);
        m=(LinearLayout)view.findViewById(R.id.linearLayout13);
        n=(LinearLayout)view.findViewById(R.id.linearLayout14);
        o=(LinearLayout)view.findViewById(R.id.linearLayout15);
        p=(LinearLayout)view.findViewById(R.id.linearLayout16);
        q=(LinearLayout)view.findViewById(R.id.linearLayout17);
        rr=(LinearLayout)view.findViewById(R.id.linearLayout18);
        s=(LinearLayout)view.findViewById(R.id.linearLayout19);
        t=(LinearLayout)view.findViewById(R.id.linearLayout20);

        //calendar=Calendar.getInstance();

        sessionManager=new SessionManager(getActivity());
        totalSub=sessionManager.getSize();
        String[] totalSubjects=sessionManager.loadArray("mySubject");
        exactTotalSub=new String[totalSub];
        for(int z=0;z<totalSub;z++){
            exactTotalSub[z]=totalSubjects[z];
        }
        //attended=new Integer[totalSub];
        //total=new Integer[totalSub];
        attended=new Integer[20];
        total=new Integer[20];
        tempAttended=new String[20];
        tempTotal=new String[20];

        for(int i=0;i<20;i++)
        {
            attended[i]=0;
            total[i]=0;
        }

        tvSub1.setText(exactTotalSub[0]);

        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getValueOfEditText();
            }
        });
        buttonMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkView();
            }
        });




        return view;
    }
    public void checkView(){
        count++;
        if(count==2)
        {
            if(count<=totalSub)
            {
                b.setVisibility(View.VISIBLE);
                tvSub2.setText(exactTotalSub[1]);
            }
            else
            {
                Toast.makeText(getActivity(), "No more subjects. Press DONE", Toast.LENGTH_SHORT).show();
                count--;
            }
        }
        else if(count==3)
        {
            if(count<=totalSub)
            {
                c.setVisibility(View.VISIBLE);
                tvSub3.setText(exactTotalSub[2]);
            }
            else
            {
                Toast.makeText(getActivity(), "No more subjects. Press DONE", Toast.LENGTH_SHORT).show();
                count--;
            }
        }
        else if(count==4)
        {
            if(count<=totalSub)
            {
                d.setVisibility(View.VISIBLE);
                tvSub4.setText(exactTotalSub[3]);
            }
            else
            {
                Toast.makeText(getActivity(), "No more subjects. Press DONE", Toast.LENGTH_SHORT).show();
                count--;
            }
        }
        else if(count==5)
        {
            if(count<=totalSub)
            {
                e.setVisibility(View.VISIBLE);
                tvSub5.setText(exactTotalSub[4]);
            }
            else
            {
                Toast.makeText(getActivity(), "No more subjects. Press DONE", Toast.LENGTH_SHORT).show();
                count--;
            }
        }
        else if(count==6)
        {
            if(count<=totalSub)
            {
                f.setVisibility(View.VISIBLE);
                tvSub6.setText(exactTotalSub[5]);
            }
            else
            {
                Toast.makeText(getActivity(), "No more subjects. Press DONE", Toast.LENGTH_SHORT).show();
                count--;
            }
        }
        else if(count==7)
        {
            if(count<=totalSub)
            {
                g.setVisibility(View.VISIBLE);
                tvSub7.setText(exactTotalSub[6]);
            }
            else
            {
                Toast.makeText(getActivity(), "No more subjects. Press DONE", Toast.LENGTH_SHORT).show();
                count--;
            }
        }
        else if(count==8)
        {
            if(count<=totalSub)
            {
                h.setVisibility(View.VISIBLE);
                tvSub8.setText(exactTotalSub[7]);
            }
            else
            {
                Toast.makeText(getActivity(), "No more subjects. Press DONE", Toast.LENGTH_SHORT).show();
                count--;
            }
        }
        else if(count==9)
        {
            if(count<=totalSub)
            {
                i.setVisibility(View.VISIBLE);
                tvSub9.setText(exactTotalSub[8]);
            }
            else
            {
                Toast.makeText(getActivity(), "No more subjects. Press DONE", Toast.LENGTH_SHORT).show();
                count--;
            }
        }
        else if(count==10)
        {
            if(count<=totalSub)
            {
                j.setVisibility(View.VISIBLE);
                tvSub10.setText(exactTotalSub[9]);
            }
            else
            {
                Toast.makeText(getActivity(), "No more subjects. Press DONE", Toast.LENGTH_SHORT).show();
                count--;
            }
        }
        else if(count==11)
        {
            if(count<=totalSub)
            {
                k.setVisibility(View.VISIBLE);
                tvSub11.setText(exactTotalSub[10]);
            }
            else
            {
                Toast.makeText(getActivity(), "No more subjects. Press DONE", Toast.LENGTH_SHORT).show();
                count--;
            }
        }
        else if(count==12)
        {
            if(count<=totalSub)
            {
                l.setVisibility(View.VISIBLE);
                tvSub12.setText(exactTotalSub[11]);
            }
            else
            {
                Toast.makeText(getActivity(), "No more subjects. Press DONE", Toast.LENGTH_SHORT).show();
                count--;
            }
        }
        else if(count==13)
        {
            if(count<=totalSub)
            {
                m.setVisibility(View.VISIBLE);
                tvSub13.setText(exactTotalSub[12]);
            }
            else
            {
                Toast.makeText(getActivity(), "No more subjects. Press DONE", Toast.LENGTH_SHORT).show();
                count--;
            }
        }
        else if(count==14)
        {
            if(count<=totalSub)
            {
                n.setVisibility(View.VISIBLE);
                tvSub14.setText(exactTotalSub[13]);
            }
            else
            {
                Toast.makeText(getActivity(), "No more subjects. Press DONE", Toast.LENGTH_SHORT).show();
                count--;
            }
        }
        else if(count==15)
        {
            if(count<=totalSub)
            {
                o.setVisibility(View.VISIBLE);
                tvSub15.setText(exactTotalSub[14]);
            }
            else
            {
                Toast.makeText(getActivity(), "No more subjects. Press DONE", Toast.LENGTH_SHORT).show();
                count--;
            }
        }
        else if(count==16)
        {
            if(count<=totalSub)
            {
                p.setVisibility(View.VISIBLE);
                tvSub16.setText(exactTotalSub[15]);
            }
            else
            {
                Toast.makeText(getActivity(), "No more subjects. Press DONE", Toast.LENGTH_SHORT).show();
                count--;
            }
        }
        else if(count==17)
        {
            if(count<=totalSub)
            {
                q.setVisibility(View.VISIBLE);
                tvSub17.setText(exactTotalSub[16]);
            }
            else
            {
                Toast.makeText(getActivity(), "No more subjects. Press DONE", Toast.LENGTH_SHORT).show();
                count--;
            }
        }
        else if(count==18)
        {
            if(count<=totalSub)
            {
                rr.setVisibility(View.VISIBLE);
                tvSub18.setText(exactTotalSub[17]);
            }
            else
            {
                Toast.makeText(getActivity(), "No more subjects. Press DONE", Toast.LENGTH_SHORT).show();
                count--;
            }
        }
        else if(count==19)
        {
            if(count<=totalSub)
            {
                s.setVisibility(View.VISIBLE);
                tvSub19.setText(exactTotalSub[18]);
            }
            else
            {
                Toast.makeText(getActivity(), "No more subjects. Press DONE", Toast.LENGTH_SHORT).show();
                count--;
            }
        }
        else if(count==20)
        {
            if(count<=totalSub)
            {
                t.setVisibility(View.VISIBLE);
                tvSub20.setText(exactTotalSub[19]);
            }
            else
            {
                Toast.makeText(getActivity(), "No more subjects. Press DONE", Toast.LENGTH_SHORT).show();
                count--;
            }
        }
    }
    public void getValueOfEditText(){
        int aa,flag=0;

        tempAttended[0]=etPresentSub1.getText().toString();
        tempAttended[1]=etPresentSub2.getText().toString();
        tempAttended[2]=etPresentSub3.getText().toString();
        tempAttended[3]=etPresentSub4.getText().toString();
        tempAttended[4]=etPresentSub5.getText().toString();
        tempAttended[5]=etPresentSub6.getText().toString();
        tempAttended[6]=etPresentSub7.getText().toString();
        tempAttended[7]=etPresentSub8.getText().toString();
        tempAttended[8]=etPresentSub9.getText().toString();
        tempAttended[9]=etPresentSub10.getText().toString();
        tempAttended[10]=etPresentSub11.getText().toString();
        tempAttended[11]=etPresentSub12.getText().toString();
        tempAttended[12]=etPresentSub13.getText().toString();
        tempAttended[13]=etPresentSub14.getText().toString();
        tempAttended[14]=etPresentSub15.getText().toString();
        tempAttended[15]=etPresentSub16.getText().toString();
        tempAttended[16]=etPresentSub17.getText().toString();
        tempAttended[17]=etPresentSub18.getText().toString();
        tempAttended[18]=etPresentSub19.getText().toString();
        tempAttended[19]=etPresentSub20.getText().toString();

        tempTotal[0]=etTotalSub1.getText().toString();
        tempTotal[1]=etTotalSub2.getText().toString();
        tempTotal[2]=etTotalSub3.getText().toString();
        tempTotal[3]=etTotalSub4.getText().toString();
        tempTotal[4]=etTotalSub5.getText().toString();
        tempTotal[5]=etTotalSub6.getText().toString();
        tempTotal[6]=etTotalSub7.getText().toString();
        tempTotal[7]=etTotalSub8.getText().toString();
        tempTotal[8]=etTotalSub9.getText().toString();
        tempTotal[9]=etTotalSub10.getText().toString();
        tempTotal[10]=etTotalSub11.getText().toString();
        tempTotal[11]=etTotalSub12.getText().toString();
        tempTotal[12]=etTotalSub13.getText().toString();
        tempTotal[13]=etTotalSub14.getText().toString();
        tempTotal[14]=etTotalSub15.getText().toString();
        tempTotal[15]=etTotalSub16.getText().toString();
        tempTotal[16]=etTotalSub17.getText().toString();
        tempTotal[17]=etTotalSub18.getText().toString();
        tempTotal[18]=etTotalSub19.getText().toString();
        tempTotal[19]=etTotalSub20.getText().toString();

        for(aa=0;aa<totalSub;aa++){
            if(tempAttended[aa].equals(""))
            {
                int aaa;
                flag=1;
                aaa=aa+1;
                Toast.makeText(getActivity(), "Kindly fill attended class for Subject "+aaa,Toast.LENGTH_SHORT).show();
                break;
            }
            if(tempTotal[aa].equals(""))
            {
                int bbb;
                flag=1;
                bbb=aa+1;
                Toast.makeText(getActivity(), "Kindly fill total class for Subject "+bbb,Toast.LENGTH_SHORT).show();
                break;
            }
        }
        if(flag==0)
        {
            getAttendance();
        }


    }
    public void getAttendance(){
        int ii,go=0;
        sessionManager=new SessionManager(getActivity());
        for(ii=0;ii<totalSub;ii++){
            attended[ii]=Integer.parseInt(tempAttended[ii]);
            total[ii]=Integer.parseInt(tempTotal[ii]);
            if(attended[ii]>total[ii])
            {
                go=1;
                Toast.makeText(getActivity(), "Attended class can not be greater than total class.", Toast.LENGTH_SHORT).show();
                break;
            }
        }
        if(go==0)
        {
            sessionManager.setAttended(attended,"classAttended");
            sessionManager.setTotal(total,"classTotal");
            sessionManager.makeLogin();
            sessionManager.setFlag(true);

            calendar=Calendar.getInstance();

            SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
            Date d = new Date();
            String dayOfTheWeek = sdf.format(d);
            sessionManager.setOpenDay(dayOfTheWeek);

            Fragment fragment1=new Main();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment1);
            ft.commit();
        }
    }
    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        getActivity().setTitle("Previous Attendance");
    }
}
