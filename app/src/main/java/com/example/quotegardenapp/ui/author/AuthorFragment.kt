package com.example.quotegardenapp.ui.author

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.quotegardenapp.databinding.FragmentAuthorBinding

class AuthorFragment : Fragment() {

    private var _binding: FragmentAuthorBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val authorViewModel =
            ViewModelProvider(this).get(AuthorViewModel::class.java)

        _binding = FragmentAuthorBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textAuthor
        authorViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}