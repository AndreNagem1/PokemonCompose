package com.nagem.pokemoncompose.model

data class PokemonInfo(
    val name: String = "Pickachu",
    val type: String = "Electric",
    val height: Float = 0.6F,
    val weight: Float = 3F,
    val abilities: String = "Thunder"
)