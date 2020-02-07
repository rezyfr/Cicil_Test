package com.main.cicilandroidquiz.data.network

import com.main.cicilandroidquiz.data.network.model.Movie
import com.main.cicilandroidquiz.data.network.model.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("?type=movie")
    fun searchMovies(@Query("s") query: String,
                     @Query("page") page: Int): Call<SearchResponse>

    @GET("?plot=full")
    fun getMovieDetails(@Query("i") id: String): Call<Movie>
}