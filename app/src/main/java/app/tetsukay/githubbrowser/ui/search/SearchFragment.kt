package app.tetsukay.githubbrowser.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import app.tetsukay.githubbrowser.R
import app.tetsukay.githubbrowser.databinding.SearchFragmentBinding

class SearchFragment : Fragment(R.layout.search_fragment) {

    private lateinit var binding: SearchFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.search_fragment,
            container,
            false
        )
        return binding.root
    }
}