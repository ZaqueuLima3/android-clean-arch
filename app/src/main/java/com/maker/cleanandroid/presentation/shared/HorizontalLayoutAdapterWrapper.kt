package com.maker.cleanandroid.presentation.shared

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maker.cleanandroid.databinding.HorizontalLayoutListBinding

class HorizontalLayoutAdapterWrapper<T : RecyclerView.Adapter<*>>(
    private val bindAdapter: T
) : RecyclerView.Adapter<HorizontalLayoutAdapterWrapper<T>.ConcatViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConcatViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HorizontalLayoutListBinding.inflate(inflater, parent, false)
        return ConcatViewHolder(binding)
    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: ConcatViewHolder, position: Int) =
        holder.bind(bindAdapter)

    inner class ConcatViewHolder(private val binding: HorizontalLayoutListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(adapter: T) {
            binding.apply {
                recyclerview.adapter = adapter
            }
        }
    }
}
