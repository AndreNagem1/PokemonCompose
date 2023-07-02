package com.nagem.pokemoncompose.data

import com.nagem.pokemoncompose.data.AsyncResult.Success
import com.nagem.pokemoncompose.data.datasource.network.PokemonDataSource
import com.nagem.pokemoncompose.model.PokemonResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonRepositoryImpl(private val pokemonDataSource: PokemonDataSource) : PokemonRepository {

    override suspend fun searchPokemon(name: String): AsyncResult<PokemonResult> {
        return withContext(Dispatchers.IO) {
            try {
                Success(pokemonDataSource.searchPokemon(name))
            } catch (exception: Exception) {
                AsyncResult.Error(exception)
            }
        }
    }

}