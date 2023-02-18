package com.example.quotegardenapp.data.model.quote


import com.google.gson.annotations.SerializedName

data class QuoteModel(
    @SerializedName("data")
    val `data`: List<DataModel?>? = listOf(),
    @SerializedName("message")
    val message: String? = "",
    @SerializedName("pagination")
    val pagination: PaginationModel? = PaginationModel(),
    @SerializedName("statusCode")
    val statusCode: Int? = 0,
    @SerializedName("totalQuotes")
    val totalQuotes: Int? = 0
)