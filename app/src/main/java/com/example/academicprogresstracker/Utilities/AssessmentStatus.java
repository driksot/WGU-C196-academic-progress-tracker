package com.example.academicprogresstracker.Utilities;

import androidx.annotation.NonNull;

/**
 * Use for custom type in Assessment Entities
 *
 * @author derricksouthworth
 */
public enum AssessmentStatus {

    PENDING {
        @NonNull
        @Override
        public String toString() { return "Pending"; }
    },
    PASSED {
        @NonNull
        @Override
        public String toString() { return "Passed"; }
    },
    FAILED {
        @NonNull
        @Override
        public String toString() { return "Failed"; }
    }
}
