package com.example.academicprogresstracker.Utilities;

import androidx.room.TypeConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Converters {

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    @TypeConverter
    public LocalDate fromTimestamp(Long timestamp) {
        return timestamp == null ? null : LocalDate.ofEpochDay(timestamp);
    }

    @TypeConverter
    public Long localDateToTimestamp(LocalDate date) {
        return date == null ? null : date.toEpochDay();
    }

    @TypeConverter
    public CourseStatus courseStatusFromString(String status) {
        return CourseStatus.valueOf(status);
    }

    @TypeConverter
    public String courseStatusToString(CourseStatus courseStatus) {
        return courseStatus.name();
    }

    @TypeConverter
    public AssessmentStatus assessmentStatusFromString(String status) {
        return AssessmentStatus.valueOf(status);
    }

    @TypeConverter
    public String assessmentStatusToString(AssessmentStatus assessmentStatus) {
        return assessmentStatus.name();
    }

    @TypeConverter
    public AssessmentType typeFromString(String type) {
        return AssessmentType.valueOf(type);
    }

    @TypeConverter
    public String typeToString(AssessmentType assessmentType) {
        return assessmentType.name();
    }

    public static String dateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.format(date);
    }

    /**
     * Convert String date to Calendar catch ParseException
     * if given string cannot be parsed to Date
     * @param strDate
     * @return
     */
    public static Calendar stringToCal(String strDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date date = null;
        try {
            date = sdf.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
}
