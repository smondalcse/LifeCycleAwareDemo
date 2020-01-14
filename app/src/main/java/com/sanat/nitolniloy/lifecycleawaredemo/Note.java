package com.sanat.nitolniloy.lifecycleawaredemo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Note {

    @PrimaryKey
    @NonNull
    private String id;

    @NonNull
    @ColumnInfo(name = "note")
    private String mNote;

    public Note(String id, String note) {
        this.id = id;
        this.mNote = note;
    }

    public String getId() {
        return id;
    }

    public String getNote() {
        return mNote;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNote(String note) {
        this.mNote = note;
    }
}
