package com.example.academicprogresstracker.Viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.academicprogresstracker.Database.ProgressTrackerRepository;
import com.example.academicprogresstracker.Entity.Term;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Wrapper methods to call Repository methods and ensure encapsulation from UI
 */
public class TermViewModel extends AndroidViewModel {

    private ProgressTrackerRepository mRepository;
    private LiveData<List<Term>> mAllTerms;
    private Executor executor = Executors.newSingleThreadExecutor();

    private MutableLiveData<Boolean> emptyTermTable = new MutableLiveData<>(false);
    public MutableLiveData<Term> mCurrentTerm = new MutableLiveData<>();

    public void checkIfTermTableIsEmpty(List<Term> terms) {
        getEmptyTermTable().setValue(terms.isEmpty());
    }

    public TermViewModel(@NonNull Application application) {
        super(application);
        mRepository = new ProgressTrackerRepository(application);
        mAllTerms = mRepository.getAllTerms();
    }

    public void loadTerm(int termId) {
        executor.execute(() -> {
            Term term = mRepository.getTermById(termId);
            mCurrentTerm.postValue(term);
        });
    }

    public void insert(Term term) { mRepository.insertTerm(term);
    }

    public void update(Term term) {
        mRepository.updateTerm(term);
    }

    public void delete(Term term) {
        mRepository.deleteTerm(term);
    }

    public void deleteAllTerms() {
        mRepository.deleteAllTerms();
    }

    public LiveData<List<Term>> getAllTerms() {
        return mAllTerms;
    }

    public Term getTermById(int termId) {
        return mRepository.getTermById(termId);
    }

    public MutableLiveData<Boolean> getEmptyTermTable() {
        return emptyTermTable;
    }
}
