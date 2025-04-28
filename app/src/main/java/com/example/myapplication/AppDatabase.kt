package com.example.myapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.model.Anotacao
import com.example.myapplication.DAO.AnotacaoDao

@Database(entities = [Anotacao::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun anotacaoDao(): AnotacaoDao
}
