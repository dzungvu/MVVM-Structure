package com.thedung.mvvmstructure.classes.utils

import android.content.Context
import android.graphics.drawable.Drawable
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.executor.GlideExecutor
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions

@GlideModule
class GlideUtil : AppGlideModule() {
    override fun applyOptions(context: Context, builder: GlideBuilder) {
        builder.run {
            setDefaultTransitionOptions(Drawable::class.java, DrawableTransitionOptions.withCrossFade(100))
            setDefaultRequestOptions(
                RequestOptions()
                    .format(DecodeFormat.PREFER_RGB_565)
                    .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                    .centerInside()
            )
            setAnimationExecutor(GlideExecutor.newUnlimitedSourceExecutor())
        }
    }
}