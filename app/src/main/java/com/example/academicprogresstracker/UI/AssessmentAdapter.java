package com.example.academicprogresstracker.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.academicprogresstracker.Entity.Assessment;
import com.example.academicprogresstracker.R;
import com.example.academicprogresstracker.Utilities.Converters;

import java.util.List;

public class AssessmentAdapter extends RecyclerView.Adapter<AssessmentAdapter.AssessmentViewHolder> {

    private LayoutInflater mInflater;
    private List<Assessment> mAssessments;
    private OnItemClickListener listener;

    public class AssessmentViewHolder extends RecyclerView.ViewHolder {

        private final TextView assessmentTitleTextView;
        private final TextView assessmentDateTextView;
        private final TextView assessmentTypeTextView;

        public AssessmentViewHolder(@NonNull View itemView) {
            super(itemView);
            assessmentTitleTextView = itemView.findViewById(R.id.assessment_list_title_tv);
            assessmentDateTextView = itemView.findViewById(R.id.assessment_list_date_tv);
            assessmentTypeTextView = itemView.findViewById(R.id.assessment_list_type_tv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(mAssessments.get(position));
                    }
                }
            });
        }
    }

    public AssessmentAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @NonNull
    @Override
    public AssessmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.assessment_list_item, parent, false);
        return new AssessmentViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AssessmentViewHolder holder, int position) {
        if (mAssessments != null) {

            Assessment current = mAssessments.get(position);
            String date = current.getAssessment_date().format(Converters.DATE_TIME_FORMATTER);

            holder.assessmentTitleTextView.setText(current.getAssessment_title());
            holder.assessmentDateTextView.setText(date);
            holder.assessmentTypeTextView.setText(current.getAssessment_type().toString());
        } else {
            holder.assessmentTitleTextView.setText("Assessment details unavailable");
            holder.assessmentDateTextView.setText("Assessment details unavailable");
            holder.assessmentTypeTextView.setText("Assessment details unavailable");
        }
    }

    public void setAssessments(List<Assessment> assessments) {
        mAssessments = assessments;
        notifyDataSetChanged();
    }

    public Assessment getAssessmentAt(int position) {
        return mAssessments.get(position);
    }

    public Assessment remove(int position) {
        if (position < getItemCount() && position >= 0) {
            Assessment assessment = mAssessments.remove(position);
            notifyItemRemoved(position);
            return assessment;
        }
        return null;
    }

    public void add(Assessment assessment, int position) {
        mAssessments.add(position, assessment);
        notifyItemInserted(position);
    }

    @Override
    public int getItemCount() {
        if (mAssessments != null)
            return mAssessments.size();
        else return 0;
    }

    public interface OnItemClickListener {
        void onItemClick(Assessment assessment);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
