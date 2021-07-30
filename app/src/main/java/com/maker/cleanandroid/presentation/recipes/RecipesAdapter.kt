package com.maker.cleanandroid.presentation.recipes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.maker.cleanandroid.R
import com.maker.cleanandroid.databinding.ItemRecipeBinding
import com.maker.cleanandroid.domain.model.Recipe
import com.maker.cleanandroid.presentation.protocols.ImageLoader

class RecipesAdapter(
    private val imageLoader: ImageLoader
) : ListAdapter<Recipe, RecipesAdapter.ViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val binding = ItemRecipeBinding.inflate(inflate,parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemRecipeBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Recipe) {
            binding.apply {
                tvTitle.text = item.title
                tvDescription.text = item.summary
                tvClock.text = item.readyInMinutes.toString()
                tvLike.text = item.aggregateLikes.toString()
                imageLoader.load(item.image, ivRecipe)
            }
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<Recipe>() {
    override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe) = oldItem == newItem
    override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe) = oldItem.id == newItem.id
}
