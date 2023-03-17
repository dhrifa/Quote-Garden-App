package com.example.quotegardenapp.ui.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {
    private val _selectedAuthor = MutableLiveData<String>()
    val selectedAuthor: LiveData<String> = _selectedAuthor

    private val _selectedGenre = MutableLiveData<String>()
    val selectedGenre: LiveData<String> = _selectedGenre


    fun setAuthor(author: String) {
        _selectedAuthor.value = author
    }
    fun setGenre(author: String) {
        _selectedGenre.value = author
    }
}