package com.nagem.pokemoncompose.data.datasource.network

import com.nagem.pokemoncompose.model.PokemonResult
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonDataSource {

    @GET("api/v2/pokemon/")
    suspend fun searchPokemon(
        @Query("name") name: String
    ): PokemonResult
}