package com.example.academicprogresstracker.Database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.academicprogresstracker.DAO.AssessmentDao;
import com.example.academicprogresstracker.DAO.CourseDao;
import com.example.academicprogresstracker.DAO.NoteDao;
import com.example.academicprogresstracker.DAO.TermDao;
import com.example.academicprogresstracker.Entity.Assessment;
import com.example.academicprogresstracker.Entity.Course;
import com.example.academicprogresstracker.Entity.Note;
import com.example.academicprogresstracker.Entity.Term;

import java.util.List;

public class ProgressTrackerRepository {

    private TermDao mTermDao;
    private CourseDao mCourseDao;
    private AssessmentDao mAssessmentDao;
    private NoteDao mNoteDao;
    private LiveData<List<Term>> mAllTerms;
    private LiveData<List<Course>> mAllCourses;
    private LiveData<List<Assessment>> mAllAssessments;

    public ProgressTrackerRepository(Application application) {
        ProgressTrackerDatabase db = ProgressTrackerDatabase.getDatabase(application);
        mTermDao = db.termDao();
        mCourseDao = db.courseDao();
        mAssessmentDao = db.assessmentDao();
        mNoteDao = db.noteDao();
        mAllTerms = mTermDao.getAllTerms();
        mAllCourses = mCourseDao.getAllCourses();
        mAllAssessments = mAssessmentDao.getAllAssessments();

        // delay so the constructor has time to complete asynchronous tasks
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /***********************************************************************************************
     * Term Entity db operations
     **********************************************************************************************/

    public void insertTerm(Term term) {
        ProgressTrackerDatabase.databaseWriteExecutor.execute(() -> {
            mTermDao.insert(term);
        });
    }

    public void updateTerm(Term term) {
        ProgressTrackerDatabase.databaseWriteExecutor.execute(() -> {
            mTermDao.update(term);
        });
    }

    public void deleteTerm(Term term) {
        ProgressTrackerDatabase.databaseWriteExecutor.execute(() -> {
            mTermDao.delete(term);
        });
    }

    public void deleteAllTerms() {
        ProgressTrackerDatabase.databaseWriteExecutor.execute(() -> {
            mTermDao.deleteAllTerms();
        });
    }

    public LiveData<List<Term>> getAllTerms() {
        return mAllTerms;
    }

    public Term getTermById(int termId) {
        return mTermDao.getTermById(termId);
    }

    /***********************************************************************************************
     * Course Entity db operations
     **********************************************************************************************/

    public void insertCourse(Course course) {
        ProgressTrackerDatabase.databaseWriteExecutor.execute(() -> {
            mCourseDao.insert(course);
        });
    }

    public void updateCourse(Course course) {
        ProgressTrackerDatabase.databaseWriteExecutor.execute(() -> {
            mCourseDao.update(course);
        });
    }

    public void deleteCourse(Course course) {
        ProgressTrackerDatabase.databaseWriteExecutor.execute(() -> {
            mCourseDao.delete(course);
        });
    }

    public void deleteAllCourses() {
        ProgressTrackerDatabase.databaseWriteExecutor.execute(() -> {
            mCourseDao.deleteAllCourses();
        });
    }

    public LiveData<List<Course>> getAllCourses() {
        return mAllCourses;
    }

    public LiveData<List<Course>> getCoursesByTerm(int termId) {
        return mCourseDao.getCoursesByTerm(termId);
    }

    public Course getCourseById(int courseId) {
        return mCourseDao.getCourseById(courseId);
    }

    public LiveData<Integer> getCourseStatusCount(String statusType) {
        return mCourseDao.getCourseStatusCount(statusType);
    }

    /***********************************************************************************************
     * Assessment Entity db operations
     **********************************************************************************************/

    public void insertAssessment(Assessment assessment) {
        ProgressTrackerDatabase.databaseWriteExecutor.execute(() -> {
            mAssessmentDao.insert(assessment);
        });
    }

    public void updateAssessment(Assessment assessment) {
        ProgressTrackerDatabase.databaseWriteExecutor.execute(() -> {
            mAssessmentDao.update(assessment);
        });
    }

    public void deleteAssessment(Assessment assessment) {
        ProgressTrackerDatabase.databaseWriteExecutor.execute(() -> {
            mAssessmentDao.delete(assessment);
        });
    }

    public void deleteAllAssessments() {
        ProgressTrackerDatabase.databaseWriteExecutor.execute(() -> {
            mAssessmentDao.deleteAllAssessments();
        });
    }

    public LiveData<List<Assessment>> getAllAssessments() {
        return mAllAssessments;
    }

    public LiveData<List<Assessment>> getAssessmentsByCourse(int courseId) {
        return mAssessmentDao.getAssessmentsByCourse(courseId);
    }

    public LiveData<Integer> getAssessmentStatusCount(String statusType) {
        return mAssessmentDao.getAssessmentStatusCount(statusType);
    }

    public Assessment getAssessmentById(int assessmentId) {
        return mAssessmentDao.getAssessmentById(assessmentId);
    }

    /***********************************************************************************************
     * Note Entity db operations
     **********************************************************************************************/

    public void insertNote(Note note) {
        ProgressTrackerDatabase.databaseWriteExecutor.execute(() -> {
            mNoteDao.insert(note);
        });
    }

    public void updateNote(Note note) {
        ProgressTrackerDatabase.databaseWriteExecutor.execute(() -> {
            mNoteDao.update(note);
        });
    }

    public void deleteNote(Note note) {
        ProgressTrackerDatabase.databaseWriteExecutor.execute(() -> {
            mNoteDao.delete(note);
        });
    }

    public void deleteAllNotes() {
        ProgressTrackerDatabase.databaseWriteExecutor.execute(() -> {
            mNoteDao.deleteAllNotes();
        });
    }

    public LiveData<List<Note>> getNotesByCourse(int courseId) {
        return mNoteDao.getNotesByCourse(courseId);
    }

    public Note getNoteById(int noteId) {
        return mNoteDao.getNoteById(noteId);
    }
}
