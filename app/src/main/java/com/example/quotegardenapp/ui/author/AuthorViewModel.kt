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
    private var _listAuthors = MutableLiveData<NetworkResult<List<String>>>()
    val listAuthors: LiveData<NetworkResult<List<String>>> = _listAuthors

    private val _text = MutableLiveData<String>().apply {
        value = "This is author Fragment"
    }
    val text: LiveData<String> = _text

    fun getAuthorList() {
        viewModelScope.launch {

            _listAuthors.value = NetworkResult.Loading()
            val result = repository.getAuthors()

            if (result.isSuccessful) {
                result.body()?.data?.let {
                    _listAuthors.value = NetworkResult.Success(it!!)
                }
            } else {
                _listAuthors.value = NetworkResult.Error(result.message())
            }
        }
    }


}