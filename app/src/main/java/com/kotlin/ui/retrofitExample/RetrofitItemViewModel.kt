package com.kotlin.ui.retrofitExample

import android.databinding.ObservableField
import com.kotlin.ui.adapter.ViewModel

class RetrofitItemViewModel(movie: Movie) : ViewModel {

    val movieModel = ObservableField<Movie>()

    init {
        movieModel.set(movie)
    }

}