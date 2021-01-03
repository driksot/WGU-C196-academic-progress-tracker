package com.example.academicprogresstracker.Entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

/**
 * Room Entity Note
 *
 * @author derricksouthworth
 */
@Entity(tableName = "note_table",
        foreignKeys = @ForeignKey(entity = Course.class,
        parentColumns = "course_id",
        childColumns = "course_id",
        onDelete = ForeignKey.CASCADE))
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int note_id;
    private int course_id;
    private String note_title;
    private String note_description;

    public Note(int course_id, String note_title, String note_description) {
        this.course_id = course_id;
        this.note_title = note_title;
        this.note_description = note_description;
    }

    // Getters

    public int getNote_id() {
        return note_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public String getNote_title() {
        return note_title;
    }

    public String getNote_description() {
        return note_description;
    }

    // Setters

    public void setNote_id(int note_id) {
        this.note_id = note_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public void setNote_title(String note_title) {
        this.note_title = note_title;
    }

    public void setNote_description(String note_description) {
        this.note_description = note_description;
    }
}
