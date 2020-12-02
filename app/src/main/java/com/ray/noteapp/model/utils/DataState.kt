package com.ray.noteapp.model.utils

sealed class DataState <out R> {

    data class Success<out T>(val data:T):DataState<T>()
    data class Error(val exeception:Exception):DataState<Nothing>()
    object Loading:DataState<Nothing>()

}