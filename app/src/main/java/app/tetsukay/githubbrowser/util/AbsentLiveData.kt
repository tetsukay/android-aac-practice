package app.tetsukay.githubbrowser.util

import androidx.lifecycle.LiveData

/**
 * `null` を値に持つだけのLiveData
 */
class AbsentLiveData<T : Any?> private constructor() : LiveData<T>() {
    init {
        // use post instead of set since this can be created on any thread
        postValue(null)
    }

    companion object {
        fun <T> create(): LiveData<T> {
            return AbsentLiveData()
        }
    }
}
