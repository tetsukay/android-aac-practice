package app.tetsukay.githubbrowser.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import app.tetsukay.githubbrowser.R
import app.tetsukay.githubbrowser.databinding.SearchListItemBinding
import app.tetsukay.githubbrowser.model.GitHubRepo

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    private var data: List<GitHubRepo> = listOf()

    inner class ViewHolder(val binding: SearchListItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.search_list_item,
                parent, false
            )
        )

    override fun getItemCount(): Int = data.size

    fun setData(data: List<GitHubRepo>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.repo = data[position]
    }
}