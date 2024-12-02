package com.example.feedback5.dao

import androidx.room.*
import com.example.feedback5.dataClasses.Resena

@Dao
interface ResenaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun agregarResena(resena: Resena)

    @Query("SELECT * FROM resenas WHERE tituloNovela = :titulo")
    suspend fun obtenerResenasPorTitulo(titulo: String): List<Resena>
}
