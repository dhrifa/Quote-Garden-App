package com.example.quotegardenapp.ui.genre

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quotegardenapp.data.model.genre.GenreModel
import com.example.quotegardenapp.data.repository.Repository
import com.example.quotegardenapp.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "GenreViewModel"
@HiltViewModel
class GenreViewModel @Inject constructor(
 private val  repository: Repository
) : ViewModel() {
    private var _listGenres = MutableLiveData<NetworkResult<List<String>>>()
    val listGenres: LiveData<NetworkResult<List<String>>> = _listGenres

    private val _text = MutableLiveData<String>().apply {
        value = "This is genre Fragment"
    }
    val text: LiveData<String> = _text

    fun getGenreList() {
        viewModelScope.launch {

            _listGenres.value = NetworkResult.Loading()
            val result = repository.getGenres()

            if (result.isSuccessful) {
                result.body()?.data?.let {
                    _listGenres.value = NetworkResult.Success(it!!)
                }
            } else {
                _listGenres.value = NetworkResult.Error(result.message())
            }
        }
    }
}