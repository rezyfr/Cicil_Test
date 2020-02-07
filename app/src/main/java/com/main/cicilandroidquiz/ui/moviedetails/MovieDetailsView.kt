package com.main.cicilandroidquiz.ui.moviedetails

import com.main.cicilandroidquiz.data.network.model.Movie
import com.main.cicilandroidquiz.ui.base.BaseView

interface MovieDetailsView: BaseView {
    fun displayDetails(movie: Movie)
}
