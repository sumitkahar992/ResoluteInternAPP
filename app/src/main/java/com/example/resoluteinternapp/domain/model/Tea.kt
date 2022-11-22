package com.example.resoluteinternapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tea")
data class Tea(

    @PrimaryKey
    val id: Int? = null,

    val itemCount: Int = 0,
    val title: String = emptyString(),
    val description: String= emptyString(),
    val cost: Double = 0.0,
    val picture: Int = 0
)


fun emptyString(): String = ""