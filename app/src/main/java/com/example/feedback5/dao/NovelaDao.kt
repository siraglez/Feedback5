package com.example.feedback5.dao

import androidx.room.*
import com.example.feedback5.dataClasses.Novela

@Dao
interface NovelaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun agregarNovela(novela: Novela)

    @Query("DELETE FROM novelas WHERE titulo = :titulo")
    suspend fun eliminarNovela(titulo: String)

    @Query("SELECT * FROM novelas")
    suspend fun obtenerNovelas(): List<Novela>

    @Query("SELECT * FROM novelas WHERE esFavorita = 1")
    suspend fun obtenerNovelasFavoritas(): List<Novela>

    @Query("UPDATE novelas SET esFavorita = :esFavorita WHERE titulo = :titulo")
    suspend fun actualizarFavorito(titulo: String, esFavorita: Boolean)
}
