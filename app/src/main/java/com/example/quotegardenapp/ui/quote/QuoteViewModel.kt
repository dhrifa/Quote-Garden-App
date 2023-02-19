package com.example.quotegardenapp.ui.quote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotegardenapp.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "QuoteViewModel"
@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is quote Fragment"
    }
    val text: LiveData<String> = _text
init {
    getQuote()
}
    fun getQuote() {
        viewModelScope.launch {
            val result = repository.getQuotes()
            if (result.isSuccessful){
                Log.d(TAG, "getQuote: $result")
                _text.value = result.body()?.data.toString()
            }else{
                Log.d(TAG, "getQuote: ${result}")
            }
        }
    }
}