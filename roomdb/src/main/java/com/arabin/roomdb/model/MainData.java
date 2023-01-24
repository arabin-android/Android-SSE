package com.arabin.roomdb.model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "data_table")
public class MainData {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String exam;
    private String studentId;
    private String score;

    public MainData(String exam, String studentId, String score){
        this.exam = exam;
        this.studentId = studentId;
        this.score = score;
    }

    public String  getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
