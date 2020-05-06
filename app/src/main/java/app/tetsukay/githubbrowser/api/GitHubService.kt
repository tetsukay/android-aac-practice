package app.tetsukay.githubbrowser.api

import app.tetsukay.githubbrowser.api.response.GitHubRepoSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GitHubService {
    @GET("search/repositories")
    suspend fun searchRepos(@Query("q") query: String): GitHubRepoSearchResponse
}
