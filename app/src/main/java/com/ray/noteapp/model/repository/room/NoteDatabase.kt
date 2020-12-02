package com.ray.noteapp.model.repository.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ray.noteapp.model.data.NoteCacheEntity

@Database(entities=[NoteCacheEntity::class], version = 1)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao():NoteDao
    companion object{
        val DATABASE_NAME:String = "note_db"
    }
}