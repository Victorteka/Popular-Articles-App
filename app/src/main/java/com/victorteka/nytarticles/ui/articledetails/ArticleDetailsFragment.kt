package com.victorteka.nytarticles.ui.articledetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.victorteka.nytarticles.R
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.victorteka.nytarticles.databinding.ArticleDetailsFragmentBinding


class ArticleDetailsFragment : Fragment() {

    private lateinit var viewModel: ArticleDetailsViewModel
    private lateinit var binding: ArticleDetailsFragmentBinding

    private val args: ArticleDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(ArticleDetailsViewModel::class.java)
        binding = ArticleDetailsFragmentBinding.inflate(inflater, container, false)
        binding.toolbar.title = args.articleInfo.title
        binding.witters.text = args.articleInfo.byline
        binding.webView.apply {
            settings.javaScriptEnabled = true
            webViewClient = object : WebViewClient(){
                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                    if (url != null) {
                        view?.loadUrl(url)
                    }
                    return true
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    binding.progressBar.visibility = View.GONE
                }
            }
            loadUrl(args.articleInfo.url)
        }
        return binding.root
    }

    override fun onResume() {
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }
}