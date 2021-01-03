package com.example.academicprogresstracker.Entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.academicprogresstracker.Utilities.AssessmentStatus;
import com.example.academicprogresstracker.Utilities.AssessmentType;

import java.time.LocalDate;

/**
 * Room Entity Assessment
 *
 * @author derricksouthworth
 */
@Entity(tableName = "assessment_table",
        foreignKeys = @ForeignKey(entity = Course.class,
        parentColumns = "course_id",
        childColumns = "course_id",
        onDelete = ForeignKey.CASCADE))
public class Assessment {

    @PrimaryKey(autoGenerate = true)
    private int assessment_id;
    private int course_id;
    private String assessment_title;
    private LocalDate assessment_date;
    private AssessmentType assessment_type;
    private AssessmentStatus assessment_status;

    // Constructor

    public Assessment(int course_id, String assessment_title, LocalDate assessment_date, AssessmentType assessment_type, AssessmentStatus assessment_status) {
        this.course_id = course_id;
        this.assessment_title = assessment_title;
        this.assessment_date = assessment_date;
        this.assessment_type = assessment_type;
        this.assessment_status = assessment_status;
    }

    @Ignore
    public Assessment(int assessment_id, int course_id, String assessment_title, LocalDate assessment_date, AssessmentType assessment_type, AssessmentStatus assessment_status) {
        this.assessment_id = assessment_id;
        this.course_id = course_id;
        this.assessment_title = assessment_title;
        this.assessment_date = assessment_date;
        this.assessment_type = assessment_type;
        this.assessment_status = assessment_status;
    }

    // Getters

    public int getAssessment_id() {
        return assessment_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public String getAssessment_title() {
        return assessment_title;
    }

    public LocalDate getAssessment_date() {
        return assessment_date;
    }

    public AssessmentType getAssessment_type() {
        return assessment_type;
    }

    public AssessmentStatus getAssessment_status() { return assessment_status; }

    // Setters

    public void setAssessment_id(int assessment_id) {
        this.assessment_id = assessment_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public void setAssessment_title(String assessment_title) {
        this.assessment_title = assessment_title;
    }

    public void setAssessment_date(LocalDate assessment_date) {
        this.assessment_date = assessment_date;
    }

    public void setAssessment_type(AssessmentType assessment_type) {
        this.assessment_type = assessment_type;
    }

    public void setAssessment_status(AssessmentStatus assessment_status) {
        this.assessment_status = assessment_status;
    }
}
