package com.abcd.ravi.myattendance;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Ravi on 24-Nov-17.
 */

public class About extends Fragment {
    Button b1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about, viewGroup, false);
        b1=(Button)view.findViewById(R.id.bRate);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("market://details?id=com.abcd.ravi.myattendance"));
                startActivity(intent);
            }
        });
        return view;
    }
    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        getActivity().setTitle("About");
    }
}
