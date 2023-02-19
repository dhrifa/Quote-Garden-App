package com.example.quotegardenapp.data.remote

import com.example.quotegardenapp.data.model.author.AuthorModel
import com.example.quotegardenapp.data.model.genre.GenreModel
import com.example.quotegardenapp.data.model.quote.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiDetails {

    @GET(ApiReferences.QUOTES)
    suspend fun getQuotes(): Response<QuoteModel>

    @GET(ApiReferences.AUTHORS)
    suspend fun getAuthors(): Response<AuthorModel>

    @GET(ApiReferences.GENRES)
    suspend fun getGenres(): Response<GenreModel>

    //get custom query: quote, author and genre
}