package com.example.resoluteinternapp.presentation.viewmodel.homescreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.resoluteinternapp.domain.local.getAllTea
import com.example.resoluteinternapp.domain.model.Tea
import com.example.resoluteinternapp.domain.usecase.DeleteTaskUseCase
import com.example.resoluteinternapp.domain.usecase.GetAllTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getAllTaskUseCase: GetAllTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase
) : ViewModel() {


    private val _uiState: MutableState<HomeScreenState> = mutableStateOf(HomeScreenState())
    val uiState: State<HomeScreenState> get() = _uiState

    private val _taskCache: MutableState<List<Tea>> = mutableStateOf(emptyList())

    init {
        viewModelScope.launch {
            getAllTaskUseCase().map { taskModel ->
                taskModel.map {
                    it
                }
            }.collect { tasks ->
                _taskCache.value = tasks
                _uiState.value = _uiState.value.copy(tasks = tasks)
            }
        }
    }

    fun onDeleteTask() {
        viewModelScope.launch {
            val task = _uiState.value.taskClickedDelete
            deleteTaskUseCase(task)
        }
    }

    fun onSetTaskDeleted(task: Tea) {
        _uiState.value = _uiState.value.copy(taskClickedDelete = task)
    }

}