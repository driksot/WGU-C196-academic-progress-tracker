package com.example.academicprogresstracker.Viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.academicprogresstracker.Database.ProgressTrackerRepository;
import com.example.academicprogresstracker.Entity.Note;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Wrapper methods to call Repository methods and ensure encapsulation from UI
 */
public class NoteViewModel extends AndroidViewModel {

    private ProgressTrackerRepository mRepository;
    private Executor executor = Executors.newSingleThreadExecutor();

    public MutableLiveData<Note> mCurrentNote = new MutableLiveData<>();

    public NoteViewModel(@NonNull Application application) {
        super(application);
        mRepository = new ProgressTrackerRepository(application);
    }

    public void loadNote(int noteId) {
        executor.execute(() -> {
            Note note = mRepository.getNoteById(noteId);
            mCurrentNote.postValue(note);
        });
    }

    public void insert(Note note) {
        mRepository.insertNote(note);
    }

    public void update(Note note) {
        mRepository.updateNote(note);
    }

    public void delete(Note note) {
        mRepository.deleteNote(note);
    }

    public void deleteAllNotes() {
        mRepository.deleteAllNotes();
    }

    public LiveData<List<Note>> getNotesByCourse(int courseId) {
        return mRepository.getNotesByCourse(courseId);
    }

    public Note getNoteById(int noteId) {
        return mRepository.getNoteById(noteId);
    }
}
