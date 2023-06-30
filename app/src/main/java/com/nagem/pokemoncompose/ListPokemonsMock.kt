package com.nagem.pokemoncompose

import com.nagem.pokemoncompose.model.PokemonInfo

val listPokemonsMock = listOf(
    R.drawable.pikachu,
    R.drawable.raichu,
    R.drawable.squirtle,
    R.drawable.charizard,
    R.drawable.eevee,
    R.drawable.umbreon,
    R.drawable.vaporean
)

val listPokemonInfoMock = listOf(
    PokemonInfo(
        name = "Pikachu",
        type = "Electric",
        height = 0.4F,
        weight = 6F,
        abilities = "Thunder"
    ),
    PokemonInfo(
        name = "Raichu",
        type = "Electric",
        height = 0.8F,
        weight = 30F,
        abilities = "ThunderBolt"
    ),
    PokemonInfo(
        name = "Squirtle",
        type = "Water",
        height = 0.5F,
        weight = 9F,
        abilities = "Bubble"
    ),
    PokemonInfo(
        name = "Charizard",
        type = "Fire",
        height = 1.7F,
        weight = 90.5F,
        abilities = "Fire"
    ),
    PokemonInfo(
        name = "Eevee",
        type = "Normal",
        height = 0.3F,
        weight = 6.5F,
        abilities = "Dash"
    ),
    PokemonInfo(
        name = "Umbreon",
        type = "Dark",
        height = 1.0F,
        weight = 27F,
        abilities = "Synchronize"
    ),
    PokemonInfo(
        name = "Vaporean",
        type = "Water",
        height = 1.0F,
        weight = 29F,
        abilities = "Water"
    ),
)