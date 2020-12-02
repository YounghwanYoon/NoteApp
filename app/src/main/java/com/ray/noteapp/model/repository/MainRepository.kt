package com.ray.noteapp.model.repository

import com.ray.noteapp.model.data.Note
import com.ray.noteapp.model.repository.retrofit.NetworkMapper
import com.ray.noteapp.model.repository.retrofit.NoteRetrofit
import com.ray.noteapp.model.repository.room.CacheMapper
import com.ray.noteapp.model.repository.room.NoteDao
import com.ray.noteapp.model.utils.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class MainRepository
constructor(
    private val noteDao: NoteDao,
    private val noteRetrofit: NoteRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
){
    suspend fun getNote(): Flow<DataState<List<Note>>> = flow{
        emit(DataState.Loading) //telling UI to show progress bar
        delay(500)
        try{
            val networkNotes = noteRetrofit.get()
            val notes= networkMapper.mapFromEntityList(networkNotes)
            for(note in notes){
                noteDao.insert(cacheMapper.maptoEntity(note))
            }
            val cachedNotes = noteDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachedNotes)))
        }catch (e:Exception){
            emit(DataState.Error(e))
        }

    }

}