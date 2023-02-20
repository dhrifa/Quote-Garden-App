package com.example.quotegardenapp.ui.genre

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quotegardenapp.data.model.genre.GenreModel
import com.example.quotegardenapp.databinding.FragmentGenreBinding
import com.example.quotegardenapp.ui.quote.QuotesAdapter
import com.example.quotegardenapp.util.NetworkResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GenreFragment : Fragment() {

    private var _binding: FragmentGenreBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val genreViewModel: GenreViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGenreBinding.inflate(inflater, container, false)
        binding.let {

            genreViewModel.listGenres.observe(viewLifecycleOwner){
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
            genreViewModel.getGenreList()
        }
        return binding.root
    }

    private fun initView(data: List<String>) {
        data?.let {
            binding.rvGenres.layoutManager = GridLayoutManager(requireContext(),2)
            binding.rvGenres.adapter = GenresAdapter(data) {
//                viewModel.setSelectedPeopleIndex(it)
                Toast.makeText(context, "${it} is clicked!", Toast.LENGTH_LONG).show()
//                findNavController().navigate(R.id.action_navigation_people_to_peopleDetailFragment)
            }}
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}