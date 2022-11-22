package com.example.resoluteinternapp.presentation.viewmodel.gettaskbyid

sealed class GetTaskByIdScreenEvent {
    object EditTaskSuccess : GetTaskByIdScreenEvent()
    data class EditTaskFailed(val message: String) : GetTaskByIdScreenEvent()
}
