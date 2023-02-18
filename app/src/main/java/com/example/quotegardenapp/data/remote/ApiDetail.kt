package com.example.quotegardenapp.data.remote

import com.example.quotegardenapp.data.model.author.AuthorModel
import com.example.quotegardenapp.data.model.genre.GenreModel
import com.example.quotegardenapp.data.model.quote.QuoteModel
import retrofit2.http.GET

interface ApiDetail {

    @GET(ApiReferences.QUOTES)
    suspend fun getQuotes(): QuoteModel

    @GET(ApiReferences.AUTHORS)
    suspend fun getAuthors(): AuthorModel

    @GET(ApiReferences.GENRES)
    suspend fun getGenres(): GenreModel

    //get custom query: quote, author and genre
}