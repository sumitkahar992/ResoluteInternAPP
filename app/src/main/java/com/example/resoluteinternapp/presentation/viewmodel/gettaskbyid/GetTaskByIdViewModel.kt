package com.example.resoluteinternapp.presentation.viewmodel.gettaskbyid

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.resoluteinternapp.domain.model.Tea
import com.example.resoluteinternapp.domain.usecase.GetTaskByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetTaskByIdViewModel @Inject constructor(
    private val getTaskByIdUseCase: GetTaskByIdUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {


    private val _task: MutableState<Tea> = mutableStateOf(Tea())
    val task: State<Tea> get() = _task

    private val _uiEvent: MutableSharedFlow<GetTaskByIdScreenEvent> = MutableSharedFlow()
    val uiEvent: SharedFlow<GetTaskByIdScreenEvent> get() = _uiEvent


    init {
        savedStateHandle.get<Int>("id")?.let { taskId ->
            viewModelScope.launch {
                getTaskByIdUseCase(taskId)?.also { task ->
                    _task.value = task
                }
            }
        }

    }




}