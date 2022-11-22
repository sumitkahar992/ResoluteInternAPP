package com.example.resoluteinternapp.domain.usecase

import com.example.resoluteinternapp.domain.model.Tea
import com.example.resoluteinternapp.domain.repository.TeaRepository
import javax.inject.Inject

class SaveTaskUseCaseImpl @Inject constructor(
    private val repository: TeaRepository
) : SaveTaskUseCase {


    override suspend operator fun invoke(task: Tea) {
        repository.saveTask(task)
    }


}