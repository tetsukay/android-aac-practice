package app.tetsukay.githubbrowser.ui.search

import androidx.recyclerview.widget.RecyclerView
import app.tetsukay.githubbrowser.databinding.SearchListItemBinding
import app.tetsukay.githubbrowser.model.GitHubRepo

class SearchAdapter(
    private val data: List<GitHubRepo>
) : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: SearchListItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}