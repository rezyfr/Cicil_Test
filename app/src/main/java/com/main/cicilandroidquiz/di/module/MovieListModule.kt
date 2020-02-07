package com.main.cicilandroidquiz.di.module

import com.main.cicilandroidquiz.data.network.ApiInterface
import com.main.cicilandroidquiz.ui.movielist.MovieAdapter
import com.main.cicilandroidquiz.ui.movielist.MovieListActivity
import com.main.cicilandroidquiz.ui.movielist.MovieListPresenter
import com.main.cicilandroidquiz.ui.movielist.MovieListView
import dagger.Module
import dagger.Provides

@Module
class MovieListModule {

    @Provides
    fun provideView(activity: MovieListActivity) = activity as MovieListView

    @Provides
    fun providePresenter(apiInterface: ApiInterface, view: MovieListView): MovieListPresenter =
        MovieListPresenter(apiInterface, view)

    @Provides
    fun provideAdapter(): MovieAdapter = MovieAdapter(ArrayList())
}