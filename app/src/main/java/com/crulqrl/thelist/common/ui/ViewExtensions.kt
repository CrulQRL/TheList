package com.crulqrl.thelist.common.ui

import android.widget.EditText
import androidx.lifecycle.Lifecycle
import com.crulqrl.thelist.util.DebounceTextWatcher

fun EditText.onTextChanged(debouncePeriod: Long, lifecycle: Lifecycle, onDebounceTextChange: (CharSequence) -> Unit) {
    addTextChangedListener(DebounceTextWatcher(debouncePeriod, lifecycle, onDebounceTextChange))
}