package com.example.movieapp.fragments.home

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val movieViewModel: HomeViewModel by viewModels()
    private lateinit var homeAdapter: HomeAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareHomeAdapter()
        getMovies()

    }


    private fun getMovies() {
        binding.homeLottieAnimation.visibility = View.VISIBLE
        movieViewModel.movie.observe(viewLifecycleOwner) { movie ->
            binding.homeLottieAnimation.visibility = View.GONE
            homeAdapter.setMovies(movie)
        }
            movieViewModel.getMovie()
    }

    private fun prepareHomeAdapter() {
        homeAdapter = HomeAdapter(listOf()) { imdb , id->
            val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(imdb,id)
            findNavController().navigate(action)
        }
        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.homeRecyclerview.layoutManager = layoutManager
        binding.homeRecyclerview.adapter = homeAdapter
    }

}