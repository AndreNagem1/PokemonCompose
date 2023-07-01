package com.nagem.pokemoncompose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nagem.pokemoncompose.ui.theme.PokemonCard
import com.nagem.pokemoncompose.ui.theme.PokemonComposeTheme

@Composable
fun PokemonListScreen(navigateToSearch: () -> Unit) {
    var showPokemonInfo by remember {
        mutableStateOf(false)
    }
    var pokemonInfo by remember {
        mutableStateOf(listPokemonInfoMock[0])
    }
    Scaffold(
        topBar = { MyTopBar() },
        floatingActionButton = {
            FloatingActionButton(onClick = { navigateToSearch() }) {
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .testTag("Pokemon LazyList"),
        ) {
            items(listPokemonImage.size) { index ->
                PokemonCard(
                    pokemonImage = listPokemonImage[index]
                )
                {
                    showPokemonInfo = true
                    pokemonInfo = listPokemonInfoMock[index]
                    pokemonInfo.pokemonImage = listPokemonImage[index]
                }
            }
        }
        AnimatedVisibility(visible = showPokemonInfo) {
            Box(modifier = Modifier.fillMaxSize()) {
                Column {
                    Spacer(modifier = Modifier.height(170.dp))
                    PokemonInfoCard(
                        pokemonName = pokemonInfo.name,
                        type = pokemonInfo.type,
                        height = pokemonInfo.height.toString(),
                        weight = pokemonInfo.weight.toString(),
                        ability = pokemonInfo.abilities,
                        pokemonImage = pokemonInfo.pokemonImage
                    ) { showPokemonInfo = false }
                }
            }
        }
    }
}


@Composable
fun MyTopBar() {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.background, elevation = 4.dp
    ) {
        Row(modifier = Modifier.padding(12.dp)) {
            Text(text = "Pokemon List")
            Spacer(modifier = Modifier.weight(1F))
            Icon(imageVector = Icons.Filled.List, contentDescription = "")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PokemonComposeTheme {
        PokemonListScreen {}
    }
}