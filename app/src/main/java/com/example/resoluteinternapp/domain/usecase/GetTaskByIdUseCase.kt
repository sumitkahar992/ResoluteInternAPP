package com.example.resoluteinternapp.domain.usecase

import com.example.resoluteinternapp.domain.model.Tea

interface GetTaskByIdUseCase {


    suspend operator fun invoke(id: Int): Tea?


}