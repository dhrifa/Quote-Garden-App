package com.example.quotegardenapp.data.repository

import android.util.Log
import com.example.quotegardenapp.data.model.author.AuthorModel
import com.example.quotegardenapp.data.model.genre.GenreModel
import com.example.quotegardenapp.data.model.quote.QuoteResponseModel
import com.example.quotegardenapp.data.remote.ApiDetails
import retrofit2.Response
import javax.inject.Inject

const val TAG ="RepositoryImpl"
class RepositoryImpl @Inject constructor(
    private val apiDetail: ApiDetails
) : Repository {
    //add access data logic here
    override suspend fun getQuotes(): Response<QuoteResponseModel> {
        return apiDetail.getQuotes()
    }

    override suspend fun getAuthors(): Response<AuthorModel> {
        return apiDetail.getAuthors()
    }

    override suspend fun getGenres(): Response<GenreModel> {
        return apiDetail.getGenres()
    }

    override suspend fun getQuotesByFilter(author: String/*, genre: String*/): Response<QuoteResponseModel>{
        Log.d(TAG, "getQuotesByFilter: $author")
        return apiDetail.getQuoteByFilter(author/*, genre*/)
    }
}