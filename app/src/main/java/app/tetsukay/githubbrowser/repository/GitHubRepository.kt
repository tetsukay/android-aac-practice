package app.tetsukay.githubbrowser.repository

import app.tetsukay.githubbrowser.api.GitHubService
import app.tetsukay.githubbrowser.api.response.GitHubRepoSearchResponse
import app.tetsukay.githubbrowser.model.Resource
import app.tetsukay.githubbrowser.model.Status
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.flow.flow
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class GitHubRepository {

    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    private val gitHubService = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl("https://api.github.com")
        .build()
        .create(GitHubService::class.java)

    suspend fun search(query: String) = flow<Resource<GitHubRepoSearchResponse>> {
        emit(Resource(Status.LOADING, null))
        runCatching {
            gitHubService.searchRepos(query)
        }.onSuccess {
            emit(
                Resource(Status.SUCCESS, it)
            )
        }.onFailure {
            emit(Resource(Status.ERROR, null, it.message))
        }
    }
}