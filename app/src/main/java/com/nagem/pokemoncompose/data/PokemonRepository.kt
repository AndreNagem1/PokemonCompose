package com.nagem.pokemoncompose.data

import com.nagem.pokemoncompose.model.PokemonResult

interface PokemonRepository {
   suspend fun searchPokemon(name: String) : AsyncResult<PokemonResult>
}