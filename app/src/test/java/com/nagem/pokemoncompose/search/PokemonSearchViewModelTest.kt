package com.nagem.pokemoncompose.search

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nagem.pokemoncompose.data.AsyncResult
import com.nagem.pokemoncompose.data.PokemonRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class PokemonSearchViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    private var dispatcher = StandardTestDispatcher()

    private val repository: PokemonRepository = mockk {
        coEvery { searchPokemon(any()) } returns AsyncResult.Success(mockk())
    }

    private val viewModel = PokemonSearchViewModel(repository)

    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
    }

    @Test
    fun `when pokemonName is empty should return an error`() {
        viewModel.searchPokemon("")
        assert(viewModel.uiState.value.error.contains("Nome do pokemon vazio"))
    }


    @Test
    fun `when pokemonName is valid should return an Success with pokemon returns`() {
        viewModel.searchPokemon("pikachu")
        dispatcher.scheduler.advanceUntilIdle()
        assert(viewModel.uiState.value.error.isEmpty())
        assert(viewModel.uiState.value.isLoading.not())
        assert(viewModel.uiState.value.pokemonResult != null)
    }
}