package com.ewingelen.github.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ewingelen.github.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val innerQuoteLiveData = MutableLiveData<String>()
    val quoteLiveData: LiveData<String> = innerQuoteLiveData

    fun loadQuote() {
        viewModelScope.launch {
            val quote = repository.loadQuote()
            innerQuoteLiveData.value = quote
        }
    }
}
