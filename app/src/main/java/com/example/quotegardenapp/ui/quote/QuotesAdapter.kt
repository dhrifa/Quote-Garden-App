package com.example.quotegardenapp.ui.quote

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.quotegardenapp.data.model.quote.QuoteItemModel
import com.example.quotegardenapp.databinding.QuoteItemBinding

class QuotesAdapter(
    private val data: List<QuoteItemModel>,
    function: () -> Unit
) : RecyclerView.Adapter<QuotesAdapter.ViewHolder>() {
    inner class ViewHolder(val view: QuoteItemBinding) : RecyclerView.ViewHolder(view.root) {
        fun initUI(quoteItemModel: QuoteItemModel, position: Int) {
            //ui->view
            //data->quoteitemmodel
            view.tvQuote.text = quoteItemModel.quoteText
            view.tvGenre.text = quoteItemModel.quoteGenre
            view.tvAuthor.text = quoteItemModel.quoteAuthor
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            QuoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.initUI(data[position], position)
    }

    override fun getItemCount() = data.size

}
