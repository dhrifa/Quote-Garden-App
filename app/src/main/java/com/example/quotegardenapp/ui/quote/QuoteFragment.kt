package com.example.quotegardenapp.ui.quote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quotegardenapp.R
import com.example.quotegardenapp.data.model.quote.QuoteItemModel
import com.example.quotegardenapp.data.model.quote.QuoteModel
import com.example.quotegardenapp.data.model.quote.QuoteResponseModel
import com.example.quotegardenapp.databinding.FragmentQuoteBinding
import com.example.quotegardenapp.ui.Communicator
import com.example.quotegardenapp.util.NetworkResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuoteFragment : Fragment()/*, Communicator*/ {

    private var _binding: FragmentQuoteBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val quoteViewModel: QuoteViewModel by activityViewModels()

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
                       initView(it.data!!)
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

    private fun initView(data: List<QuoteItemModel>) {
        data?.let {
            binding.rvQuotes.layoutManager = LinearLayoutManager(requireContext())
            binding.rvQuotes.adapter = QuotesAdapter(data) {
//                viewModel.setSelectedPeopleIndex(it)
//                Toast.makeText(context, "${it.firstName} is clicked!", Toast.LENGTH_LONG).show()
//                findNavController().navigate(R.id.action_navigation_people_to_peopleDetailFragment)
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//    override fun quotesByFilter(author: String?) {
//        author?.let {
//        quoteViewModel.getQuotesByAuthor(author)}
//    }
}