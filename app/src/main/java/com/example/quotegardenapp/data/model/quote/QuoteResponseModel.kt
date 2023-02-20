package com.example.quotegardenapp.data.model.quote


import com.google.gson.annotations.SerializedName

data class QuoteResponseModel(
    @SerializedName("data")
    val `data`: List<QuoteItemModel>? = listOf(),
    @SerializedName("message")
    val message: String? = "",
    @SerializedName("pagination")
    val pagination: PaginationModel? = PaginationModel(),
    @SerializedName("statusCode")
    val statusCode: Int? = 0,
    @SerializedName("totalQuotes")
    val totalQuotes: Int? = 0
)

class QuoteModel : ArrayList<QuoteItemModel>()