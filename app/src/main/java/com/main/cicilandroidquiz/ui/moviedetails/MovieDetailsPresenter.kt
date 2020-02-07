package com.main.cicilandroidquiz.ui.moviedetails

import android.util.Log
import com.main.cicilandroidquiz.data.network.ApiInterface
import com.main.cicilandroidquiz.data.network.model.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MovieDetailsPresenter @Inject internal constructor(
    private val apiInterface: ApiInterface,
    private val view: MovieDetailsView
) {

    companion object {
        private val LOG_TAG = MovieDetailsPresenter::class.java.simpleName
    }

    fun getMovieDetails(id: String) {
        view.showProgress()
        val call: Call<Movie> = apiInterface.getMovieDetails(id)
        call.enqueue(object : Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                if (response.isSuccessful) {
                    view.displayDetails(response.body()!!)
                }
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                Log.e(LOG_TAG, t.message)
                view.hideProgress()
            }
        })
    }
}
