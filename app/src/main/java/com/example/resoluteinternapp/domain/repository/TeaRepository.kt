package com.example.resoluteinternapp.domain.repository

import com.example.resoluteinternapp.domain.model.Tea
import kotlinx.coroutines.flow.Flow


interface TeaRepository {

    fun getAllTask() : Flow<List<Tea>>


    suspend fun getTaskById(id: Int) : Tea?


    suspend fun saveTask(task: Tea) : Long

    suspend fun deleteTask(task: Tea)


}