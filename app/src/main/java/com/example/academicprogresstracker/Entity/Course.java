package com.example.academicprogresstracker.Entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.academicprogresstracker.Utilities.CourseStatus;

import java.time.LocalDate;

@Entity(tableName = "course_table",
        foreignKeys = @ForeignKey(entity = Term.class,
        parentColumns = "term_id",
        childColumns = "term_id",
        onDelete = ForeignKey.CASCADE))
public class Course {

    @PrimaryKey(autoGenerate = true)
    private int course_id;
    private int term_id;
    private String course_title;
    private LocalDate course_start;
    private LocalDate course_end;
    private CourseStatus course_status;
    private String course_mentor_name;
    private String course_mentor_phone;
    private String course_mentor_email;

    // Constructor

    public Course(int term_id, String course_title, LocalDate course_start, LocalDate course_end, CourseStatus course_status, String course_mentor_name, String course_mentor_phone, String course_mentor_email) {
        this.term_id = term_id;
        this.course_title = course_title;
        this.course_start = course_start;
        this.course_end = course_end;
        this.course_status = course_status;
        this.course_mentor_name = course_mentor_name;
        this.course_mentor_phone = course_mentor_phone;
        this.course_mentor_email = course_mentor_email;
    }

    @Ignore
    public Course(int course_id, int term_id, String course_title, LocalDate course_start, LocalDate course_end, CourseStatus course_status, String course_mentor_name, String course_mentor_phone, String course_mentor_email) {
        this.course_id = course_id;
        this.term_id = term_id;
        this.course_title = course_title;
        this.course_start = course_start;
        this.course_end = course_end;
        this.course_status = course_status;
        this.course_mentor_name = course_mentor_name;
        this.course_mentor_phone = course_mentor_phone;
        this.course_mentor_email = course_mentor_email;
    }

    // Getters

    public int getCourse_id() {
        return course_id;
    }

    public int getTerm_id() {
        return term_id;
    }

    public String getCourse_title() {
        return course_title;
    }

    public LocalDate getCourse_start() {
        return course_start;
    }

    public LocalDate getCourse_end() {
        return course_end;
    }

    public CourseStatus getCourse_status() {
        return course_status;
    }

    public String getCourse_mentor_name() {
        return course_mentor_name;
    }

    public String getCourse_mentor_phone() {
        return course_mentor_phone;
    }

    public String getCourse_mentor_email() {
        return course_mentor_email;
    }

    // Setters

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public void setTerm_id(int term_id) {
        this.term_id = term_id;
    }

    public void setCourse_title(String course_title) {
        this.course_title = course_title;
    }

    public void setCourse_start(LocalDate course_start) {
        this.course_start = course_start;
    }

    public void setCourse_end(LocalDate course_end) {
        this.course_end = course_end;
    }

    public void setCourse_status(CourseStatus course_status) {
        this.course_status = course_status;
    }

    public void setCourse_mentor_name(String course_mentor_name) {
        this.course_mentor_name = course_mentor_name;
    }

    public void setCourse_mentor_phone(String course_mentor_phone) {
        this.course_mentor_phone = course_mentor_phone;
    }

    public void setCourse_mentor_email(String course_mentor_email) {
        this.course_mentor_email = course_mentor_email;
    }
}
