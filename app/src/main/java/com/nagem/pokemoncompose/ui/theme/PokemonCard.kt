package com.nagem.pokemoncompose.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.nagem.pokemoncompose.R as R


@Composable
fun PokemonCard() {
    Card(modifier = Modifier.padding(16.dp)) {
        Column {
            Box(modifier = Modifier.fillMaxWidth()) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Spacer(modifier = Modifier.weight(1F))
                    Text(text = "Pikcachu")
                }
                Image(
                    painter = painterResource(R.drawable.pikachu),
                    contentDescription = "Pokemon Image",
                    modifier = Modifier.background(MaterialTheme.colors.onSurface).fillMaxWidth().height(200.dp)
                )
            }
        }

    }
}