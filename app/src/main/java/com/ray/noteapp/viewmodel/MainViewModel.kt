package com.ray.noteapp.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.ray.noteapp.model.data.Note
import com.ray.noteapp.model.repository.MainRepository
import com.ray.noteapp.model.utils.DataState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


class MainViewModel
@ViewModelInject
constructor(
    private val mainRepository: MainRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel()
{
    private val _dataState: MutableLiveData<DataState<List<Note>>> = MutableLiveData()
    val dataState: LiveData<DataState<List<Note>>>
        get() = _dataState

    fun setStateEvent(mainStateEvent:MainStateEvent){
        viewModelScope.launch {
            when(mainStateEvent){
                is MainStateEvent.GetNoteEvents ->{
                    mainRepository.getNote()
                        .onEach { dataState ->
                            _dataState.value = dataState
                        }
                        .launchIn(viewModelScope)
                }
                is MainStateEvent.None ->{
                    //
                }
            }
        }
    }
}

sealed class MainStateEvent{
    object GetNoteEvents: MainStateEvent()
    object None:MainStateEvent()
}