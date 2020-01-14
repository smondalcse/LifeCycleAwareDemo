package com.sanat.nitolniloy.lifecycleawaredemo;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface NoteDAO {

    @Insert
    void insert(Note note);

}
