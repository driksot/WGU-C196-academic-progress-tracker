package com.example.academicprogresstracker.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.academicprogresstracker.Entity.Term;
import com.example.academicprogresstracker.R;
import com.example.academicprogresstracker.Utilities.Converters;

import java.util.List;

public class TermAdapter extends RecyclerView.Adapter<TermAdapter.TermViewHolder> {

    private final LayoutInflater mInflater;
    private List<Term> mTerms;
    private OnItemClickListener listener;

    class TermViewHolder extends RecyclerView.ViewHolder {

        private final TextView termTitleTextView;
        private final TextView termDatesTextView;

        public TermViewHolder(@NonNull View itemView) {
            super(itemView);
            termTitleTextView = itemView.findViewById(R.id.term_list_title_tv);
            termDatesTextView = itemView.findViewById(R.id.term_list_dates_tv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(mTerms.get(position));
                    }
                }
            });
        }
    }

    public TermAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public TermViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.term_list_item, parent, false);
        return new TermViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TermViewHolder holder, int position) {
        if (mTerms != null) {

            Term current = mTerms.get(position);
            String strStart = current.getTerm_start().format(Converters.DATE_TIME_FORMATTER);
            String strEnd = current.getTerm_end().format(Converters.DATE_TIME_FORMATTER);

            holder.termTitleTextView.setText(current.getTerm_title());
            holder.termDatesTextView.setText(strStart + " - " + strEnd);
        } else {
            holder.termTitleTextView.setText("Term Title Unavailable");
            holder.termDatesTextView.setText("No start or end dates");
        }
    }

    public void setTerms(List<Term> terms) {
        mTerms = terms;
        notifyDataSetChanged();
    }

    public Term getTermAt(int position) {
        return mTerms.get(position);
    }

    public Term remove(int position) {
        if (position < getItemCount() && position >= 0) {
            Term term = mTerms.remove(position);
            notifyItemRemoved(position);
            return term;
        }
        return null;
    }

    public void add(Term term, int position) {
        mTerms.add(position, term);
        notifyItemInserted(position);
    }

    @Override
    public int getItemCount() {
        if (mTerms != null)
            return mTerms.size();
        else return 0;
    }

    public interface OnItemClickListener {
        void onItemClick(Term term);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
