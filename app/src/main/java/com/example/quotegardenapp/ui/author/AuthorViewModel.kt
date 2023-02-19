package com.example.quotegardenapp.ui.author

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quotegardenapp.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthorViewModel @Inject constructor(
    repository: Repository
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is author Fragment"
    }
    val text: LiveData<String> = _text
}