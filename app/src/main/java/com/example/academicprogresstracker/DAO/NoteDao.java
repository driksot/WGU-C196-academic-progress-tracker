package com.example.academicprogresstracker.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.academicprogresstracker.Entity.Note;

import java.util.List;

/**
 * Room DAO for Note Entity
 *
 * @author derricksouthworth
 */
@Dao
public interface NoteDao {

    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    @Query("DELETE FROM note_table")
    void deleteAllNotes();

    @Query("SELECT * FROM note_table WHERE course_id = :courseId")
    LiveData<List<Note>> getNotesByCourse(int courseId);

    @Query("SELECT * FROM note_table WHERE note_id = :noteId")
    Note getNoteById(int noteId);
}
