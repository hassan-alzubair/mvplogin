package com.hassan.mvplogin.Home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hassan.mvplogin.Home.pojo.Note;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotesRecyclerAdapter extends RecyclerView.Adapter<NotesRecyclerAdapter.NoteViewHolder>{

    private Context context;
    private List<Note> notes;
    private OnNoteItemClickListener listener;

    public NotesRecyclerAdapter(Context context, List<Note> notes) {
        this.context = context;
        this.notes = notes;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NoteViewHolder(LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.textView.setText(notes.get(position).getName());
        holder.itemView.setOnClickListener(view -> {
            if (listener != null) {
                listener.onNoteClicked(notes.get(position));
            }
        });
    }

    public void setOnNoteItemClickListener(OnNoteItemClickListener listener){
        this.listener = listener;
    }
    @Override
    public int getItemCount() {
        return notes.size();
    }

    public static class NoteViewHolder extends RecyclerView.ViewHolder {

        @BindView(android.R.id.text1)
        TextView textView;

        public NoteViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public interface OnNoteItemClickListener{
        void onNoteClicked(Note note);
    }
}