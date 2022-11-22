package com.example.resoluteinternapp.presentation.viewmodel.addtask

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.resoluteinternapp.domain.model.Tea
import com.example.resoluteinternapp.domain.model.emptyString
import com.example.resoluteinternapp.domain.usecase.SaveTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddTaskViewModel @Inject constructor(
    private val saveTaskUseCase: SaveTaskUseCase
) : ViewModel() {

    private val _task: MutableState<Tea> = mutableStateOf(Tea())
    val task: State<Tea> get() = _task

    private val _uiEvent: MutableSharedFlow<AddTaskScreenEvent> = MutableSharedFlow()
    val uiEvent: SharedFlow<AddTaskScreenEvent> get() = _uiEvent


    fun onSaveTask() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val task = _task.value
                saveTaskUseCase(task)
                _uiEvent.emit(AddTaskScreenEvent.SaveTaskSuccess)
            }catch (e: Exception) {
                _uiEvent.emit(AddTaskScreenEvent.SaveTaskFailed(e.message ?: emptyString()))
            }
        }
    }









}