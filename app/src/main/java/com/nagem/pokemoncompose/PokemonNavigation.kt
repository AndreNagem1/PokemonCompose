package com.nagem.pokemoncompose

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.nagem.pokemoncompose.PokemonScreens.POKEMON_LIST_SCREEN
import com.nagem.pokemoncompose.PokemonScreens.POKEMON_SEARCH_SCREEN

private object PokemonScreens {
    const val POKEMON_LIST_SCREEN = "list"
    const val POKEMON_SEARCH_SCREEN = "search"
}


object PokemonDestinations {
    const val POKEMON_LIST_ROUTE = POKEMON_LIST_SCREEN
    const val POKEMON_SEARCH_ROUTE = POKEMON_SEARCH_SCREEN
}

class PokemonNavigationActions(private val navController: NavHostController) {

    fun navigateToSearch() {
        navController.navigate(PokemonDestinations.POKEMON_SEARCH_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}