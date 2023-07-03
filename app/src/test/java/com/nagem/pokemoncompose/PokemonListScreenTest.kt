package com.nagem.pokemoncompose

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import com.nagem.pokemoncompose.ui.theme.PokemonComposeTheme
import com.nagem.pokemoncompose.PokemonListScreen
import kotlinx.coroutines.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.stopKoin
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class PokemonListScreenTest {

    /*
    Considerations :

    LazyColumn will only show as much as 4 item, that will be how much a screen will render, therefore the maximum children will be 4
    Considering only 4 items will appear in the most, and that they can change as the screen is scrolled, the index of them will change
    according to which items are on screen, this makes the test very flaky if correct screen size is not considered
     */

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        stopKoin()
        composeTestRule.setContent {
            PokemonComposeTheme {
                PokemonListScreen {}
            }
        }
    }

    @Test
    fun `When pokemonImageCard is pressed should show PokemonInfoCard`() {
        composeTestRule.onAllNodesWithContentDescription("Pokemon Image")[0].performClick()
        composeTestRule.onNodeWithContentDescription("Pokemon Image Info").assertIsDisplayed()
    }

    @Test
    fun `When pokemonImageCard element 0 is pressed should show PokemonInfoCard of Pikachu`() {
        composeTestRule.onNodeWithTag("Pokemon LazyList")
            .onChildren()[0]
            .performClick()
        composeTestRule.onNodeWithText("Pikachu").assertIsDisplayed()
    }

    @Test
    fun `When pokemonImageCard element 1 is pressed should show PokemonInfoCard of Raichu`() {
        composeTestRule.onNodeWithTag("Pokemon LazyList")
            .onChildren()[1]
            .performClick()
        composeTestRule.onNodeWithText("Raichu").assertIsDisplayed()
    }


    @Test
    fun `When pokemonImageCard element 2 is pressed should show PokemonInfoCard of Squirtle`() {
        composeTestRule.onNodeWithTag("Pokemon LazyList")
            .performScrollToIndex(2)

        composeTestRule.onNodeWithTag("Pokemon LazyList")
            .onChildren()[2]
            .performClick()

        composeTestRule.onNodeWithText("Squirtle").assertIsDisplayed()
    }

    @Test
    fun `When pokemonImageCard element 3 is pressed should show PokemonInfoCard of Charizard`() {
        composeTestRule.onNodeWithTag("Pokemon LazyList")
            .performScrollToIndex(3)

        composeTestRule.onNodeWithTag("Pokemon LazyList")
            .onChildren()[2]
            .performClick()

        composeTestRule.onNodeWithText("Charizard").assertIsDisplayed()
    }

    @Test
    fun `When pokemonImageCard element 4 is pressed should show PokemonInfoCard of Eevee`() {
        composeTestRule.onNodeWithTag("Pokemon LazyList")
            .performScrollToIndex(4)

        composeTestRule.onNodeWithTag("Pokemon LazyList")
            .onChildren()[2]
            .performClick()

        composeTestRule.onNodeWithText("Eevee").assertIsDisplayed()
    }


    @Test
    fun `When pokemonImageCard element 5 is pressed should show PokemonInfoCard of Umbreon`() {
        composeTestRule.onNodeWithTag("Pokemon LazyList")
            .performScrollToIndex(5)

        composeTestRule.onNodeWithTag("Pokemon LazyList")
            .onChildren()[2]
            .performClick()

        composeTestRule.onNodeWithText("Umbreon").assertIsDisplayed()
    }

    @Test
    fun `When pokemonImageCard Last element is pressed should show PokemonInfoCard of Vaporean`() {
        composeTestRule.onNodeWithTag("Pokemon LazyList")
            .performScrollToIndex(6)

        composeTestRule.onNodeWithTag("Pokemon LazyList")
            .onChildren()[3]
            .performClick()

        composeTestRule.onNodeWithText("Vaporean").assertIsDisplayed()
    }

    @Test
    fun `Assert pokemonImageList contains `() {
        composeTestRule.onNodeWithTag("Pokemon LazyList")
            .performScrollToIndex(6)

        //The Number for is because LazColumn will only render what is on the screen, 4 is the most it can appear
        composeTestRule.onNodeWithTag("Pokemon LazyList")
            .onChildren()
            .assertCountEquals(4)
    }

    @Test
    fun `When pokemonImageInfo is pressed should hide PokemonInfoCard`() {
        composeTestRule.onAllNodesWithContentDescription("Pokemon Image")[0].performClick()
        composeTestRule.onNode(hasTestTag("Pokemon Info Card")).performClick()
        composeTestRule.onNode(hasText("Pokemon Image Info")).assertDoesNotExist()
    }
}