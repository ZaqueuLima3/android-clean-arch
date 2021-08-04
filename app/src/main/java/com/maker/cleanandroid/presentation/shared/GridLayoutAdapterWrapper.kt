package com.maker.cleanandroid.presentation.shared

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.maker.cleanandroid.databinding.GridLayoutListBinding

class GridLayoutAdapterWrapper<T : RecyclerView.Adapter<*>>(
    private val bindAdapter: T,
    private val columns: Int
) : RecyclerView.Adapter<GridLayoutAdapterWrapper<T>.ConcatViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConcatViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = GridLayoutListBinding.inflate(inflater, parent, false)
        return ConcatViewHolder(binding, parent.context)
    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: ConcatViewHolder, position: Int) =
        holder.bind(bindAdapter)

    inner class ConcatViewHolder(
        private val binding: GridLayoutListBinding,
        private val context: Context
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(adapter: T) {
            binding.apply {
                recyclerview.adapter = adapter
                recyclerview.layoutManager = GridLayoutManager(context, columns)
            }
        }
    }
}
