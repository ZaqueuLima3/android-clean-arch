package com.maker.cleanandroid.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.maker.cleanandroid.presentation.protocols.ImageLoader

class GlideImageLoaderAdapter(
    private val context: Context
) : ImageLoader {
    override fun load(imageUrl: String, view: ImageView) {
        Glide.with(context).load(imageUrl).into(view)
    }
}
