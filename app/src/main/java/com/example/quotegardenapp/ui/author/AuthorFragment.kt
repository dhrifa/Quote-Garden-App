package com.example.quotegardenapp.ui.author

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.quotegardenapp.data.model.author.AuthorModel
import com.example.quotegardenapp.databinding.FragmentAuthorBinding
import com.example.quotegardenapp.util.NetworkResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthorFragment : Fragment() {

    private var _binding: FragmentAuthorBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val authorViewModel:AuthorViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAuthorBinding.inflate(inflater, container, false)
        binding.let {

            authorViewModel.listAuthors.observe(viewLifecycleOwner){
                when (it) {
                    is NetworkResult.Loading -> {
                        Toast.makeText(context, "Loading...!", Toast.LENGTH_SHORT).show()
                    }
                    is NetworkResult.Success -> {
                        Toast.makeText(context, "data...!", Toast.LENGTH_SHORT).show()
                        val textView: TextView = binding.textAuthor
                        textView.text = it.data.toString()
                        initView(it.data)
                    }
                    is NetworkResult.Error -> {
                        Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
            authorViewModel.getAuthorList()
        }
        return binding.root
    }

    private fun initView(data: AuthorModel?) {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}