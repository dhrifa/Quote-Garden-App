package com.example.quotegardenapp.ui.author

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AuthorViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is author Fragment"
    }
    val text: LiveData<String> = _text
}