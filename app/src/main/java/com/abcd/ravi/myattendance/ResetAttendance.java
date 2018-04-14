package com.abcd.ravi.myattendance;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by Ravi on 25-Nov-17.
 */

public class ResetAttendance extends Fragment {
    SessionManager sessionManager;
    Integer[] attended;
    Integer[] total;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sessionManager=new SessionManager(getActivity());
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("Reset Attendance");
        alertDialog.setMessage("It will delete all your attendance. Do you wish to continue? ");
        alertDialog.setPositiveButton("Yes",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                attended=new Integer[20];
                total=new Integer[20];
                for(int ii=0;ii<20;ii++)
                {
                    attended[ii]=0;
                    total[ii]=0;
                }
                sessionManager.setAttended(attended,"classAttended");
                sessionManager.setTotal(total,"classTotal");
                Toast.makeText(getActivity(), "All data erased. Re-enter your data", Toast.LENGTH_SHORT).show();
                reEnterAttend();

            }
        });
        alertDialog.setNegativeButton("No",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(), "Good decision", Toast.LENGTH_SHORT).show();
                Fragment fragment = new Main2();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, fragment);
                ft.commit();
            }
        });
        AlertDialog al=alertDialog.create();
        al.show();
    }
    public void reEnterAttend()
    {
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("Re-Enter Attendance");
        alertDialog.setMessage("Do you wish to re-enter your attendance? ");
        alertDialog.setPositiveButton("Yes",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Fragment fragment = new PreAttendance();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, fragment);
                ft.commit();
            }
        });
        alertDialog.setNegativeButton("No",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Fragment fragment = new Main2();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, fragment);
                ft.commit();
                Toast.makeText(getActivity(), "Follow the same procedure to enter attendance later", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog al=alertDialog.create();
        al.show();
    }
}
