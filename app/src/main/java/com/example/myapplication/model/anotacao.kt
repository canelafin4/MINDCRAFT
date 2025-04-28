package com.example.myapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity
data class Anotacao(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val tituloAnotacao: String,
    val texto: String
)
