package com.nagem.pokemoncompose.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nagem.pokemoncompose.data.AsyncResult
import com.nagem.pokemoncompose.data.PokemonRepository
import com.nagem.pokemoncompose.model.PokemonResponse
import com.nagem.pokemoncompose.model.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class PokemonSearchUiState(
    val isLoading: Boolean = false,
    val error: String = "",
    val pokemonResult: PokemonResponse? = null,
    val pokemonSearch: String = ""
)

class PokemonSearchViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(PokemonSearchUiState())
    val uiState: StateFlow<PokemonSearchUiState> = _uiState.asStateFlow()


    fun setPokemonSearch(search: String) {
        _uiState.update {
            it.copy(
                isLoading = false,
                error = "",
                pokemonResult = null,
                pokemonSearch = search
            )
        }
    }


    fun searchPokemon(name: String) {
        _uiState.update {
            it.copy(isLoading = true)
        }

        viewModelScope.launch {
            val response = pokemonRepository.searchPokemon(name)
            when (response) {
                is AsyncResult.Success -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            pokemonResult = response.data,
                            error = ""
                        )
                    }
                }
                is AsyncResult.Error -> {
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            pokemonResult = null,
                            error = "Nenhum pokemon encontrado :/"
                        )
                    }
                }
            }
        }
    }

}