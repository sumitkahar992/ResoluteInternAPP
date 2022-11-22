package com.example.resoluteinternapp.presentation.viewmodel.homescreen

import com.example.resoluteinternapp.domain.model.Tea

data class HomeScreenState(
    val tasks: List<Tea> = emptyList(),
    val taskClickedDelete: Tea = Tea()

)
