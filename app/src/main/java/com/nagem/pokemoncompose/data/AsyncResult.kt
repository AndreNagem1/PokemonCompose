package com.nagem.pokemoncompose.data

sealed class AsyncResult<out T> {
    data class Error(val exception: java.lang.Exception) : AsyncResult<Nothing>()
    data class Success<T>(val data: T) : AsyncResult<T>()
}