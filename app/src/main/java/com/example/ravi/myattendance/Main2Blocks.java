package com.example.ravi.myattendance;

import android.content.Context;

/**
 * Created by Ravi on 09-Feb-18.
 */

public class Main2Blocks {
    String SubjectName,attended,total,percent,color,track,s;
    int attendTV,totTV,index;
    float attendanceCriteria;
    Context context;

    public Main2Blocks(String subject, String attended, String total, String percent,
                       String track, int index, Context context, float attendance){
        SessionManager sessionManager=new SessionManager(context);
        Integer[] getPreviousAttendedClass=sessionManager.getAttended("classAttended");
        Integer[] getPreviousTotalClass=sessionManager.getTotal("classTotal");

        this.SubjectName=subject;
        this.attended=attended;//string that prints the attended class for the subject
        this.total=total;//string that prints the total class for the subject
        this.percent=percent;//attendance percentage
        this.index=index;//current subject matches with which subject no of the total subject array
        this.context=context;
        this.attendanceCriteria=attendance;//attendance Criteria of user
        this.attendTV=getPreviousAttendedClass[index];//attended class for the subject
        this.totTV=getPreviousTotalClass[index];//total class for the subject
        //track contains the string either "You are on track" or "Attend next class"
        if(track.contains("Attend"))
        {
            this.color="#B22222";//red
            this.track=track;
        }
        else if(track.contains("track"))
        {
            this.color="#008000";//green
            this.track=track;
        }
    }
    public String getSubjectName()
    {
        return SubjectName;
    }

    public String getAttended()
    {
        return attended;
    }

    public String getTotal(){return total;}

    public String getPercent(){return percent;}

    public String getTrack(){return track;}

    public float getAttendanceCriteria(){return attendanceCriteria;}

    public String getColor(){return color;}

    public int getAttendTV(){return attendTV;}

    public int getTotTV(){return totTV;}

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
