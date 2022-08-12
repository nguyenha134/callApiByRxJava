package com.example.callapibyrxjava02.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.callapibyrxjava02.model.MovieItem
import com.example.callapibyrxjava02.repository.MainRepository

class MovieViewModel : ViewModel() {

    private val mainRepo: MainRepository = MainRepository()

    val getMovieList: LiveData<MutableList<MovieItem>>
        get() = mainRepo.getMovieModelLiveData
}