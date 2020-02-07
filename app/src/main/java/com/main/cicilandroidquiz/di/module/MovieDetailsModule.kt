package com.main.cicilandroidquiz.di.module

import com.main.cicilandroidquiz.data.network.ApiInterface
import com.main.cicilandroidquiz.ui.moviedetails.MovieDetailsActivity
import com.main.cicilandroidquiz.ui.moviedetails.MovieDetailsPresenter
import com.main.cicilandroidquiz.ui.moviedetails.MovieDetailsView
import com.main.cicilandroidquiz.ui.movielist.MovieListActivity
import com.main.cicilandroidquiz.ui.movielist.MovieListView
import dagger.Module
import dagger.Provides

@Module
class MovieDetailsModule {

    @Provides
    fun provideView(activity: MovieDetailsActivity) = activity as MovieDetailsView

    @Provides
    fun providePresenter(apiInterface: ApiInterface, view: MovieDetailsView) = MovieDetailsPresenter(apiInterface, view)
}
