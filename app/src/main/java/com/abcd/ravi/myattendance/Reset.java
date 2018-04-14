package com.abcd.ravi.myattendance;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by Ravi on 23-Nov-17.
 */

public class Reset extends Fragment {
    SessionManager sessionManager;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sessionManager=new SessionManager(getActivity());
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("Reset MY ATTENDANCE");
        alertDialog.setMessage("It will delete all your data. Do you wish to continue? ");
        alertDialog.setPositiveButton("Yes",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                sessionManager.logoutUser();
                Toast.makeText(getActivity(), "All data erased. Re-enter your data", Toast.LENGTH_SHORT).show();
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
}
