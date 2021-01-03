package com.example.academicprogresstracker.Utilities;

import androidx.annotation.NonNull;

/**
 * Use for custom type in Assessment Entities
 *
 * @author derricksouthworth
 */
public enum AssessmentType {

    PERFORMANCE_ASSESSMENT {
        @NonNull
        @Override
        public String toString() {
            return "Performance Assessment";
        }
    },
    OBJECTIVE_ASSESSMENT {
        @NonNull
        @Override
        public String toString() {
            return "Objective Assessment";
        }
    }
}
