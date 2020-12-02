package com.ray.noteapp.model.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class NoteCacheEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name ="id")
    var id: Int,

    @ColumnInfo(name ="title")
    var title: String,

    @ColumnInfo(name ="body")
    var body: String,

    @ColumnInfo(name ="time_updated")
    var time_update: Int,
){}