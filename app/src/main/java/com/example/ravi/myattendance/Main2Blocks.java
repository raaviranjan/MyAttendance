package com.example.ravi.myattendance;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by Ravi on 09-Feb-18.
 */

public class Main2Blocks {
    String SubjectName,attended,total,percent,color,track,mark;
    int attendTV,totTV,index;
    float attendanceCriteria;
    Context context;

    public Main2Blocks(String subject, String attended, String total, String percent,
                       String track, int index, Context context, float attendance, String mark){
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

        this.mark=mark;

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

    public String getMark(){return mark;}

    public int getAttendTV(){return attendTV;}

    public int getTotTV(){return totTV;}

    //save the changes after marking the attendance
    public void saveChanges(int att, int tot, int i, String s)
    {
        SessionManager sessionManager=new SessionManager(context);
        Integer[] getPreviousAttendedClass=sessionManager.getAttended("classAttended");
        Integer[] getPreviousTotalClass=sessionManager.getTotal("classTotal");

        HashMap<String ,String> mark = sessionManager.getImageAfterMarking() ;

        getPreviousAttendedClass[i]=att;
        getPreviousTotalClass[i]=tot;
        sessionManager.setAttended(getPreviousAttendedClass,"classAttended");
        sessionManager.setTotal(getPreviousTotalClass,"classTotal");

        if(s.contains("0"))
        {
            sessionManager.setImageAfterMarking(s,mark.get("second"),mark.get("third"),mark.get("fourth"),
                    mark.get("fifth"),mark.get("sixth"),mark.get("seventh"));
        }
        else if(s.contains("1"))
        {
            sessionManager.setImageAfterMarking(mark.get("first"),s,mark.get("third"),mark.get("fourth"),
                    mark.get("fifth"),mark.get("sixth"),mark.get("seventh"));
        }
        else if(s.contains("2"))
        {
            sessionManager.setImageAfterMarking(mark.get("first"),mark.get("second"),s,mark.get("fourth"),
                    mark.get("fifth"),mark.get("sixth"),mark.get("seventh"));
        }
        else if(s.contains("3"))
        {
            sessionManager.setImageAfterMarking(mark.get("first"),mark.get("second"),mark.get("third"),s,
                    mark.get("fifth"),mark.get("sixth"),mark.get("seventh"));
        }
        else if(s.contains("4"))
        {
            sessionManager.setImageAfterMarking(mark.get("first"),mark.get("second"),mark.get("third"),mark.get("fourth"),
                    s,mark.get("sixth"),mark.get("seventh"));
        }else if(s.contains("5"))
        {
            sessionManager.setImageAfterMarking(mark.get("first"),mark.get("second"),mark.get("third"),mark.get("fourth"),
                    mark.get("fifth"),s,mark.get("seventh"));
        }else if(s.contains("6"))
        {
            sessionManager.setImageAfterMarking(mark.get("first"),mark.get("second"),mark.get("third"),mark.get("fourth"),
                    mark.get("fifth"),mark.get("sixth"),s);
        }

        sessionManager.setFlag(false);

    }
}
