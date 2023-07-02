package com.nagem.pokemoncompose.di.modules

import com.nagem.pokemoncompose.data.PokemonRepositoryImpl
import com.nagem.pokemoncompose.data.PokemonRepository
import com.nagem.pokemoncompose.data.datasource.network.PokemonDataSource
import org.koin.dsl.module

val repositoryModules = module {
    single<PokemonRepository> { providePokemonRepository(get()) }
}

fun providePokemonRepository(pokemonDataSource: PokemonDataSource): PokemonRepositoryImpl {
    return PokemonRepositoryImpl(pokemonDataSource)
}