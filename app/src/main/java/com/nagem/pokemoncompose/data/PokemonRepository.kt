package com.nagem.pokemoncompose.data

import com.nagem.pokemoncompose.model.PokemonResponse

interface PokemonRepository {
   suspend fun searchPokemon(name: String) : AsyncResult<PokemonResponse>
}