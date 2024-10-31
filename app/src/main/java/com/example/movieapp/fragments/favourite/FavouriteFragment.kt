package com.example.movieapp.fragments.favourite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movieapp.databinding.FragmentFavouriteBinding


class FavouriteFragment : Fragment() {
    private lateinit var binding: FragmentFavouriteBinding
    private val favouriteViewModel: FavouriteViewModel by viewModels()
    private lateinit var favouriteAdapter: FavouriteAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFavouriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupFavouriteAdapter()
        loadDataFromDatabase()
    }

    private fun setupFavouriteAdapter() {
        favouriteAdapter = FavouriteAdapter(listOf()) { movie ->
            val action =
                FavouriteFragmentDirections.actionFavouriteFragment2ToDetailsFragment(movie)
            findNavController().navigate(action)
        }
        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.favouriteRecyclerview.apply {
            adapter = favouriteAdapter
            this.layoutManager = layoutManager
        }
    }

    private fun loadDataFromDatabase() {
        favouriteViewModel.readAllData.observe(viewLifecycleOwner) { movies ->
            favouriteAdapter.setDataToFavourite(movies)

            if (movies.isEmpty()) {
                binding.textNoFavourite.visibility = View.VISIBLE
            } else {
                binding.textNoFavourite.visibility = View.GONE
            }

        }
    }

}