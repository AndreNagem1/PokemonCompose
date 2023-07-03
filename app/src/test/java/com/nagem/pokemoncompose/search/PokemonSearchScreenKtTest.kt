package com.nagem.pokemoncompose.search

import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import com.nagem.pokemoncompose.PokemonListScreen
import com.nagem.pokemoncompose.PokemonSearchScreen
import com.nagem.pokemoncompose.model.PokemonResponse
import com.nagem.pokemoncompose.ui.theme.PokemonComposeTheme
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.stopKoin
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class PokemonSearchScreenKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        stopKoin()
    }

    @Test
    fun `should show all screen`() {
        composeTestRule.setContent {
            PokemonComposeTheme {
                PokemonSearchScreen(
                    uiState = PokemonSearchUiState(
                        isLoading = false,
                    ),
                    searchPokemon = {},
                    setPokemonSearch = {}
                )
            }
        }

        composeTestRule.onNode(hasTestTag("SearchPokemonCard")).assertDoesNotExist()
    }

}