package com.module.footballscores.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.module.footballscores.model.MatchResults
import com.module.footballscores.network.MatchResultSource
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MatchResultViewModel @Inject constructor(private val matchResultSource: MatchResultSource) : ViewModel() {

    val matchResultLiveData: LiveData<List<MatchResults>>
        get() = _matchResultLiveData
    private val _matchResultLiveData = MutableLiveData<List<MatchResults>>()

    val isLoading: LiveData<Boolean>
        get() = _isLoading
    private val _isLoading = MutableLiveData<Boolean>()


    init {
        loadMatchResult()
    }

     fun loadMatchResult() {
        _isLoading.value = true
        viewModelScope.launch {
            try {



            val resultOneDeferred = async {  matchResultSource.getMatchResultsSource1() }
            val resultTwoDeferred = async { matchResultSource.getMatchResultsSource2() }

            val combine = resultOneDeferred.await()+resultTwoDeferred.await()
            _isLoading.postValue(false)
            _matchResultLiveData.postValue(combine)
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }
}
