package com.example.resoluteinternapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.resoluteinternapp.domain.model.Tea


@Database(
    entities = [Tea::class],
    version = 1 ,
    exportSchema = false
)
abstract class TeaDatabase : RoomDatabase() {

    abstract fun taskDAO(): TeaDao


}