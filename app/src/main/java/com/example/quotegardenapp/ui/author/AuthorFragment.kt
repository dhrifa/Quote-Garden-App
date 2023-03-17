package com.example.quotegardenapp.ui.author

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quotegardenapp.R
import com.example.quotegardenapp.databinding.FragmentAuthorBinding
import com.example.quotegardenapp.ui.common.Communicator
import com.example.quotegardenapp.ui.common.SharedViewModel
import com.example.quotegardenapp.util.NetworkResult
import dagger.hilt.android.AndroidEntryPoint
private const val TAG ="AuthorFragment"
@AndroidEntryPoint
class AuthorFragment : Fragment() {

//    lateinit var communicator: Communicator
    private var _binding: FragmentAuthorBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val authorViewModel: AuthorViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

//    override fun onAttach(context: Context) {//called before oncreate
//        super.onAttach(context)//the context is the host activity, here is mainactivity
//        when (context) {
//            is Communicator -> communicator = context
//            else -> throw IllegalAccessException("Incorrect Host Activity")
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAuthorBinding.inflate(inflater, container, false)
        binding.let {

            authorViewModel.listAuthors.observe(viewLifecycleOwner) {
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
            authorViewModel.getAuthorList()
        }
        return binding.root
    }

    private fun initView(data: List<String>) {
        data?.let {
            binding.rvAuthors.layoutManager = GridLayoutManager(requireContext(), 2)
            binding.rvAuthors.adapter = AuthorsAdapter(data) {
//                communicator.quotesByFilter(it)
                Log.d(TAG, "initView: $it")
                sharedViewModel.setAuthor(it)
                Toast.makeText(context, "$it is clicked!", Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.action_nav_author_to_nav_quote)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}