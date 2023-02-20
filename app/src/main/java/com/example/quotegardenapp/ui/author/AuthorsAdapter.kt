package com.example.quotegardenapp.ui.author

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quotegardenapp.databinding.AuthorItemBinding

class AuthorsAdapter(
    private val data: List<String>,
    val function: (author: String) -> Unit
) :
    RecyclerView.Adapter<AuthorsAdapter.ViewHolder>() {

    inner class ViewHolder(val view: AuthorItemBinding) : RecyclerView.ViewHolder(view.root) {
        fun initUI(author: String, position: Int) {
            view.tvAuthor.text = author
            view.layoutAuthor.setOnClickListener {
                function.invoke(author)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            AuthorItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.initUI(data[position], position)
    }

    override fun getItemCount() = data.size

}
