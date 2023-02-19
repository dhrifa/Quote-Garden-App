package com.example.quotegardenapp.ui.quote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.quotegardenapp.data.model.quote.QuoteModel
import com.example.quotegardenapp.databinding.FragmentQuoteBinding
import com.example.quotegardenapp.util.NetworkResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuoteFragment : Fragment() {

    private var _binding: FragmentQuoteBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuoteBinding.inflate(inflater, container, false)
        binding.let {

           quoteViewModel.listQuotes.observe(viewLifecycleOwner){
               when (it) {
                   is NetworkResult.Loading -> {
                       Toast.makeText(context, "Loading...!", Toast.LENGTH_SHORT).show()
                   }
                   is NetworkResult.Success -> {
                       Toast.makeText(context, "data...!", Toast.LENGTH_SHORT).show()
                       val textView: TextView = binding.textQuote
                       textView.text = it.data.toString()
                       initView(it.data)
                   }
                   is NetworkResult.Error -> {
                       Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                   }
               }
           }
            quoteViewModel.getQuoteList()
        }
        return binding.root
    }

    private fun initView(data: QuoteModel?) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}