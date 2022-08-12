package com.example.callapibyrxjava02.utils

import com.example.callapibyrxjava02.model.MovieItem

object ValidationUtil {
    fun validateMovie(movie: MovieItem): Boolean {
        if (movie.name.isNotEmpty()) {
            return true
        }
        return false
    }
}