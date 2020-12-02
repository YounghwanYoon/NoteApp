package com.ray.noteapp.di

import com.ray.noteapp.model.repository.MainRepository
import com.ray.noteapp.model.repository.retrofit.NetworkMapper
import com.ray.noteapp.model.repository.retrofit.NoteRetrofit
import com.ray.noteapp.model.repository.room.CacheMapper
import com.ray.noteapp.model.repository.room.NoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        noteDao:NoteDao,
        retrofit: NoteRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ):MainRepository{
        return MainRepository(noteDao, retrofit, cacheMapper, networkMapper)
    }
}