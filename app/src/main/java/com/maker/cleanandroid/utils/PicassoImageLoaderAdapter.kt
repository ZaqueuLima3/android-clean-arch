package com.maker.cleanandroid.utils

import android.widget.ImageView
import com.maker.cleanandroid.presentation.protocols.ImageLoader
import com.squareup.picasso.Picasso

class PicassoImageLoaderAdapter : ImageLoader {
    override fun load(imageUrl: String, view: ImageView) {
        Picasso.get().load(imageUrl).into(view)
    }
}