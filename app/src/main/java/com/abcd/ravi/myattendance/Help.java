package com.abcd.ravi.myattendance;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Ravi on 22-Nov-17.
 */

public class Help extends Fragment {
    TextView t1,t2,t3,t4,t5,t6,t7;
    Button b1,b2,b3,b4,b5,b6,b7;
    int c1=0,c2=0,c3=0,c4=0,c5=0,c6=0,c7=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.help, viewGroup, false);

        b1=(Button)view.findViewById(R.id.bSetUp);
        b2=(Button)view.findViewById(R.id.bEnterSub);
        b3=(Button)view.findViewById(R.id.bEnterSch);
        b4=(Button)view.findViewById(R.id.bEnterPreAtt);
        b5=(Button)view.findViewById(R.id.bMarkAtt);
        b6=(Button)view.findViewById(R.id.bMarkExtraAtt);
        b7=(Button)view.findViewById(R.id.bReset);

        t1=(TextView)view.findViewById(R.id.tvSetUp);
        t2=(TextView)view.findViewById(R.id.tvEnterSub);
        t3=(TextView)view.findViewById(R.id.tvEnterSch);
        t4=(TextView)view.findViewById(R.id.tvEnterPreAtt);
        t5=(TextView)view.findViewById(R.id.tvMarkAtt);
        t6=(TextView)view.findViewById(R.id.tvMarkExtraAtt);
        t7=(TextView)view.findViewById(R.id.tvReset);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c1++;
                if(c1%2!=0)
                {
                    visibilityGone();
                    t1.setVisibility(View.VISIBLE);
                }
                else
                    visibilityGone();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c2++;
                if(c2%2!=0)
                {
                    visibilityGone();
                    t2.setVisibility(View.VISIBLE);
                }
                else
                    visibilityGone();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c3++;
                if(c3%2!=0)
                {
                    visibilityGone();
                    t3.setVisibility(View.VISIBLE);
                }
                else
                    visibilityGone();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c4++;
                if(c4%2!=0)
                {
                    visibilityGone();
                    t4.setVisibility(View.VISIBLE);
                }
                else
                    visibilityGone();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c5++;
                if(c5%2!=0)
                {
                    visibilityGone();
                    t5.setVisibility(View.VISIBLE);
                }
                else
                    visibilityGone();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c6++;
                if(c6%2!=0)
                {
                    visibilityGone();
                    t6.setVisibility(View.VISIBLE);
                }
                else
                    visibilityGone();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c7++;
                if(c7%2!=0)
                {
                    visibilityGone();
                    t7.setVisibility(View.VISIBLE);
                }
                else
                    visibilityGone();
            }
        });

        return view;
    }
    public void visibilityGone()
    {
        t1.setVisibility(View.GONE);
        t2.setVisibility(View.GONE);
        t3.setVisibility(View.GONE);
        t4.setVisibility(View.GONE);
        t5.setVisibility(View.GONE);
        t6.setVisibility(View.GONE);
        t7.setVisibility(View.GONE);
    }
    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        getActivity().setTitle("Help");
    }
}
