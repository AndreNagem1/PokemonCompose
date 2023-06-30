package com.nagem.pokemoncompose

import android.graphics.drawable.shapes.Shape
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.BrushPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PokemonInfoCard(
    pokemonName: String,
    type: String,
    height: String,
    weight: String,
    ability: String,
    pokemonImage: Int,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(310.dp)
            .padding(20.dp)
            .border(border = BorderStroke(width = 10.dp, color = MaterialTheme.colors.onError))
            .background(color = MaterialTheme.colors.onSurface),
        onClick = onClick
    ) {
        Column {
            Image(
                painter = painterResource(pokemonImage),
                contentDescription = "Pokemon Image",
                modifier = Modifier
                    .background(MaterialTheme.colors.onSurface)
                    .fillMaxWidth()
                    .height(140.dp)
            )
            InfoRow(propertyName = "Name: ", property = pokemonName)

            InfoRow(propertyName = "Type: ", property = type)

            InfoRow(propertyName = "Height: ", property = "$height m")

            InfoRow(propertyName = "Weight: ", property = "$weight Kg")

            InfoRow(propertyName = "Ability: ", property = ability)
        }
    }
}

@Composable
fun InfoRow(propertyName: String, property: String) {
    Row {
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = propertyName)
        Text(text = property)
    }
}