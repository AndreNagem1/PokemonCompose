package com.nagem.pokemoncompose.di

import com.nagem.pokemoncompose.di.modules.apiModules
import com.nagem.pokemoncompose.di.modules.repositoryModules
import com.nagem.pokemoncompose.di.modules.viewModelModules

val appModules = listOf(
    apiModules,
    repositoryModules,
    viewModelModules
)