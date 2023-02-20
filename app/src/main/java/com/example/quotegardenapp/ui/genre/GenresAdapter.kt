package com.example.quotegardenapp.ui.genre

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quotegardenapp.databinding.GenreItemBinding

class GenresAdapter(
    private val data: List<String>,
  private val function: (genre: String) -> Unit
) : RecyclerView.Adapter<GenresAdapter.ViewHolder>() {

    inner class ViewHolder(val view: GenreItemBinding) : RecyclerView.ViewHolder(view.root) {
        fun initUI(genre: String, position: Int) {
            view.tvGenre.text = genre
            view.layoutGenre.setOnClickListener {
                function.invoke(genre)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            GenreItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.initUI(data[position], position)
    }

    override fun getItemCount() = data.size

}
