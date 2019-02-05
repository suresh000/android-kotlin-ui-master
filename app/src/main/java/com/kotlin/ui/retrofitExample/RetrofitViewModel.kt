package com.kotlin.ui.retrofitExample

import android.app.ProgressDialog
import android.content.Context
import android.databinding.ObservableField
import com.kotlin.ui.adapter.ViewModel
import com.kotlin.ui.apiClient.ApiClient
import com.kotlin.ui.apiClient.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitViewModel(val context: Context) {

    companion object {
        // insert your themoviedb.org API KEY here
        private const val API_KEY = "53843818950b9a57b40d94c82d12434a"
    }

    val adapter = ObservableField<RetrofitAdapter>()

    init {
        getTopRatedMovies()
    }

    private fun getTopRatedMovies() {
        val progressDialog = ProgressDialog(context)
        progressDialog.setMessage("Please wait...")
        progressDialog.setCancelable(false)
        progressDialog.show()

        val apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.getTopRatedMovies(API_KEY)
        call.enqueue(object : Callback<MoviesResponse> {
            override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                val movies: List<Movie> = response.body()!!.results
                progressDialog.dismiss()
                setAdapter(movies)
            }

            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                // Log error here since request failed
            }
        })
    }

    private fun setAdapter(movies: List<Movie>) {
        val movieList = ArrayList<ViewModel>()
        for (movie in movies) {
            val item = RetrofitItemViewModel(movie)
            movieList.add(item)
        }

        adapter.set(RetrofitAdapter(movieList))
    }

}