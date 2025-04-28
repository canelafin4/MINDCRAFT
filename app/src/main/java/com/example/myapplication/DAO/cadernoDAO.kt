package com.example.myapplication.DAO

import com.example.myapplication.model.Caderno
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface CadernoDao {
    @Insert fun insert(caderno: Caderno): Long
    @Query("SELECT * FROM Caderno") fun getAll(): List<Caderno>
}