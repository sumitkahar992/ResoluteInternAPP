package com.example.resoluteinternapp.domain.usecase

import com.example.resoluteinternapp.domain.model.Tea
import com.example.resoluteinternapp.domain.repository.TeaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllTaskUseCaseImpl @Inject constructor(
    private val repository: TeaRepository
) : GetAllTaskUseCase {


    override suspend fun invoke(): Flow<List<Tea>> {
        return repository.getAllTask()
    }


}