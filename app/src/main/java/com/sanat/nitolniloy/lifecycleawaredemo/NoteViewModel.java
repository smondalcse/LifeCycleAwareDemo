package com.sanat.nitolniloy.lifecycleawaredemo;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class NoteViewModel extends AndroidViewModel {
    private static final String TAG = "NoteViewModel";

    private NoteDAO noteDAO;
    private NoteRoomDatabase noteDB;

    public NoteViewModel(@NonNull Application application) {
        super(application);

        noteDB = NoteRoomDatabase.getDatabase(application);
        noteDAO = noteDB.noteDao();
    }
    
    public void insert(Note note) {
        new InsertAsyncTask(noteDAO).execute(note);
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
