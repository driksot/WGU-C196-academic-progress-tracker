package com.example.academicprogresstracker.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.academicprogresstracker.Entity.Note;
import com.example.academicprogresstracker.R;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private LayoutInflater mInflater;
    private List<Note> mNotes;
    private OnItemClickListener listener;

    public class NoteViewHolder extends RecyclerView.ViewHolder {

        private final TextView noteTitleTextView;
        private final TextView noteDescriptionTextView;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            noteTitleTextView = itemView.findViewById(R.id.note_title_tv);
            noteDescriptionTextView = itemView.findViewById(R.id.update_note_description_et);

            itemView.setOnClickListener(view -> {
                int position = getAdapterPosition();
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(mNotes.get(position));
                }
            });
        }
    }

    public NoteAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.note_list_item, parent, false);
        return new NoteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        if (mNotes != null) {
            Note current = mNotes.get(position);
            holder.noteTitleTextView.setText(current.getNote_title());
            holder.noteDescriptionTextView.setText(current.getNote_description());
        } else {
            holder.noteTitleTextView.setText("Note details unavailable");
            holder.noteDescriptionTextView.setText("Note details unavailable");
        }
    }

    public void setNotes(List<Note> notes) {
        mNotes = notes;
        notifyDataSetChanged();
    }

    public Note getNoteAt(int position) {
        return mNotes.get(position);
    }

    public Note remove(int position) {
        if (position < getItemCount() && position >= 0) {
            Note note = mNotes.remove(position);
            notifyItemRemoved(position);
            return note;
        }
        return null;
    }

    public void add(Note note, int position) {
        mNotes.add(position, note);
        notifyItemInserted(position);
    }

    @Override
    public int getItemCount() {
        if (mNotes != null)
            return mNotes.size();
        else return 0;
    }

    public interface OnItemClickListener {
        void onItemClick(Note note);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
