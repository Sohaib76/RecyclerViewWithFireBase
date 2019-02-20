package com.khf.sohaib.studentportal.Model;

public class ImportantDatesModel {

    private String Date;
    private String Day;
    private String Image;

    public ImportantDatesModel() {
    }

    public ImportantDatesModel(String date, String day, String image) {
        Date = date;
        Day = day;
        Image = image;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
