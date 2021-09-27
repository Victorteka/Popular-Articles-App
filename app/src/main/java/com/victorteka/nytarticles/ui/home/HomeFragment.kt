package com.victorteka.nytarticles.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.victorteka.data.network.toDto
import com.victorteka.domain.models.Article
import com.victorteka.nytarticles.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

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
        homeViewModel.articles.observe(viewLifecycleOwner) { result ->
           if (result.isNotEmpty()){
               renderList(result)
           }else{
               Log.d("TAG", "Something went wrong!")
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

        adapter.onArticleClicked = { article ->
            val action = HomeFragmentDirections.actionNavHomeToArticleDetailsFragment(article.toDto())
            findNavController().navigate(action)
        }
    }

    private fun renderList(articles: List<Article>) {
        adapter.addData(articles)
        adapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}