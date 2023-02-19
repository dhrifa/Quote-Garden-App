package com.example.quotegardenapp.ui.quote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotegardenapp.data.model.quote.DataModel
import com.example.quotegardenapp.data.model.quote.QuoteModel
import com.example.quotegardenapp.data.repository.Repository
import com.example.quotegardenapp.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "QuoteViewModel"

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    private var _listQuotes = MutableLiveData<NetworkResult<QuoteModel>>()
    val listQuotes: LiveData<NetworkResult<QuoteModel>> = _listQuotes

    private var _selectedQuotes = MutableLiveData<NetworkResult<DataModel>>()
    val selectedQuotes: LiveData<NetworkResult<DataModel>> = _selectedQuotes

    private val _text = MutableLiveData<String>().apply {
        value = "This is quote Fragment"
    }
    val text: LiveData<String> = _text

    fun getQuoteList() {
        viewModelScope.launch {

            _listQuotes.value = NetworkResult.Loading()
            val result = repository.getQuotes()

            if (result.isSuccessful) {
                Log.d(TAG, "getQuote: $result")
                _listQuotes.value = NetworkResult.Success(result.body()!!)
                _text.value = result.body()?.data.toString()
            } else {
                _listQuotes.value = NetworkResult.Error(result.message())
                Log.d(TAG, "getQuote: ${result}")
            }
        }
    }
}