package com.example.quotegardenapp.data.model.quote


import com.google.gson.annotations.SerializedName

data class DataModel(
    @SerializedName("_id")
    val id: String? = "",
    @SerializedName("quoteAuthor")
    val quoteAuthor: String? = "",
    @SerializedName("quoteGenre")
    val quoteGenre: String? = "",
    @SerializedName("quoteText")
    val quoteText: String? = "",
    @SerializedName("__v")
    val v: Int? = 0
)