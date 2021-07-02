package com.module.footballscores.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.module.footballscores.model.MatchResults
import com.module.footballscores.network.MatchResultSource
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MatchResultViewModel @Inject constructor(private val matchResultSource: MatchResultSource) : ViewModel() {

    val weeklyNewsLiveData: LiveData<List<MatchResults>>
        get() = _weeklyNewsLiveData
    private val _weeklyNewsLiveData = MutableLiveData<List<MatchResults>>()

    val isLoading: LiveData<Boolean>
        get() = _isLoading
    private val _isLoading = MutableLiveData<Boolean>()

    val redirectToAllNewsLiveData: LiveData<Any>
        get() = _redirectToAllNewsLiveData
    private val _redirectToAllNewsLiveData = MutableLiveData<Any>()

    init {
        loadMatchResult()
    }

    private fun loadMatchResult() {
        _isLoading.value = true
        viewModelScope.launch {
            val news =
                matchResultSource.getMatchResultsSource1()

            _isLoading.postValue(false)
            _weeklyNewsLiveData.postValue(news)
        }
    }
}
