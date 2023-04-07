package com.example.quotegardenapp.ui.quote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotegardenapp.data.model.quote.QuoteItemModel
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
    private var _listQuotes = MutableLiveData<NetworkResult<List<QuoteItemModel>>>()//
    val listQuotes: LiveData<NetworkResult<List<QuoteItemModel>>> = _listQuotes

//    private var _listQuotesByAuthor = MutableLiveData<NetworkResult<List<QuoteItemModel>>>()
//    val listQuotesByAuthor: LiveData<NetworkResult<List<QuoteItemModel>>> = _listQuotesByAuthor

    private var _selectedQuotes = MutableLiveData<NetworkResult<QuoteItemModel>>()
    val selectedQuotes: LiveData<NetworkResult<QuoteItemModel>> = _selectedQuotes

    private val _text = MutableLiveData<String>().apply {
        value = "This is quote Fragment"
    }
    val text: LiveData<String> = _text

    fun getQuoteList(
        //pagination
    ) {
        viewModelScope.launch {

            _listQuotes.value = NetworkResult.Loading()
            val result = repository.getQuotes()

            if (result.isSuccessful) {
                result.body()?.data?.let {
                    _listQuotes.value = NetworkResult.Success(it)
                }
                _text.value = result.body()?.data.toString()
            } else {
                _listQuotes.value = NetworkResult.Error(result.message())
            }
        }
    }

    fun getQuotesByAuthor(author: String) {

        viewModelScope.launch {
            _listQuotes.value = NetworkResult.Loading()
            Log.d(TAG, "getQuotesByAuthor: $author")
            val result = repository.getQuotesByFilter(author)

            if (result.isSuccessful) {
                result.body()?.data?.let {
                    _listQuotes.value = NetworkResult.Success(it)
                }
            } else {
                _listQuotes.value = NetworkResult.Error(result.message())
            }
        }
    }
}