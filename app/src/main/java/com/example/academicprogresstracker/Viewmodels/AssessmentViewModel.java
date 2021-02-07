package com.example.academicprogresstracker.Viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.academicprogresstracker.Database.ProgressTrackerRepository;
import com.example.academicprogresstracker.Entity.Assessment;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Wrapper methods to call Repository methods and ensure encapsulation from UI
 */
public class AssessmentViewModel extends AndroidViewModel {

    private ProgressTrackerRepository mRepository;
    private LiveData<List<Assessment>> mAllAssessments;
    private Executor executor = Executors.newSingleThreadExecutor();

    public MutableLiveData<Assessment> mCurrentAssessment = new MutableLiveData<>();

    public AssessmentViewModel(@NonNull Application application) {
        super(application);
        mRepository = new ProgressTrackerRepository(application);
        mAllAssessments = mRepository.getAllAssessments();
    }

    public void loadAssessment(int assessmentId) {
        executor.execute(() -> {
            Assessment assessment = mRepository.getAssessmentById(assessmentId);
            mCurrentAssessment.postValue(assessment);
        });
    }

    public void insert(Assessment assessment) {
        mRepository.insertAssessment(assessment);
    }

    public void update(Assessment assessment) {
        mRepository.updateAssessment(assessment);
    }

    public void delete(Assessment assessment) {
        mRepository.deleteAssessment(assessment);
    }

    public void deleteAllAssessments() {
        mRepository.deleteAllAssessments();
    }

    public LiveData<List<Assessment>> getAllAssessments() {
        return mAllAssessments;
    }

    public LiveData<List<Assessment>> getAssessmentsByCourse(int courseId) {
        return mRepository.getAssessmentsByCourse(courseId);
    }

    public LiveData<Integer> getAssessmentStatusCount(String statusType) {
        return mRepository.getAssessmentStatusCount(statusType);
    }

    public Assessment getAssessmentById(int assessmentId) {
        return mRepository.getAssessmentById(assessmentId);
    }
}
