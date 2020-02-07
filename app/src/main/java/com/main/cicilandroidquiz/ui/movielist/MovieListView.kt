package com.main.cicilandroidquiz.ui.movielist

import com.main.cicilandroidquiz.data.network.model.Search
import com.main.cicilandroidquiz.ui.base.BaseView

interface MovieListView : BaseView{
    fun displayResult(search: ArrayList<Search>)
}
