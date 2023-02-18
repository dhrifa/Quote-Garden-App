package com.example.quotegardenapp.data.model.quote


import com.google.gson.annotations.SerializedName

data class PaginationModel(
    @SerializedName("currentPage")
    val currentPage: Int? = 0,
    @SerializedName("nextPage")
    val nextPage: Int? = 0,
    @SerializedName("totalPages")
    val totalPages: Int? = 0
)