package com.example.academicprogresstracker.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.academicprogresstracker.Entity.Course;
import com.example.academicprogresstracker.R;
import com.example.academicprogresstracker.Utilities.Converters;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    private final LayoutInflater mInflater;
    private List<Course> mCourses;
    private OnItemClickListener listener;

    public class CourseViewHolder extends RecyclerView.ViewHolder {

        private final TextView courseTitleTextView;
        private final TextView courseDatesTextView;
        private final TextView courseStatusTextView;
        private final TextView mentorNameTextView;
        private final TextView mentorEmailTextView;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            courseTitleTextView = itemView.findViewById(R.id.course_list_title_tv);
            courseDatesTextView = itemView.findViewById(R.id.course_list_dates_tv);
            courseStatusTextView = itemView.findViewById(R.id.course_list_status_tv);
            mentorNameTextView = itemView.findViewById(R.id.course_list_mentor_name_tv);
            mentorEmailTextView = itemView.findViewById(R.id.course_list_mentor_email_tv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(mCourses.get(position));
                    }
                }
            });
        }
    }

    public CourseAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.course_list_item, parent, false);
        return new CourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        if (mCourses != null) {

            Course current = mCourses.get(position);
            String strStart = current.getCourse_start().format(Converters.DATE_TIME_FORMATTER);
            String strEnd = current.getCourse_end().format(Converters.DATE_TIME_FORMATTER);

            holder.courseTitleTextView.setText(current.getCourse_title());
            holder.courseDatesTextView.setText(strStart + " - " + strEnd);
            holder.courseStatusTextView.setText(current.getCourse_status().toString());
            holder.mentorNameTextView.setText(current.getCourse_mentor_name());
            holder.mentorEmailTextView.setText(current.getCourse_mentor_email());
        } else {
            holder.courseTitleTextView.setText("Course details unavailable");
            holder.courseDatesTextView.setText("Course details unavailable");
            holder.courseStatusTextView.setText("Course details unavailable");
            holder.mentorNameTextView.setText("Course details unavailable");
            holder.mentorEmailTextView.setText("Course details unavailable");
        }
    }

    public void setCourses(List<Course> courses) {
        mCourses = courses;
        notifyDataSetChanged();
    }

    public Course getCourseAt(int position) {
        return mCourses.get(position);
    }

    public Course remove(int position) {
        if (position < getItemCount() && position >= 0) {
            Course course = mCourses.remove(position);
            notifyItemRemoved(position);
            return course;
        }
        return null;
    }

    public void add(Course course, int position) {
        mCourses.add(position, course);
        notifyItemInserted(position);
    }

    @Override
    public int getItemCount() {
        if (mCourses != null)
            return mCourses.size();
        else return 0;
    }

    public interface OnItemClickListener {
        void onItemClick(Course course);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
