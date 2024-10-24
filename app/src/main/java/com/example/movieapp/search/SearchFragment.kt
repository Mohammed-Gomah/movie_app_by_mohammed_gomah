package com.example.movieapp.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private val movieViewModel: SearchViewModel by viewModels()
    private lateinit var searchAdapter: SearchAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareAdapter()
        setupSearchListener()
        observeViewModel()

    }

    private fun prepareAdapter() {
        searchAdapter = SearchAdapter(listOf()){movieImdb->
            val action = SearchFragmentDirections.actionSearchFragmentToDetailsFragment(movieImdb)
            findNavController().navigate(action)
        }
        binding.searchRecyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = searchAdapter
        }
    }

    private fun observeViewModel() {
        movieViewModel.movie.observe(viewLifecycleOwner) { movies ->
            searchAdapter.filterList(movies)
        }
    }

    private fun setupSearchListener() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (!newText.isNullOrEmpty()) {
                    movieViewModel.searchMovieByName(newText)
                }
                return true
            }
        })

    }

}