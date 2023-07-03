package com.nagem.pokemoncompose

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nagem.pokemoncompose.search.PokemonSearchUiState
import com.nagem.pokemoncompose.ui.theme.PokemonCardSearch
import com.nagem.pokemoncompose.ui.theme.PokemonComposeTheme
import com.nagem.pokemoncompose.util.GifImage
import com.nagem.pokemoncompose.util.MyFloatingActionButton

@Composable
fun PokemonSearchScreen(
    uiState: PokemonSearchUiState,
    searchPokemon: (String) -> Unit,
    setPokemonSearch: (String) -> Unit
) {
    val context = LocalContext.current

    Scaffold(
        topBar = { MyTopBar() },
        floatingActionButton = {
            MyFloatingActionButton {
                if (uiState.pokemonSearch.isEmpty()) {
                    Toast.makeText(context, "Nome vazio", Toast.LENGTH_SHORT).show()
                    return@MyFloatingActionButton
                }
                searchPokemon(uiState.pokemonSearch)
            }
        }
    ) { paddingValues ->

        if (uiState.error.isNotEmpty()) {
            Toast.makeText(context, uiState.error, Toast.LENGTH_SHORT).show()
        }

        if (uiState.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                GifImage(
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp)
                )
            }
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background)
                    .padding(paddingValues),
            ) {
                Column {
                    TextField(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        value = uiState.pokemonSearch,
                        onValueChange = { newText ->
                            setPokemonSearch(newText)
                        },
                        placeholder = {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = Icons.Filled.Search,
                                    contentDescription = "SearchTextFieldIcon",
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                Text(text = "Search your pokemon")
                            }
                        },
                        singleLine = true,
                    )

                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        uiState.pokemonResult?.let { pokemonResponse ->
                            PokemonCardSearch(pokemonResponse = pokemonResponse) {}
                        }
                    }
                }
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun SearchPreview() {
    PokemonComposeTheme {
        PokemonSearchScreen(
            uiState = PokemonSearchUiState(),
            searchPokemon = {},
            setPokemonSearch = {}
        )
    }
}