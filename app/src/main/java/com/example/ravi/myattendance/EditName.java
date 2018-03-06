package com.example.ravi.myattendance;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by Ravi on 22-Nov-17.
 */

public class EditName extends Fragment implements SeekBar.OnSeekBarChangeListener {
    EditText editText;
    SeekBar seekBar;
    Button button;
    TextView aValue;
    ImageButton imageButton1,imageButton2;
    String gender;
    Fragment fragment = null;
    int seekValue=15;
    SessionManager sessionManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.name, viewGroup, false);
        editText=(EditText)view.findViewById(R.id.editText);
        seekBar=(SeekBar)view.findViewById(R.id.seekBar);
        button=(Button)view.findViewById(R.id.button);
        aValue=(TextView)view.findViewById(R.id.textnum);
        seekBar.setOnSeekBarChangeListener(this);
        imageButton1=(ImageButton)view.findViewById(R.id.imageButton1);
        imageButton2=(ImageButton)view.findViewById(R.id.imageButton2);

        sessionManager=new SessionManager(getActivity());


        if(sessionManager.isLoggedIn())
        {
            imageButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    gender="Male";
                    Toast.makeText(getActivity()," Male ",Toast.LENGTH_SHORT).show();
                }
            });

            imageButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    gender="Female";
                    Toast.makeText(getActivity()," Female ",Toast.LENGTH_SHORT).show();
                }
            });

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String user=editText.getText().toString();
                    String att=aValue.getText().toString();
                    new SessionManager(getContext()).createLoginSession(user,att,gender);


                    Toast.makeText(getActivity(), "Changes Saved Successfully", Toast.LENGTH_SHORT).show();
                    fragment = new Main2();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.content_frame, fragment);
                    ft.commit();
                }
            });
        }
        else
            Toast.makeText(getActivity(), "Fill the details first, then only you can edit", Toast.LENGTH_SHORT).show();


        return view;
    }
    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        getActivity().setTitle("Edit Name");
    }
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        seekValue=i*5;
        aValue.setText(String.valueOf(seekValue));

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
