package com.nagem.pokemoncompose.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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