package com.nagem.pokemoncompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PokemonInfoCard(
    pokemonName: String,
    type: String,
    height: String,
    weight: String,
    ability: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(20.dp)
            .background(color = MaterialTheme.colors.onSurface),
        onClick = onClick
    ) {
        Column {
            Row {
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Name: ")
                Text(text = pokemonName)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Type: ")
                Text(text = type)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Height: ")
                Text(text = height)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Weight: ")
                Text(text = weight)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Abilities: ")
                Text(text = ability)
            }
        }
    }

}