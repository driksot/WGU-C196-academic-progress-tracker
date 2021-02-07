package com.example.academicprogresstracker.Viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.academicprogresstracker.Database.ProgressTrackerRepository;
import com.example.academicprogresstracker.Entity.Course;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Wrapper methods to call Repository methods and ensure encapsulation from UI
 */
public class CourseViewModel extends AndroidViewModel {

    private ProgressTrackerRepository mRepository;
    private LiveData<List<Course>> mAllCourses;
    private Executor executor = Executors.newSingleThreadExecutor();

    private MutableLiveData<Boolean> emptyCourseTable = new MutableLiveData<>(false);

    public MutableLiveData<Course> mCurrentCourse = new MutableLiveData<>();

    public void checkIfCourseTableIsEmpty(List<Course> courses) {
        getEmptyCourseTable().setValue(courses.isEmpty());
    }

    public CourseViewModel(@NonNull Application application) {
        super(application);
        mRepository = new ProgressTrackerRepository(application);
        mAllCourses = mRepository.getAllCourses();
    }

    public void loadCourse(int courseId) {
        executor.execute(() -> {
            Course course = mRepository.getCourseById(courseId);
            mCurrentCourse.postValue(course);
        });
    }

    public void insert(Course course) {
        mRepository.insertCourse(course);
    }

    public void update(Course course) {
        mRepository.updateCourse(course);
    }

    public void delete(Course course) {
        mRepository.deleteCourse(course);
    }

    public void deleteAllCourses() {
        mRepository.deleteAllCourses();
    }

    public LiveData<List<Course>> getAllCourses() {
        return mAllCourses;
    }

    public LiveData<List<Course>> getCoursesByTerm(int termId) {
        return mRepository.getCoursesByTerm(termId);
    }

    public LiveData<Integer> getCourseStatusCount(String statusType) {
        return mRepository.getCourseStatusCount(statusType);
    }

    public Course getCourseById(int courseId) {
        return mRepository.getCourseById(courseId);
    }

    public MutableLiveData<Boolean> getEmptyCourseTable() {
        return emptyCourseTable;
    }
}
