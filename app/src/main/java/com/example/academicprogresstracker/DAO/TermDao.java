package com.example.academicprogresstracker.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.academicprogresstracker.Entity.Term;

import java.util.List;

/**
 * Room DAO for Term Entity
 *
 * @author derricksouthworth
 */
@Dao
public interface TermDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Term term);

    @Update
    void update(Term term);

    @Delete
    void delete(Term term);

    @Query("DELETE FROM term_table")
    void deleteAllTerms();

    @Query("SELECT * FROM term_table ORDER BY term_start ASC")
    LiveData<List<Term>> getAllTerms();

    @Query("SELECT * FROM term_table WHERE term_id = :termId")
    Term getTermById(int termId);
}
