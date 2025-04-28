package com.example.myapplication.DAO

import com.example.myapplication.model.Anotacao
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AnotacaoDao {
    @Insert fun insert(anotacao: Anotacao): Long
    @Query("SELECT * FROM Anotacao") fun getAll(): List<Anotacao>
}