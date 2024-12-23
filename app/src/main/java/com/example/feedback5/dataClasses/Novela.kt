package com.example.feedback5.dataClasses

import androidx.room.*
import java.io.Serializable

@Entity(tableName = "novelas")
data class Novela(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val titulo: String,
    val autor: String,
    val anioPublicacion: Int,
    val sinopsis: String,
    var esFavorita: Boolean = false,
    val resenas: MutableList<String> = mutableListOf()
) : Serializable
