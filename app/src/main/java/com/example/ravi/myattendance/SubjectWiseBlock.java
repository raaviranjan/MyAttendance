package com.example.ravi.myattendance;

/**
 * Created by Ravi on 12-Mar-18.
 */

public class SubjectWiseBlock {

    String SubjectName,attended,total,percent,color,track;

    public SubjectWiseBlock(String subject, String attended, String total, String percent, String track){

        this.SubjectName=subject;
        this.attended=attended;//string that prints the attended class for the subject
        this.total=total;//string that prints the total class for the subject
        this.percent=percent;//attendance percentage

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

    public String getColor(){return color;}

}
