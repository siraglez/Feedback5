package com.example.feedback5.dataClasses

data class Usuario(
    val email: String,
    val password: String,
    var temaOscuro: Boolean = false
)
