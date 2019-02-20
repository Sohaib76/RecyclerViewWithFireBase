package com.khf.sohaib.studentportal.Model;

public class ExamScheduleModel {


    private String Subject;
    private String Date;
    private String Image;

    public ExamScheduleModel() {
    }

    public ExamScheduleModel(String subject, String date, String image) {
        Subject = subject;
        Date = date;
        Image = image;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}

