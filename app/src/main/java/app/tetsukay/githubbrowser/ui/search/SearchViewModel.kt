package app.tetsukay.githubbrowser.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class SearchViewModel : ViewModel() {

    private val _query = MutableLiveData<String>()
    val query: LiveData<String> = _query

    fun setQuery(originalInput: String) {
        val input = originalInput.toLowerCase(Locale.getDefault()).trim()
        if (input == _query.value) {
            return
        }
        _query.value = input
    }
}