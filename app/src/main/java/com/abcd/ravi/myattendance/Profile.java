package com.abcd.ravi.myattendance;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by Ravi on 17-Nov-17.
 */

public class Profile extends Fragment {
    ImageView IVProfileMale;
    TextView TVProfileName,TVProfileCriteria;
    SessionManager sessionManager;
    Fragment fragment=null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.profile, viewGroup, false);
        sessionManager=new SessionManager(getActivity());
        HashMap<String ,String> str=sessionManager.getUserDetails();
        String name =str.get(SessionManager.KEY_NAME);
        String gender=str.get(SessionManager.KEY_GENDER);
        String att=str.get(SessionManager.KEY_ATTENDANCE);

        IVProfileMale=(ImageView)view.findViewById(R.id.IVProfileMale);
        TVProfileCriteria=(TextView)view.findViewById(R.id.TVProfileCriteria);
        TVProfileName=(TextView)view.findViewById(R.id.TVProfileName);

        if(sessionManager.isLoggedIn())
        {
            if(gender.equals("Female"))
                IVProfileMale.setImageResource(R.drawable.female);
            TVProfileName.setText("Hello, "+name);
            TVProfileCriteria.setText("Attendance Criteria: "+att+"%");
        }
        else
            Toast.makeText(getActivity(), "Nothing to display", Toast.LENGTH_SHORT).show();



        return view;
    }
    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        getActivity().setTitle("Profile");
    }
}
