package com.nagem.pokemoncompose

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.nagem.pokemoncompose.ui.theme.PokemonComposeTheme
import kotlinx.coroutines.*
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class MainActivityTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private val dispatcher = StandardTestDispatcher()


    @Test
    fun `When pokemonImageCard is pressed should show PokemonInfoCard`() {
        composeTestRule.setContent {
            PokemonComposeTheme {
                PokemonListScreen(name = "My pokemon List")
            }
        }

        composeTestRule.onAllNodesWithContentDescription("Pokemon Image")[0].performClick()
        composeTestRule.onNodeWithContentDescription("Pokemon Image Info").assertIsDisplayed()
    }

    @Test
    fun `When pokemonImageCard element 0 is pressed should show PokemonInfoCard of Pikachu`() {
        composeTestRule.setContent {
            PokemonComposeTheme {
                PokemonListScreen(name = "My pokemon List")
            }
        }

        composeTestRule.onAllNodesWithContentDescription("Pokemon Image")[0].performClick()
        composeTestRule.onNodeWithText("Pikachu").assertIsDisplayed()
    }

    @Test
    fun `When pokemonImageCard element 2 is pressed should show PokemonInfoCard of Raichu`() {
        composeTestRule.setContent {
            PokemonComposeTheme {
                PokemonListScreen(name = "My pokemon List")
            }
        }

        composeTestRule.onAllNodesWithContentDescription("Pokemon Image")[1].performClick()
        composeTestRule.onNodeWithText("Raichu").assertIsDisplayed()
    }


    @Test
    fun `When pokemonImageCard element 2 is pressed should show PokemonInfoCard of Squirtle`() {
        runBlocking {
            launch {
                composeTestRule.setContent {
                    PokemonComposeTheme {
                        PokemonListScreen(name = "My pokemon List")
                    }
                }

                composeTestRule.onAllNodesWithContentDescription("Pokemon Image")[2].performClick()
                composeTestRule.awaitIdle()
                composeTestRule.onNodeWithText("Squirtle").assertIsDisplayed()
            }
        }
    }


    @Test
    fun `When pokemonImageInfo is pressed should hide PokemonInfoCard`() {
        composeTestRule.setContent {
            PokemonComposeTheme {
                PokemonListScreen(name = "My pokemon List")
            }
        }

        composeTestRule.onAllNodesWithContentDescription("Pokemon Image")[0].performClick()
        composeTestRule.onNode(hasTestTag("Pokemon Info Card")).performClick()
        composeTestRule.onNodeWithContentDescription("Pokemon Image Info").assertDoesNotExist()
    }
}