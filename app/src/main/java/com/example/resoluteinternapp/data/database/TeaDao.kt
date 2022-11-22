package com.example.resoluteinternapp.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.resoluteinternapp.domain.model.Tea
import kotlinx.coroutines.flow.Flow

@Dao
interface TeaDao {


    @Query("select * from tea")
    fun getAllTask(): Flow<List<Tea>>


    @Query("SELECT * FROM tea WHERE id = :id")
    suspend fun getTaskById(id: Int) : Tea?

    @Insert
    suspend fun saveTask(tea: Tea) : Long


    @Delete
    suspend fun removeTask(tea: Tea)



}