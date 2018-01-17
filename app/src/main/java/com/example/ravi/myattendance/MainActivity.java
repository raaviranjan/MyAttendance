package com.example.ravi.myattendance;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {
    SessionManager sessionManager;
    int id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sessionManager =new SessionManager(getApplicationContext());

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        if(!sessionManager.isLoggedIn())
        {
            //displaySelectedScreen(R.id.nav_profile);
            Fragment fragment1=new Name();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment1);
            ft.commit();
        }
        else
        {
            View navView=navigationView.inflateHeaderView(R.layout.nav_header_main);
            TextView nav_name=(TextView)navView.findViewById(R.id.textViewNavHeader);
            ImageView imageView=(ImageView)navView.findViewById(R.id.imageView);

            HashMap<String ,String> str=sessionManager.getUserDetails();
            String string =str.get(SessionManager.KEY_NAME);
            String st=str.get(SessionManager.KEY_GENDER);

            if(st.equals("Female"))
                imageView.setImageResource(R.drawable.female);
            else
                imageView.setImageResource(R.drawable.male);
            nav_name.setText("Hello, "+string);

            Fragment fragment2=new Main();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment2);
            ft.commit();
        }

    }

    @Override
    public void onBackPressed() {
        /*DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }*/
        if(id>0)
        {
            id=0;
            if(sessionManager.isLoggedIn())
            {
                Fragment fragment1=new Main();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, fragment1);
                ft.commit();
            }
            else
                super.onBackPressed();
        }
        else
            super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int ide = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (ide == R.id.action_help) {
            id=10;
            Fragment fragment1=new Help();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment1);
            ft.commit();
            Toast.makeText(this, "Click the fields to explore", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (ide == R.id.action_about) {
            id=11;
            Fragment fragment1=new About();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment1);
            ft.commit();
            Toast.makeText(this, "Kindly Rate Us", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        displaySelectedScreen(item.getItemId());
        return true;
    }
    private void displaySelectedScreen(int itemId) {

        //creating fragment object
        Fragment fragment = null;
        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.nav_profile:
                id=1;
                fragment = new Saturday();
                break;
            case R.id.nav_timetable:
                id=2;
                fragment = new Timetable();
                break;
            case R.id.nav_overall:
                id=3;
                fragment = new Subjectwise();
                break;
            case R.id.nav_extra_class:
                id=4;
                fragment = new ExtraClass();
                break;
            case R.id.nav_edit_profile:
                id=5;
                fragment = new EditName();
                break;
            case R.id.nav_edit_subjects:
                id=6;
                fragment = new EditSubjects();
                break;
            case R.id.nav_edit_timetable:
                id=7;
                fragment = new EditMonday();
                break;
            case R.id.nav_reset:
                id=8;
                fragment = new Reset();
                break;
            case R.id.nav_reset_attendance:
                id=9;
                fragment = new ResetAttendance();
                break;
        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
}
