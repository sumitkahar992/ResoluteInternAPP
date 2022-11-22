package com.example.resoluteinternapp.domain.usecase

import com.example.resoluteinternapp.domain.model.Tea
import com.example.resoluteinternapp.domain.repository.TeaRepository
import javax.inject.Inject

class GetTaskByIdUseCaseImpl @Inject constructor(
    private val repository: TeaRepository
) : GetTaskByIdUseCase {


    override suspend fun invoke(id: Int): Tea? {
        return repository.getTaskById(id)
    }


}