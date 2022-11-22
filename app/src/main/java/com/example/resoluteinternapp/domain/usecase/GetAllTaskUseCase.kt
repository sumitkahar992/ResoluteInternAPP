package com.example.resoluteinternapp.domain.usecase

import com.example.resoluteinternapp.domain.model.Tea
import kotlinx.coroutines.flow.Flow

interface GetAllTaskUseCase {

    suspend operator fun invoke() : Flow<List<Tea>>

}