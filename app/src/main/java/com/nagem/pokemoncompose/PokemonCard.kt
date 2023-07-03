package com.nagem.pokemoncompose.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.nagem.pokemoncompose.InfoRow
import com.nagem.pokemoncompose.model.PokemonResponse
import com.nagem.pokemoncompose.R as R


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PokemonCard(pokemonImage: Int, onClick: () -> Unit) {
    Card(modifier = Modifier.padding(16.dp), onClick = onClick) {
        Column {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(pokemonImage),
                    contentDescription = "Pokemon Image",
                    modifier = Modifier
                        .background(MaterialTheme.colors.onSurface)
                        .fillMaxWidth()
                        .height(200.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PokemonCardName(pokemonResponse: PokemonResponse, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .border(
                border = BorderStroke(
                    width = 2.dp,
                    color = MaterialTheme.colors.onSurface
                )
            ),
        onClick = onClick
    ) {
        Column {
            Box(modifier = Modifier.fillMaxWidth()) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = rememberAsyncImagePainter(pokemonResponse.sprites.front_default),
                        contentDescription = "Pokemon Image",
                        modifier = Modifier
                            .background(MaterialTheme.colors.onSurface)
                            .width(80.dp)
                            .height(80.dp)
                    )
                    Column() {
                        InfoRow(
                            propertyName = "Name: ",
                            property = pokemonResponse.name,
                        )
                        InfoRow(
                            propertyName = "Height: ",
                            property = pokemonResponse.height.toString() + " m",
                        )
                        InfoRow(
                            propertyName = "Weight: ",
                            property = pokemonResponse.weight.toString() + " Kg",
                        )
                        var pokemonMoves = ""
                        pokemonResponse.moves.forEach { moves ->
                            pokemonMoves += moves.move.name + ", "
                        }
                        InfoRow(
                            propertyName = "Moves: ",
                            property = pokemonMoves
                        )
                    }

                }
            }
        }
    }
}