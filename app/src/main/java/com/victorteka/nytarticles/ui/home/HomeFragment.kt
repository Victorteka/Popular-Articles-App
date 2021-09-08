package com.victorteka.nytarticles.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.victorteka.domain.models.Article
import com.victorteka.nytarticles.R
import com.victorteka.nytarticles.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import com.victorteka.domain.Result

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel by viewModels<HomeViewModel>()
    private lateinit var adapter: PopularArticlesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupUI()
        setupData()

        return root
    }

    private fun setupData() {
        homeViewModel.articles.observe(viewLifecycleOwner){ result ->
            when(result){
                is Result.Error -> {
                    binding.articlesProgressBar.visibility = View.GONE
                    Log.d("HomeFragment", "${result.exception.message.orEmpty()}")
                }
                Result.Loading -> {
                    Log.d("HomeFragment", "Loading ...")
                    binding.articlesProgressBar.visibility = View.VISIBLE
                }
                is Result.Success -> {
                    binding.articlesProgressBar.visibility = View.GONE
                    renderList(result.data)
                }
            }
        }
    }

    private fun setupUI() {
        binding.popularArticlesRV.layoutManager = LinearLayoutManager(context)
        adapter = PopularArticlesAdapter(arrayListOf())
        binding.popularArticlesRV.addItemDecoration(
            DividerItemDecoration(
                binding.popularArticlesRV.context,
                (binding.popularArticlesRV.layoutManager as LinearLayoutManager).orientation
            )
        )
        binding.popularArticlesRV.adapter = adapter

        /*adapter.on = { food ->
            val action = AddNewMealFragmentDirections.actionAddNewMealFragmentToFoodDetailsFragment(food.food_name)
            findNavController().navigate(action)
        }*/
    }

    private fun renderList(articles: List<Article>){
        adapter.addData(articles)
        adapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}