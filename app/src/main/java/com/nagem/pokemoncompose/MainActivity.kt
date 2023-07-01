package com.nagem.pokemoncompose

import PokemonNavGraph
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.nagem.pokemoncompose.ui.theme.PokemonComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonComposeTheme {
                PokemonNavGraph()
            }
        }
    }
}