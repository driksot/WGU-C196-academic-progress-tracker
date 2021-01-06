package com.example.academicprogresstracker.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.academicprogresstracker.Entity.Assessment;

import java.util.List;

/**
 * Room DAO for Assessment Entity
 *
 * @author derricksouthworth
 */
@Dao
public interface AssessmentDao {

    @Insert
    void insert(Assessment assessment);

    @Update
    void update(Assessment assessment);

    @Delete
    void delete(Assessment assessment);

    @Query("DELETE FROM assessment_table")
    void deleteAllAssessments();

    @Query("SELECT * FROM assessment_table")
    LiveData<List<Assessment>> getAllAssessments();

    @Query("SELECT * FROM assessment_table WHERE assessment_id = :assessmentId")
    Assessment getAssessmentById(int assessmentId);

    @Query("SELECT * FROM assessment_table WHERE course_id = :courseId")
    LiveData<List<Assessment>> getAssessmentsByCourse(int courseId);

    @Query("SELECT COUNT(*) FROM assessment_table WHERE assessment_status = :assessmentType")
    LiveData<Integer> getAssessmentStatusCount(String assessmentType);
}
