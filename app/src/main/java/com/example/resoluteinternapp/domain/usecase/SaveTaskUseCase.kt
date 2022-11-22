package com.example.resoluteinternapp.domain.usecase

import com.example.resoluteinternapp.domain.model.Tea

interface SaveTaskUseCase {

    suspend operator fun invoke(task: Tea)

}