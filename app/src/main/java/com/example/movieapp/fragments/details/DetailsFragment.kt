package com.example.movieapp.fragments.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private val detailsViewModel: DetailsViewModel by viewModels()
    private val args: DetailsFragmentArgs by navArgs()
    private lateinit var movieId: String
    private lateinit var actorAdapter: ActorAdapter


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
        prepareActorAdapter()
        observeFavouriteToggle()
        setupFavouriteToggle()
    }

    private fun observeFavouriteToggle() {
        detailsViewModel.isFavourite.observe(viewLifecycleOwner) { isFavourite ->
            binding.addToFavourite.setImageResource(
                if (isFavourite == true) {
                    R.drawable.ic_favourite_filled
                }
                else {
                    R.drawable.ic_favourite_border
                }
            )
        }
    }

    private fun setupFavouriteToggle(){
        binding.addToFavourite.setOnClickListener {
            val currentFavouriteState = detailsViewModel.isFavourite.value ?:false
            if (currentFavouriteState){
                detailsViewModel.deleteMovie()
                Toast.makeText(requireContext(), "Removed", Toast.LENGTH_SHORT).show()
            }else{
                detailsViewModel.insertMovie()
                Toast.makeText(requireContext(), "Saved", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun prepareActorAdapter() {
        actorAdapter = ActorAdapter(listOf())
        val layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.topCastRecyclerview.apply {
            this.layoutManager = layoutManager
            adapter = actorAdapter
        }
    }

    private fun getMovieDetailsById(id: String) {
        detailsViewModel.getMovieDetailsById(id)
        binding.progressBar.visibility = View.VISIBLE
        detailsViewModel.movie.observe(viewLifecycleOwner) { movie ->
            binding.progressBar.visibility = View.GONE
            binding.apply {
                detailsMovieName.text = movie.name
                movieSummary.text = Html.fromHtml(movie.summary, Html.FROM_HTML_MODE_LEGACY)
                tvStatus.text = movie.status
                tvLanguage.text = movie.language
                tvRate.text = movie.rating?.average.toString()
                tvPremiered.text = movie.premiered?.split("-")?.get(0) ?: ""
                tvNetwork.text = movie.network?.name
                btnOfficialSite.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(movie.officialSite))
                    startActivity(intent)
                }
            }

            Glide.with(this)
                .load(movie.image?.original)
                .into(binding.detailsImage)
        }
    }


}