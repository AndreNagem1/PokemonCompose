package com.nagem.pokemoncompose.data.datasource.network

import com.nagem.pokemoncompose.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface PokemonDataSource {

    @GET
    suspend fun searchPokemon(
        @Url url: String
    ): PokemonResponse
}