package com.example.quotegardenapp.data.model.author


import com.google.gson.annotations.SerializedName

data class PaginationModel(
    @SerializedName("currentPage")
    val currentPage: Int? = null,
    @SerializedName("nextPage")
    val nextPage: Int? = null,
    @SerializedName("totalPages")
    val totalPages: Int? = null
)