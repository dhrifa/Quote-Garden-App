package com.example.quotegardenapp.ui.quote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuoteViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is quote Fragment"
    }
    val text: LiveData<String> = _text
}