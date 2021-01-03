package com.example.academicprogresstracker.Utilities;

import androidx.annotation.NonNull;

/**
 * Use for custom type in Course Entities
 *
 * @author derricksouthworth
 */
public enum CourseStatus {

    IN_PROGRESS {
        @NonNull
        @Override
        public String toString() {
            return "In Progress";
        }
    },
    COMPLETED {
        @NonNull
        @Override
        public String toString() {
            return "Completed";
        }
    },
    DROPPED {
        @NonNull
        @Override
        public String toString() {
            return "Dropped";
        }
    },
    PLAN_TO_TAKE {
        @NonNull
        @Override
        public String toString() {
            return "Plan to Take";
        }
    }
}
