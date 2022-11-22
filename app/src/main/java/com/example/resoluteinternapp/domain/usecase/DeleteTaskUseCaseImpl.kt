package com.example.resoluteinternapp.domain.usecase

import com.example.resoluteinternapp.domain.model.Tea
import com.example.resoluteinternapp.domain.repository.TeaRepository
import javax.inject.Inject

class DeleteTaskUseCaseImpl @Inject constructor(
    private val repository: TeaRepository
) : DeleteTaskUseCase {


    override suspend fun invoke(task: Tea) {
        repository.deleteTask(task)
    }


}