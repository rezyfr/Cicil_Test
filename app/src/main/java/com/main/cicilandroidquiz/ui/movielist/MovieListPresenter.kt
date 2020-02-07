package com.main.cicilandroidquiz.ui.movielist

import android.util.Log
import com.main.cicilandroidquiz.data.network.ApiInterface
import com.main.cicilandroidquiz.data.network.model.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MovieListPresenter @Inject internal constructor(
    private val apiInterface: ApiInterface,
    private val view: MovieListView
) {

    companion object {
        private val LOG_TAG = MovieListPresenter::class.java.simpleName
    }

    fun searchMovies(query: String, page: Int) {
        view.showProgress()
        val call: Call<SearchResponse> = apiInterface.searchMovies(query, page)
        call.enqueue(object : Callback<SearchResponse> {
            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                Log.e(LOG_TAG, t.message)
                view.hideProgress()
            }

            override fun onResponse(
                call: Call<SearchResponse>,
                response: Response<SearchResponse>
            ) {
                if (response.isSuccessful) {
                    if (response.body()!!.Response != "False") {
                        view.displayResult(response.body()!!.Search)
                    } else {
                        Log.e(LOG_TAG, response.body()!!.Error)
                        view.hideProgress()
                    }
                }
            }
        })
    }
}
