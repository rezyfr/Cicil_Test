package com.main.cicilandroidquiz.di.builder

import com.main.cicilandroidquiz.ui.movielist.MovieListActivity
import com.main.cicilandroidquiz.di.module.MovieDetailsModule
import com.main.cicilandroidquiz.di.module.MovieListModule
import com.main.cicilandroidquiz.ui.moviedetails.MovieDetailsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(MovieListModule::class)])
    abstract fun bindMovieListActivity(): MovieListActivity

    @ContributesAndroidInjector(modules = [(MovieDetailsModule::class)])
    abstract fun bindMovieDetailsActivity(): MovieDetailsActivity

}