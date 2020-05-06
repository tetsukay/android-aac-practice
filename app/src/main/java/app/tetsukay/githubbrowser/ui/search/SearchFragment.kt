package app.tetsukay.githubbrowser.ui.search

import android.content.Context
import android.os.Bundle
import android.os.IBinder
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // LiveDataをViewBindingするのに必要
        // Fragment自身ではなく、viewLifecycleOwnerを渡す（ライフサイクルの問題）
        // Detail: https://satoshun.github.io/2018/12/view_lifecycle/
        binding.lifecycleOwner = viewLifecycleOwner

        initSearchInputListener()
    }

    private fun initSearchInputListener() {
        // IMEのACTION_SEARCHが押されたときの処理
        binding.input.setOnEditorActionListener { view: View, actionId: Int, _: KeyEvent? ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                doSearch(view)
                // イベントハンドリングを完了後、ここで動作を止める場合は true を返却する。
                true
            } else {
                false
            }
        }
        // Keyboardのエンターキーなどが押されたときの処理
        binding.input.setOnKeyListener { view: View, keyCode: Int, event: KeyEvent ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                doSearch(view)
                // イベントハンドリングを完了後、ここで動作を止める場合は true を返却する。
                true
            } else {
                false
            }
        }
    }

    private fun doSearch(v: View) {
        val query = binding.input.text.toString()
        // Dismiss keyboard
        dismissKeyboard(v.windowToken)
    }

    private fun dismissKeyboard(windowToken: IBinder) {
        (requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).apply {
            hideSoftInputFromWindow(windowToken, 0)
        }
    }
}