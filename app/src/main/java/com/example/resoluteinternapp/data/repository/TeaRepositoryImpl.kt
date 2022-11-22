package com.example.resoluteinternapp.data.repository

import com.example.resoluteinternapp.data.database.TeaDao
import com.example.resoluteinternapp.domain.model.Tea
import com.example.resoluteinternapp.domain.repository.TeaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TeaRepositoryImpl @Inject constructor(
    private val _teaDao : TeaDao
) : TeaRepository {


    override fun getAllTask(): Flow<List<Tea>> {
        return _teaDao.getAllTask()
    }


    override suspend fun getTaskById(id: Int): Tea? {
       return _teaDao.getTaskById(id)
    }


    override suspend fun saveTask(task: Tea): Long {
        return _teaDao.saveTask(task)
    }


    override suspend fun deleteTask(task: Tea) {
        _teaDao.removeTask(task)
    }


}