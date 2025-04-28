package com.example.myapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Materia(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val notas: String,
    val pesoDosCritérios: String,
    val soma: Int,
    val converterPeso: Int
)

annotation class PrimaryKey(val autoGenerate: Boolean)
