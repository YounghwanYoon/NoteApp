package com.ray.noteapp.model.repository.retrofit

import com.ray.noteapp.model.data.NoteNetworkEntity
import retrofit2.http.GET

interface NoteRetrofit{

    @GET("Notes")
    suspend fun get():List<NoteNetworkEntity>
}