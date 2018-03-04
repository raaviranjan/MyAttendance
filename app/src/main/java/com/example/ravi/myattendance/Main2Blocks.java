package com.example.ravi.myattendance;

import android.content.Context;

/**
 * Created by Ravi on 09-Feb-18.
 */

public class Main2Blocks {
    String SubjectName,attended,total,percent,color,track,s;
    int attendTV,totTV,index;
    float attend;
    Context context;

   /*public Product(String subjectName, String attended, String total, String percent, String color, int index, Context context, float attend) {
        SessionManager sessionManager=new SessionManager(context);
        Integer[] getPreviousAttendedClass=sessionManager.getAttended("classAttended");
        Integer[] getPreviousTotalClass=sessionManager.getTotal("classTotal");

        this.SubjectName=subjectName;//string that prints the subject name
        this.attended=attended;//string that prints the attended class for the subject
        this.total=total;//string that prints the total class for the subject
        this.index=index;//current subject matches with which subject no of the total subject array
        this.percent=percent;//attendance percentage
        this.context=context;
        this.attend=attend;//attendance Criteria of user
        //this.attendTV=getPreviousAttendedClass[index];//attended class for the subject
        //this.totTV=getPreviousTotalClass[index];//total class for the subject
        //color contains the string either "You are on track" or "Attend next class"
        if(color.contains("Attend"))
        {
            this.color="#B22222";//red
            this.track=color;
        }
        else if(color.contains("track"))
        {
            this.color="#008000";//green
            this.track=color;
        }
   }*/
    public Main2Blocks(String subject,String s){
        this.SubjectName=subject;
        this.attended=s;
    }
    public String getSubjectName()
    {
        return SubjectName;
    }
    public String getAttended()
    {
        return attended;
    }
    //save the changes after marking the attendance
    public void saveChanges(int att,int tot,int i)
    {
        SessionManager sessionManager=new SessionManager(context);
        Integer[] getPreviousAttendedClass=sessionManager.getAttended("classAttended");
        Integer[] getPreviousTotalClass=sessionManager.getTotal("classTotal");
        getPreviousAttendedClass[i]=att;
        getPreviousTotalClass[i]=tot;
        sessionManager.setAttended(getPreviousAttendedClass,"classAttended");
        sessionManager.setTotal(getPreviousTotalClass,"classTotal");
    }
}
