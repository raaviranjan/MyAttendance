package com.example.ravi.myattendance;

/**
 * Created by Ravi on 01-Nov-17.
 */

import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SessionManager {
    // Shared Preferences
    SharedPreferences pref;

    String[] array = new String[7];

    // Editor for Shared preferences
    Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;
    int size;

    // Sharedpref file name
    private static final String PREF_NAME = "AndroidHivePref";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";

    // User name (make variable public to access from outside)
    public static final String KEY_NAME = "name";

    // Email address (make variable public to access from outside)
    public static final String KEY_ATTENDANCE = "attendance";
    public static final String KEY_GENDER = "gender";

    public static final String KEY_MON_SUB_1 = "monsub1";
    public static final String KEY_MON_SUB_2 = "monsub2";
    public static final String KEY_MON_SUB_3 = "monsub3";
    public static final String KEY_MON_SUB_4 = "monsub4";
    public static final String KEY_MON_SUB_5 = "monsub5";
    public static final String KEY_MON_SUB_6 = "monsub6";
    public static final String KEY_MON_SUB_7 = "monsub7";

    public static final String KEY_TUE_SUB_1 = "tuesub1";
    public static final String KEY_TUE_SUB_2 = "tuesub2";
    public static final String KEY_TUE_SUB_3 = "tuesub3";
    public static final String KEY_TUE_SUB_4 = "tuesub4";
    public static final String KEY_TUE_SUB_5 = "tuesub5";
    public static final String KEY_TUE_SUB_6 = "tuesub6";
    public static final String KEY_TUE_SUB_7 = "tuesub7";

    public static final String KEY_WED_SUB_1 = "wedsub1";
    public static final String KEY_WED_SUB_2 = "wedsub2";
    public static final String KEY_WED_SUB_3 = "wedsub3";
    public static final String KEY_WED_SUB_4 = "wedsub4";
    public static final String KEY_WED_SUB_5 = "wedsub5";
    public static final String KEY_WED_SUB_6 = "wedsub6";
    public static final String KEY_WED_SUB_7 = "wedsub7";

    public static final String KEY_THU_SUB_1 = "thusub1";
    public static final String KEY_THU_SUB_2 = "thusub2";
    public static final String KEY_THU_SUB_3 = "thusub3";
    public static final String KEY_THU_SUB_4 = "thusub4";
    public static final String KEY_THU_SUB_5 = "thusub5";
    public static final String KEY_THU_SUB_6 = "thusub6";
    public static final String KEY_THU_SUB_7 = "thusub7";

    public static final String KEY_FRI_SUB_1 = "frisub1";
    public static final String KEY_FRI_SUB_2 = "frisub2";
    public static final String KEY_FRI_SUB_3 = "frisub3";
    public static final String KEY_FRI_SUB_4 = "frisub4";
    public static final String KEY_FRI_SUB_5 = "frisub5";
    public static final String KEY_FRI_SUB_6 = "frisub6";
    public static final String KEY_FRI_SUB_7 = "frisub7";

    public static final String KEY_SAT_SUB_1 = "satsub1";
    public static final String KEY_SAT_SUB_2 = "satsub2";
    public static final String KEY_SAT_SUB_3 = "satsub3";
    public static final String KEY_SAT_SUB_4 = "satsub4";
    public static final String KEY_SAT_SUB_5 = "satsub5";
    public static final String KEY_SAT_SUB_6 = "satsub6";
    public static final String KEY_SAT_SUB_7 = "satsub7";

    // Constructor
    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     * Create login session
     * */
    public void makeLogin()
    {
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);
        editor.commit();

    }
    //store user details
    public void createLoginSession(String name, String atten, String gen){

        // Storing name in pref
        editor.putString(KEY_NAME, name);

        // Storing attendance in pref
        editor.putString(KEY_ATTENDANCE, atten);

        editor.putString(KEY_GENDER, gen);

        // commit changes
        editor.commit();
    }
    public void monSubjects(String s1,String s2,String s3,String s4,String s5,String s6,String s7){
        editor.putString(KEY_MON_SUB_1,s1);
        editor.putString(KEY_MON_SUB_2,s2);
        editor.putString(KEY_MON_SUB_3,s3);
        editor.putString(KEY_MON_SUB_4,s4);
        editor.putString(KEY_MON_SUB_5,s5);
        editor.putString(KEY_MON_SUB_6,s6);
        editor.putString(KEY_MON_SUB_7,s7);

        editor.commit();

    }

    public void tueSubjects(String s1,String s2,String s3,String s4,String s5,String s6,String s7){
        editor.putString(KEY_TUE_SUB_1,s1);
        editor.putString(KEY_TUE_SUB_2,s2);
        editor.putString(KEY_TUE_SUB_3,s3);
        editor.putString(KEY_TUE_SUB_4,s4);
        editor.putString(KEY_TUE_SUB_5,s5);
        editor.putString(KEY_TUE_SUB_6,s6);
        editor.putString(KEY_TUE_SUB_7,s7);

        editor.commit();

    }

    public void wedSubjects(String s1,String s2,String s3,String s4,String s5,String s6,String s7){
        editor.putString(KEY_WED_SUB_1,s1);
        editor.putString(KEY_WED_SUB_2,s2);
        editor.putString(KEY_WED_SUB_3,s3);
        editor.putString(KEY_WED_SUB_4,s4);
        editor.putString(KEY_WED_SUB_5,s5);
        editor.putString(KEY_WED_SUB_6,s6);
        editor.putString(KEY_WED_SUB_7,s7);

        editor.commit();

    }

    public void thuSubjects(String s1,String s2,String s3,String s4,String s5,String s6,String s7){
        editor.putString(KEY_THU_SUB_1,s1);
        editor.putString(KEY_THU_SUB_2,s2);
        editor.putString(KEY_THU_SUB_3,s3);
        editor.putString(KEY_THU_SUB_4,s4);
        editor.putString(KEY_THU_SUB_5,s5);
        editor.putString(KEY_THU_SUB_6,s6);
        editor.putString(KEY_THU_SUB_7,s7);

        editor.commit();

    }

    public void friSubjects(String s1,String s2,String s3,String s4,String s5,String s6,String s7){
        editor.putString(KEY_FRI_SUB_1,s1);
        editor.putString(KEY_FRI_SUB_2,s2);
        editor.putString(KEY_FRI_SUB_3,s3);
        editor.putString(KEY_FRI_SUB_4,s4);
        editor.putString(KEY_FRI_SUB_5,s5);
        editor.putString(KEY_FRI_SUB_6,s6);
        editor.putString(KEY_FRI_SUB_7,s7);

        editor.commit();

    }

    public void satSubjects(String s1,String s2,String s3,String s4,String s5,String s6,String s7){
        editor.putString(KEY_SAT_SUB_1,s1);
        editor.putString(KEY_SAT_SUB_2,s2);
        editor.putString(KEY_SAT_SUB_3,s3);
        editor.putString(KEY_SAT_SUB_4,s4);
        editor.putString(KEY_SAT_SUB_5,s5);
        editor.putString(KEY_SAT_SUB_6,s6);
        editor.putString(KEY_SAT_SUB_7,s7);

        editor.commit();

    }
    //calendar details
    public void setCalendarDetails(String day,String day_date){
        editor.putString("day",day);
        editor.putString("day_date",day_date);
        editor.commit();
    }
    public HashMap<String, String> getDay(){
        HashMap<String, String> today = new HashMap<String, String>();
        today.put("day", pref.getString("day", null));
        today.put("day_date", pref.getString("day_date", null));

        return today;
    }
    //to put and get no of subjects on a particular day
    public void setCountMon(Integer c){
        editor.putInt("MonCount",c);
        editor.commit();
    }
    public int getCountMon(){
        return pref.getInt("MonCount",0);
    }

    public void setCountTue(Integer c){
        editor.putInt("TueCount",c);
        editor.commit();
    }
    public int getCountTue(){
        return pref.getInt("TueCount",0);
    }

    public void setCountWed(Integer c){
        editor.putInt("WedCount",c);
        editor.commit();
    }
    public int getCountWed(){
        return pref.getInt("WedCount",0);
    }

    public void setCountThu(Integer c){
        editor.putInt("ThuCount",c);
        editor.commit();
    }
    public int getCountThu(){
        return pref.getInt("ThuCount",0);
    }

    public void setCountFri(Integer c){
        editor.putInt("FriCount",c);
        editor.commit();
    }
    public int getCountFri(){
        return pref.getInt("FriCount",0);
    }

    public void setCountSat(Integer c){
        editor.putInt("SatCount",c);
        editor.commit();
    }
    public int getCountSat(){
        return pref.getInt("SatCount",0);
    }

    //store subject list
    public boolean allSubjects(String[] data,String arrayName){
        editor.putInt(arrayName+"_size",data.length);
        for(int i=0;i<data.length;i++)
            editor.putString(arrayName + "_" + i, data[i]);
        return editor.commit();

    }
    //store total no of subjects
    public  void setSize(Integer a){
        editor.putInt("Size",a);
        editor.commit();
    }
    //get total no of subjects
    public int getSize(){
        size = pref.getInt("Size", 0);
        return size;
    }
    //return subject list
    public String[] loadArray(String arrayName) {
        size = pref.getInt(arrayName + "_size", 0);
        String array[] = new String[size];
        for(int i=0;i<size;i++)
            array[i] = pref.getString(arrayName + "_" + i, null);
        return array;
    }
    //store and get previously attended and total class for each subject as an array
    public boolean setAttended(Integer[] attended,String arrayName){
        editor.putInt(arrayName+"_size",attended.length);
        for(int i=0;i<attended.length;i++)
            editor.putInt(arrayName + "_" + i, attended[i]);
        return editor.commit();
    }
    public Integer[] getAttended(String arrayName){
        int a=pref.getInt(arrayName + "_size", 0);
        Integer arr[]=new Integer[a];
        for(int i=0;i<a;i++)
            arr[i] = pref.getInt(arrayName + "_" + i, 0);
        return arr;
    }
    public boolean setTotal(Integer[] total,String arrayName){
        editor.putInt(arrayName+"_size",total.length);
        for(int i=0;i<total.length;i++)
            editor.putInt(arrayName + "_" + i, total[i]);
        return editor.commit();
    }
    public Integer[] getTotal(String arrayName){
        int b=pref.getInt(arrayName + "_size", 0);
        Integer brr[]=new Integer[b];
        for(int i=0;i<b;i++)
            brr[i] = pref.getInt(arrayName + "_" + i, 0);
        return brr;
    }

    public boolean setImageOfAttendancePage(Integer[] image,String imageArrayName)
    {
        editor.putInt(imageArrayName+"_size",image.length);
        for (int m=0;m<image.length;m++)
            editor.putInt(imageArrayName+"_"+m,image[m]);
        return editor.commit();
    }
    public Integer[] getImageOfAttendancePage(String imageArrayName)
    {
        int bb=pref.getInt(imageArrayName+"_size",0);
        Integer bbArray[]=new Integer[bb];
        for (int m=0;m<bb;m++)
            bbArray[m]=pref.getInt(imageArrayName+"_"+m,0);
        return bbArray;
    }
    public boolean setFlag(boolean c)
    {
        editor.putBoolean("flagForAttendanceImage",c);
        return editor.commit();
    }
    public boolean getFlag()
    {
        return pref.getBoolean("flagForAttendanceImage",false);
    }

    public void setOpenDay(String a)
    {
        editor.putString("TodayTime",a);
        editor.commit();
    }
    public String getOpenDay()
    {
        return pref.getString("TodayTime",null);
    }



    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     * */
    public void checkLogin(){
        // Check login status
        if(!this.isLoggedIn()){

        }

    }

    /**
     * Get stored session data
     * */
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        // user name
        user.put(KEY_NAME, pref.getString(KEY_NAME, null));
        // user gender
        user.put(KEY_GENDER, pref.getString(KEY_GENDER, null));
        // user attendance criteria
        user.put(KEY_ATTENDANCE, pref.getString(KEY_ATTENDANCE, null));

        return user;
    }
    public HashMap<String, String> getMonSubjects(){
        HashMap<String, String> sub = new HashMap<String, String>();

        sub.put(KEY_MON_SUB_1, pref.getString(KEY_MON_SUB_1, null));
        sub.put(KEY_MON_SUB_2, pref.getString(KEY_MON_SUB_2, null));
        sub.put(KEY_MON_SUB_3, pref.getString(KEY_MON_SUB_3, null));
        sub.put(KEY_MON_SUB_4, pref.getString(KEY_MON_SUB_4, null));
        sub.put(KEY_MON_SUB_5, pref.getString(KEY_MON_SUB_5, null));
        sub.put(KEY_MON_SUB_6, pref.getString(KEY_MON_SUB_6, null));
        sub.put(KEY_MON_SUB_7, pref.getString(KEY_MON_SUB_7, null));

        return sub;
    }

    public HashMap<String, String> getTueSubjects(){
        HashMap<String, String> tuesub = new HashMap<String, String>();

        tuesub.put(KEY_TUE_SUB_1, pref.getString(KEY_TUE_SUB_1, null));
        tuesub.put(KEY_TUE_SUB_2, pref.getString(KEY_TUE_SUB_2, null));
        tuesub.put(KEY_TUE_SUB_3, pref.getString(KEY_TUE_SUB_3, null));
        tuesub.put(KEY_TUE_SUB_4, pref.getString(KEY_TUE_SUB_4, null));
        tuesub.put(KEY_TUE_SUB_5, pref.getString(KEY_TUE_SUB_5, null));
        tuesub.put(KEY_TUE_SUB_6, pref.getString(KEY_TUE_SUB_6, null));
        tuesub.put(KEY_TUE_SUB_7, pref.getString(KEY_TUE_SUB_7, null));

        return tuesub;
    }

    public HashMap<String, String> getWedSubjects(){
        HashMap<String, String> wedsub = new HashMap<String, String>();

        wedsub.put(KEY_WED_SUB_1, pref.getString(KEY_WED_SUB_1, null));
        wedsub.put(KEY_WED_SUB_2, pref.getString(KEY_WED_SUB_2, null));
        wedsub.put(KEY_WED_SUB_3, pref.getString(KEY_WED_SUB_3, null));
        wedsub.put(KEY_WED_SUB_4, pref.getString(KEY_WED_SUB_4, null));
        wedsub.put(KEY_WED_SUB_5, pref.getString(KEY_WED_SUB_5, null));
        wedsub.put(KEY_WED_SUB_6, pref.getString(KEY_WED_SUB_6, null));
        wedsub.put(KEY_WED_SUB_7, pref.getString(KEY_WED_SUB_7, null));

        return wedsub;
    }

    public HashMap<String, String> getThuSubjects(){
        HashMap<String, String> thusub = new HashMap<String, String>();

        thusub.put(KEY_THU_SUB_1, pref.getString(KEY_THU_SUB_1, null));
        thusub.put(KEY_THU_SUB_2, pref.getString(KEY_THU_SUB_2, null));
        thusub.put(KEY_THU_SUB_3, pref.getString(KEY_THU_SUB_3, null));
        thusub.put(KEY_THU_SUB_4, pref.getString(KEY_THU_SUB_4, null));
        thusub.put(KEY_THU_SUB_5, pref.getString(KEY_THU_SUB_5, null));
        thusub.put(KEY_THU_SUB_6, pref.getString(KEY_THU_SUB_6, null));
        thusub.put(KEY_THU_SUB_7, pref.getString(KEY_THU_SUB_7, null));

        return thusub;
    }

    public HashMap<String, String> getFriSubjects(){
        HashMap<String, String> frisub = new HashMap<String, String>();

        frisub.put(KEY_FRI_SUB_1, pref.getString(KEY_FRI_SUB_1, null));
        frisub.put(KEY_FRI_SUB_2, pref.getString(KEY_FRI_SUB_2, null));
        frisub.put(KEY_FRI_SUB_3, pref.getString(KEY_FRI_SUB_3, null));
        frisub.put(KEY_FRI_SUB_4, pref.getString(KEY_FRI_SUB_4, null));
        frisub.put(KEY_FRI_SUB_5, pref.getString(KEY_FRI_SUB_5, null));
        frisub.put(KEY_FRI_SUB_6, pref.getString(KEY_FRI_SUB_6, null));
        frisub.put(KEY_FRI_SUB_7, pref.getString(KEY_FRI_SUB_7, null));

        return frisub;
    }

    public HashMap<String, String> getSatSubjects(){
        HashMap<String, String> satsub = new HashMap<String, String>();

        satsub.put(KEY_SAT_SUB_1, pref.getString(KEY_SAT_SUB_1, null));
        satsub.put(KEY_SAT_SUB_2, pref.getString(KEY_SAT_SUB_2, null));
        satsub.put(KEY_SAT_SUB_3, pref.getString(KEY_SAT_SUB_3, null));
        satsub.put(KEY_SAT_SUB_4, pref.getString(KEY_SAT_SUB_4, null));
        satsub.put(KEY_SAT_SUB_5, pref.getString(KEY_SAT_SUB_5, null));
        satsub.put(KEY_SAT_SUB_6, pref.getString(KEY_SAT_SUB_6, null));
        satsub.put(KEY_SAT_SUB_7, pref.getString(KEY_SAT_SUB_7, null));

        return satsub;
    }


    /**
     * Clear session details
     * */
    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();


    }

    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }
}