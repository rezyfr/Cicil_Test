package com.main.cicilandroidquiz.ui.movielist

import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.main.cicilandroidquiz.R
import com.main.cicilandroidquiz.data.network.model.Search
import com.main.cicilandroidquiz.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_movie_list.*
import javax.inject.Inject

class MovieListActivity : BaseActivity(), MovieListView {

    @Inject
    internal lateinit var movieAdapter: MovieAdapter

    @Inject
    internal lateinit var presenter: MovieListPresenter

    private lateinit var layoutManager: RecyclerView.LayoutManager

    var pageIndex: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)
        setToolBar(toolbar)
        setDisplayHomeEnabled(false)

        setUp()
    }

    override fun getToolbarTitle(): String? = "Daftar Film"

    override fun displayResult(search: ArrayList<Search>) {
        movieAdapter.addMoviesToList(search)
        hideProgress()
    }

    private fun setUp() {
        setRv()
        sv_main.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                if (pageIndex == 1) {
                    presenter.searchMovies(query, pageIndex)
                } else {
                    movieAdapter.removeList()
                    pageIndex = 1
                    presenter.searchMovies(query, pageIndex)
                }
                return false
            }
        })
        rv_movie.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (!recyclerView.canScrollVertically(1)) { //1 for down, -1 for up
                    if (pageIndex <= 4) {
                        showProgress()
                        pageIndex++
                        presenter.searchMovies(sv_main.query.toString(), pageIndex)
                    }
                }
            }
        })
    }

    private fun setRv() {
        layoutManager = LinearLayoutManager(this)
        rv_movie.layoutManager = layoutManager
        rv_movie.setHasFixedSize(true)
        rv_movie.adapter = movieAdapter
    }
}
