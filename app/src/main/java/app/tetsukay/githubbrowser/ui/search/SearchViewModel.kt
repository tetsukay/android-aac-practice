package app.tetsukay.githubbrowser.ui.search

import androidx.lifecycle.*
import app.tetsukay.githubbrowser.api.response.GitHubRepoSearchResponse
import app.tetsukay.githubbrowser.model.Resource
import app.tetsukay.githubbrowser.repository.GitHubRepository
import java.util.*

class SearchViewModel : ViewModel() {

    private val repository = GitHubRepository()
    private val _query = MutableLiveData<String>()
    val searchResult: LiveData<Resource<GitHubRepoSearchResponse>> = _query.switchMap {
        liveData<Resource<GitHubRepoSearchResponse>> {
            emitSource(
                repository.search(it).asLiveData()
            )
        }
    }

    fun setQuery(originalInput: String) {
        val input = originalInput.toLowerCase(Locale.getDefault()).trim()
        if (input == _query.value) {
            return
        }
        _query.value = input
    }
}