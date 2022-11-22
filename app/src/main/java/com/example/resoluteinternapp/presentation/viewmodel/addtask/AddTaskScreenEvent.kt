package com.example.resoluteinternapp.presentation.viewmodel.addtask

sealed class AddTaskScreenEvent {
    object SaveTaskSuccess : AddTaskScreenEvent()
    data class SaveTaskFailed(val message: String) : AddTaskScreenEvent()
}
