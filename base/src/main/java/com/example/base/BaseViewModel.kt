package com.example.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    private var job: Job? = null

    protected fun <T> ViewModel.launchWithCancel(
        stateFlow: MutableStateFlow<T>,
        loading: T,
        block: suspend CoroutineScope.() -> Unit
    ) {
        job = job?.cancel().run {
            viewModelScope.launch {
                stateFlow.emit(loading)
                block()
            }
        }
    }

    protected fun ViewModel.launchMultipleWithCancel(
        loadingStates: List<Pair<MutableStateFlow<*>, Any>>,
        block: suspend CoroutineScope.() -> Unit
    ) {
        job = job?.cancel().run {
            viewModelScope.launch {
                // Emit loading states
                loadingStates.forEach { (flow, loadingValue) ->
                    @Suppress("UNCHECKED_CAST")
                    (flow as MutableStateFlow<Any>).emit(loadingValue)
                }

                block()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}