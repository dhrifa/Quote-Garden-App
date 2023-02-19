package com.example.quotegardenapp.ui.author

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotegardenapp.data.model.author.AuthorModel
import com.example.quotegardenapp.data.repository.Repository
import com.example.quotegardenapp.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "AuthorViewModel"
@HiltViewModel
class AuthorViewModel @Inject constructor(
 private val  repository: Repository
) : ViewModel() {
    private var _listAuthors = MutableLiveData<NetworkResult<AuthorModel>>()
    val listAuthors: LiveData<NetworkResult<AuthorModel>> = _listAuthors

    private val _text = MutableLiveData<String>().apply {
        value = "This is author Fragment"
    }
    val text: LiveData<String> = _text

    fun getAuthorList() {
        viewModelScope.launch {

            _listAuthors.value = NetworkResult.Loading()
            val result = repository.getAuthors()

            if (result.isSuccessful) {
                Log.d(TAG, "getQuote: $result")
                _listAuthors.value = NetworkResult.Success(result.body()!!)
                _text.value = result.body()?.data.toString()
            } else {
                _listAuthors.value = NetworkResult.Error(result.message())
                Log.d(TAG, "getQuote: ${result}")
            }
        }
    }
}