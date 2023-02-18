package com.example.quotegardenapp.data.repository

import com.example.quotegardenapp.data.model.author.AuthorModel
import com.example.quotegardenapp.data.model.genre.GenreModel
import com.example.quotegardenapp.data.model.quote.QuoteModel

interface Repository {

    suspend fun getQuotes(): QuoteModel

    suspend fun getAuthors(): AuthorModel

    suspend fun getGenres(): GenreModel
}