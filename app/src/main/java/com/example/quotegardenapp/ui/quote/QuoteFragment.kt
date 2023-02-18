package com.example.quotegardenapp.ui.quote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.quotegardenapp.databinding.FragmentQuoteBinding

class QuoteFragment : Fragment() {

    private var _binding: FragmentQuoteBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val quoteViewModel =
            ViewModelProvider(this).get(QuoteViewModel::class.java)

        _binding = FragmentQuoteBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textQuote
        quoteViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}