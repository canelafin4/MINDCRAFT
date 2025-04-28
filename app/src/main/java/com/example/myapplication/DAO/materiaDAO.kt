package com.example.myapplication.dao

import com.example.myapplication.model.Materia
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface MateriaDao {
    @Insert fun insert(materia: Materia): Long
    @Query("SELECT * FROM Materia") fun getAll(): List<Materia>
}