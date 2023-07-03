package com.nagem.pokemoncompose.data

import com.nagem.pokemoncompose.data.AsyncResult.Success
import com.nagem.pokemoncompose.data.datasource.network.PokemonDataSource
import com.nagem.pokemoncompose.model.PokemonResponse
import com.nagem.pokemoncompose.model.PokemonResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonRepositoryImpl(private val pokemonDataSource: PokemonDataSource) : PokemonRepository {

    override suspend fun searchPokemon(name: String): AsyncResult<PokemonResponse> {
        return withContext(Dispatchers.IO) {
            try {
                Success(pokemonDataSource.searchPokemon("api/v2/pokemon/$name"))
            } catch (exception: Exception) {
                AsyncResult.Error(exception)
            }
        }
    }

}