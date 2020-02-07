package com.main.cicilandroidquiz.ui.moviedetails

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import com.bumptech.glide.Glide
import com.main.cicilandroidquiz.R
import com.main.cicilandroidquiz.data.network.model.Movie
import com.main.cicilandroidquiz.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_movie_details.*
import javax.inject.Inject

class MovieDetailsActivity : BaseActivity(), MovieDetailsView {

    @Inject
    internal lateinit var presenter: MovieDetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        setToolBar(toolbar)

        if (intent.extras != null) {
            intent.extras!!.getString("movieID")?.let { presenter.getMovieDetails(it) }
        }

    }

    override fun getToolbarTitle(): String? = "Detail Film"

    override fun displayDetails(movie: Movie) {
        tv_detail_title.text = movie.Title
        tv_detail_genre.text = movie.Genre
        tv_detail_plot.text = movie.Plot
        tv_detail_rating.text = movie.imdbRating
        tv_detail_runtime.text = movie.Runtime
        tv_detail_year.text = movie.Year
        Glide.with(this)
            .load(movie.Poster)
            .into(iv_detail)
    }
}
