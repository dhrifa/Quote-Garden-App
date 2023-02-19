package com.example.quotegardenapp.data.repository

import com.example.quotegardenapp.data.model.author.AuthorModel
import com.example.quotegardenapp.data.model.genre.GenreModel
import com.example.quotegardenapp.data.model.quote.QuoteModel
import com.example.quotegardenapp.data.remote.ApiDetails
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiDetail: ApiDetails
) : Repository {
    //add access data logic here
    override suspend fun getQuotes(): Response<QuoteModel> {
        return apiDetail.getQuotes()
    }

    override suspend fun getAuthors(): Response<AuthorModel> {
        return apiDetail.getAuthors()
    }

    override suspend fun getGenres(): Response<GenreModel> {
        return apiDetail.getGenres()
    }
}