package com.example.academicprogresstracker.Entity;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.time.LocalDate;

/**
 * Room Entity Term
 *
 * @author derricksouthworth
 */
@Entity(tableName = "term_table")
public class Term {

    @PrimaryKey(autoGenerate = true)
    private int term_id;
    private String term_title;
    private LocalDate term_start;
    private LocalDate term_end;

    // Constructor
    public Term(String term_title, LocalDate term_start, LocalDate term_end) {
        this.term_title = term_title;
        this.term_start = term_start;
        this.term_end = term_end;
    }

    @Ignore
    public Term(int term_id, String term_title, LocalDate term_start, LocalDate term_end) {
        this.term_id = term_id;
        this.term_title = term_title;
        this.term_start = term_start;
        this.term_end = term_end;
    }

    // Getters
    public int getTerm_id() {
        return term_id;
    }

    public String getTerm_title() {
        return term_title;
    }

    public LocalDate getTerm_start() {
        return term_start;
    }

    public LocalDate getTerm_end() {
        return term_end;
    }

    // Setters
    public void setTerm_id(int term_id) {
        this.term_id = term_id;
    }

    public void setTerm_title(String term_title) {
        this.term_title = term_title;
    }

    public void setTerm_start(LocalDate term_start) {
        this.term_start = term_start;
    }

    public void setTerm_end(LocalDate term_end) {
        this.term_end = term_end;
    }

    @Override
    public String toString() {
        return term_title;
    }
}
