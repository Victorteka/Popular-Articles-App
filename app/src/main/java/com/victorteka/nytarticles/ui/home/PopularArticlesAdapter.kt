package com.victorteka.nytarticles.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.victorteka.domain.models.Article
import com.victorteka.nytarticles.databinding.ArticleItemBinding

class PopularArticlesAdapter(private val articles: ArrayList<Article>) :
    RecyclerView.Adapter<PopularArticlesAdapter.ArticleViewHolder>() {

    var onArticleClicked: ((Article) -> Unit)? = null

    inner class ArticleViewHolder(private val binding: ArticleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.showMoreIcon.setOnClickListener {
                onArticleClicked?.invoke(articles[adapterPosition])
            }
        }

        fun bind(article: Article) {
            binding.articleTitle.text = article.title
            binding.datePublished.text = article.published_date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ArticleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articles[position])
    }

    override fun getItemCount(): Int = articles.size

    fun addData(list: List<Article>) {
        articles.addAll(list)
    }
}