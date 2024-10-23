package com.example.movieapp.details

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private val detailsViewModel: DetailsViewModel by viewModels()
    private val args: DetailsFragmentArgs by navArgs()
    private lateinit var movieId: String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieId = args.movieId
        getMovieDetailsById(movieId)
    }

    private fun getMovieDetailsById(id: String) {
        detailsViewModel.getMovieById(id)
        binding.progressBar.visibility = View.VISIBLE
        detailsViewModel.movie.observe(viewLifecycleOwner) { movie ->
            binding.progressBar.visibility = View.GONE
            binding.apply {
                detailsMovieName.text = movie.name
                movieSummary.text = Html.fromHtml(movie.summary, Html.FROM_HTML_MODE_LEGACY)
            }
            Glide.with(this)
                .load(movie.image?.original)
                .into(binding.detailsImage)
        }
    }


}