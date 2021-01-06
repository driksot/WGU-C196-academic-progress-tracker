package com.example.academicprogresstracker.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.academicprogresstracker.Entity.Course;

import java.util.List;

/**
 * Room DAO for Course Entity
 *
 * @author derricksouthworth
 */
@Dao
public interface CourseDao {

    @Insert
    void insert(Course course);

    @Update
    void update(Course course);

    @Delete
    void delete(Course course);

    @Query("DELETE FROM course_table")
    void deleteAllCourses();

    @Query("SELECT * FROM course_table")
    LiveData<List<Course>> getAllCourses();

    @Query("SELECT * FROM course_table WHERE course_id = :courseId")
    Course getCourseById(int courseId);

    @Query("SELECT * FROM course_table WHERE term_id = :termId")
    LiveData<List<Course>> getCoursesByTerm(int termId);

    @Query("SELECT COUNT(*) FROM course_table WHERE course_status = :statusType")
    LiveData<Integer> getCourseStatusCount(String statusType);
}
