package com.main.cicilandroidquiz.data.network.model

data class SearchResponse(
    val Response: String,
    val Error: String,
    val Search: ArrayList<Search>,
    val totalResults: String
)

data class Search(
    val Poster: String,
    val Title: String,
    val Year: String,
    val imdbID: String
)