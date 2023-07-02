package com.nagem.pokemoncompose.model

data class PokemonResult(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)