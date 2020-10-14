package com.crulqrl.thelist.util

import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import kotlinx.coroutines.*

class DebounceTextWatcher (
    private var debouncePeriod: Long = 500,
    lifecycle: Lifecycle,
    private val onDebounceTextChange: (CharSequence) -> Unit
) : TextWatcher, LifecycleObserver {

    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Main)
    private var debounceJob: Job? = null

    init {
        lifecycle.addObserver(this)
    }

    override fun afterTextChanged(p0: Editable?) {
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        debounceJob?.cancel()
        debounceJob = coroutineScope.launch {
            p0?.let {
                delay(debouncePeriod)
                onDebounceTextChange(p0)
            }
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun destroy() {
        debounceJob?.cancel()
    }
}