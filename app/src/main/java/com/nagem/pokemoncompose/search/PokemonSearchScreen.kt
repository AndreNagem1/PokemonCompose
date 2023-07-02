package com.nagem.pokemoncompose

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nagem.pokemoncompose.search.PokemonSearchUiState
import com.nagem.pokemoncompose.ui.theme.PokemonComposeTheme
import com.nagem.pokemoncompose.util.GifImage

@Composable
fun PokemonSearchScreen(
    uiState: PokemonSearchUiState,
    searchPokemon: (String) -> Unit
) {
    val context = LocalContext.current
    var text by remember { mutableStateOf(TextFieldValue("")) }

    Scaffold(
        topBar = { MyTopBar() },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier
                    .padding(16.dp),
                backgroundColor = MaterialTheme.colors.primary,
                onClick = { searchPokemon(text.text) }) {}
        }
    ) { paddingValues ->

        uiState.pokemonResult?.let { pokemonResults ->
            pokemonResults.results.forEach {
                Toast.makeText(context, it.name, Toast.LENGTH_LONG).show()
            }
        }

        if (uiState.error.isNotEmpty()) {
            Toast.makeText(context, uiState.error, Toast.LENGTH_SHORT).show()
        }

        if (uiState.isLoading) {
            GifImage(
                modifier = Modifier
                    .fillMaxSize()
            )
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.background)
                    .padding(paddingValues),
            ) {
                TextField(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    value = text,
                    onValueChange = { newText ->
                        text = newText
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
            searchPokemon = {}
        )
    }
}