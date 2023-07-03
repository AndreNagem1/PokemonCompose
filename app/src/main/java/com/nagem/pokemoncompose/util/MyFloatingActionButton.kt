package com.nagem.pokemoncompose.util

import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyFloatingActionButton(onClick: () -> Unit) {
    FloatingActionButton(
        modifier = Modifier
            .padding(16.dp),
        backgroundColor = MaterialTheme.colors.primary,
        onClick = { onClick.invoke() }) {
        Icon(imageVector = Icons.Filled.Search, contentDescription = "Search Fab")
    }
}