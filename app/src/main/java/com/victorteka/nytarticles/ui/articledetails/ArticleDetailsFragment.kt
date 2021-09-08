package com.victorteka.nytarticles.ui.articledetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.victorteka.nytarticles.R

class ArticleDetailsFragment : Fragment() {

    private lateinit var viewModel: ArticleDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(ArticleDetailsViewModel::class.java)
        return inflater.inflate(R.layout.article_details_fragment, container, false)
    }

}