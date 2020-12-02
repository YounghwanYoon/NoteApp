package com.ray.noteapp.model.repository.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ray.noteapp.model.data.NoteCacheEntity

//what function like NoteRetrofit
@Dao
interface NoteDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(noteEntity:NoteCacheEntity):Long

    //getting data from db
    @Query ("SELECT * FROM notes")
    suspend fun get():List<NoteCacheEntity>
}