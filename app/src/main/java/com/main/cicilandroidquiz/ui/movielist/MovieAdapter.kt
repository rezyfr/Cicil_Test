package com.main.cicilandroidquiz.ui.movielist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.main.cicilandroidquiz.R
import com.main.cicilandroidquiz.data.network.model.Search
import com.main.cicilandroidquiz.ui.moviedetails.MovieDetailsActivity
import kotlinx.android.synthetic.main.item_movie_layout.view.*


class MovieAdapter(private val listItem: MutableList<Search>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun getItemCount(): Int = listItem.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) = holder.let { it ->
        it.bindItem(position)
        it.itemView.setOnClickListener {
            it.isClickable = false
            val intent = Intent(it.context, MovieDetailsActivity::class.java)
            intent.putExtra("movieID", listItem[position].imdbID)
            it.context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MovieViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_movie_layout, parent, false)
    )

    inner class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(position: Int) {
            val (imgUrl, name, year) = listItem[position]
            inflateData(imgUrl, name, year)
        }

        private fun inflateData(
            imgUrl: String, title: String, year: String
        ) {
            title.let { itemView.tv_title.text = it }
            year.let { itemView.tv_year.text = it }
            imgUrl.let {
                when (it) {
                    "N/A" -> loadImg(R.drawable.img_placeholder)
                    else -> loadImg(it)
                }
            }
        }

        private fun loadImg(url: Any) {
            Glide.with(itemView.context)
                .load(url)
                .into(itemView.iv_movie)
        }
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    internal fun addMoviesToList(movies: ArrayList<Search>) {
        listItem.addAll(movies)
        notifyDataSetChanged()
    }

    internal fun removeList() {
        listItem.clear()
        notifyItemRangeRemoved(0, itemCount)
    }
}


