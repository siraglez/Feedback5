package com.example.feedback5.baseDeDatos

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.feedback5.dao.NovelaDao
import com.example.feedback5.dao.ResenaDao
import com.example.feedback5.dao.UsuarioDao
import com.example.feedback5.dataClasses.*

@Database(
    entities = [Usuario::class, Novela::class, Resena::class],
    version = 1,
    exportSchema = true
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun usuarioDao(): UsuarioDao
    abstract fun novelaDao(): NovelaDao
    abstract fun resenaDao(): ResenaDao
}