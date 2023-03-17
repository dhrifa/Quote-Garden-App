package com.example.quotegardenapp.data.remote

import com.example.quotegardenapp.data.model.author.AuthorModel
import com.example.quotegardenapp.data.model.genre.GenreModel
import com.example.quotegardenapp.data.model.quote.QuoteResponseModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiDetails {

    @GET(ApiReferences.QUOTES)
    suspend fun getQuotes(): Response<QuoteResponseModel>

    @GET(ApiReferences.AUTHORS)
    suspend fun getAuthors(): Response<AuthorModel>

    @GET(ApiReferences.GENRES)
    suspend fun getGenres(): Response<GenreModel>

    //get custom query: quote, author and genre
    @GET(ApiReferences.QUOTES)
    suspend fun getQuoteByFilter(
        @Query("author") author: String //="A. J. Jacobs" // @Query("author") author: String
    ): Response<QuoteResponseModel>


}