package com.example.academicprogresstracker.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.academicprogresstracker.DAO.AssessmentDao;
import com.example.academicprogresstracker.DAO.CourseDao;
import com.example.academicprogresstracker.DAO.NoteDao;
import com.example.academicprogresstracker.DAO.TermDao;
import com.example.academicprogresstracker.Entity.Assessment;
import com.example.academicprogresstracker.Entity.Course;
import com.example.academicprogresstracker.Entity.Note;
import com.example.academicprogresstracker.Entity.Term;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Room database using ExecutorService and fixed thread pool
 *
 * @author derricksouthworth
 */
@Database(entities = {Term.class, Course.class, Assessment.class, Note.class},
        version = 1, exportSchema = false)
public abstract class ProgressTrackerDatabase extends RoomDatabase {

    public abstract TermDao termDao();
    public abstract CourseDao courseDao();
    public abstract AssessmentDao assessmentDao();
    public abstract NoteDao noteDao();

    private static volatile ProgressTrackerDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    // Singleton
    static ProgressTrackerDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ProgressTrackerDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ProgressTrackerDatabase.class, "progress_tracker_database.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
