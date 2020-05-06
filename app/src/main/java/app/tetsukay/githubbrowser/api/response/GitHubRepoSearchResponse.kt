package app.tetsukay.githubbrowser.api.response

import app.tetsukay.githubbrowser.model.GitHubRepo
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GitHubRepoSearchResponse(
    @Json(name = "total_count")
    val total: Int = 0,
    @Json(name = "items")
    val items: List<GitHubRepo>
)
