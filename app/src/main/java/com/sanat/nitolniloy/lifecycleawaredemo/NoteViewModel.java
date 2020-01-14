package com.sanat.nitolniloy.lifecycleawaredemo;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class NoteViewModel extends AndroidViewModel {
    private static final String TAG = "NoteViewModel";

    private NoteDAO noteDAO;
    private NoteRoomDatabase noteDB;
    private LiveData<List<Note>> mAllNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);

        noteDB = NoteRoomDatabase.getDatabase(application);
        noteDAO = noteDB.noteDao();
        mAllNotes = noteDAO.getAllNotes();
    }
    
    public void insert(Note note) {
        new InsertAsyncTask(noteDAO).execute(note);
    }

    // Sence it is a live data so we can observe this data from main activity
    LiveData<List<Note>> getAllNotes(){
        return mAllNotes;
    }

    private class InsertAsyncTask extends AsyncTask<Note, Void, Void> {

        NoteDAO mNoteDAO;

        public InsertAsyncTask(NoteDAO noteDAO) {
            this.mNoteDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            mNoteDAO.insert(notes[0]);
            return null;
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "ViewModel Destroyed");
    }
}
