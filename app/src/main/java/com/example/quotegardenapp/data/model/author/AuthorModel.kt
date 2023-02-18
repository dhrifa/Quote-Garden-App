package com.example.quotegardenapp.data.model.author


import com.google.gson.annotations.SerializedName

data class AuthorModel(
    @SerializedName("data")
    val `data`: List<String?>? = listOf(),
    @SerializedName("message")
    val message: String? = "",
    @SerializedName("pagination")
    val pagination: PaginationModel? = PaginationModel(),
    @SerializedName("statusCode")
    val statusCode: Int? = 0,
    @SerializedName("totalQuotes")
    val totalQuotes: Int? = null
)