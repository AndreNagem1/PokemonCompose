package com.nagem.pokemoncompose.di.modules

import com.nagem.pokemoncompose.data.PokemonRepository
import com.nagem.pokemoncompose.search.PokemonSearchViewModel
import org.koin.dsl.module

val viewModelModules = module {
    single { provideViewModelModule(get()) }
}

fun provideViewModelModule(pokemonRepository: PokemonRepository): PokemonSearchViewModel {
    return PokemonSearchViewModel(pokemonRepository)
}