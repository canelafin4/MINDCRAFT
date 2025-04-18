package com.example.myapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Materias(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val notas: String,
    val pesoDosCritérios: String,
    val soma: Int
)
