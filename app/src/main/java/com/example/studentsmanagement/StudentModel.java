package com.example.studentsmanagement;

public class StudentModel {
    private int id;
    private String name;
    private int dob;
    private String hometown;
    private String schoolYear;

    public StudentModel(int id, String name, int dob, String hometown, String schoolYear) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.hometown = hometown;
        this.schoolYear = schoolYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDob() {
        return dob;
    }

    public void setDob(int dob) {
        this.dob = dob;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }
}
