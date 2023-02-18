package com.example.quotegardenapp.data.repository

import com.example.quotegardenapp.data.model.author.AuthorModel
import com.example.quotegardenapp.data.model.genre.GenreModel
import com.example.quotegardenapp.data.model.quote.QuoteModel
import retrofit2.Response

interface Repository {

    suspend fun getQuotes(): Response<QuoteModel>

    suspend fun getAuthors(): Response<AuthorModel>

    suspend fun getGenres(): Response<GenreModel>
}