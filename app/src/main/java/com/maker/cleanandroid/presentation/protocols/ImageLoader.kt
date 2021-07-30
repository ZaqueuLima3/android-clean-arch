package com.maker.cleanandroid.presentation.protocols

import android.widget.ImageView

interface ImageLoader {
    fun load(imageUrl: String, view: ImageView)
}