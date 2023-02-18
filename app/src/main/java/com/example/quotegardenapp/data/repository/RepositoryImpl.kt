package com.example.quotegardenapp.data.repository

import com.example.quotegardenapp.data.model.author.AuthorModel
import com.example.quotegardenapp.data.model.genre.GenreModel
import com.example.quotegardenapp.data.model.quote.QuoteModel
import com.example.quotegardenapp.data.remote.ApiDetail

class RepositoryImpl(val apiDetail: ApiDetail): Repository {
    //add access data logic here
    override suspend fun getQuotes(): QuoteModel {
       return apiDetail.getQuotes()
    }

    override suspend fun getAuthors(): AuthorModel {
        return apiDetail.getAuthors()
    }

    override suspend fun getGenres(): GenreModel {
        return apiDetail.getGenres()
    }
}