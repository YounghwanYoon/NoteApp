package com.ray.noteapp.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ray.noteapp.model.data.Note
import com.ray.noteapp.model.data.NoteNetworkEntity
import com.ray.noteapp.model.repository.retrofit.NetworkMapper
import com.ray.noteapp.model.repository.retrofit.NoteRetrofit
import com.ray.noteapp.model.utils.EntityMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RetrofitModule {

/*
    //if it is not injected
    @Singleton
    @Provides
    fun provideNetworkMapper():EntityMapper<NoteNetworkEntity, Note>{
        return NetworkMapper()
    }

 */

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        //responsible for parsing json data and convert to java
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson:Gson): Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl("")
                //ToDo::Need to add firebase url
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideNoteService(retrofit: Retrofit.Builder): NoteRetrofit {
        return retrofit
            .build()
            .create(NoteRetrofit::class.java)
    }

}