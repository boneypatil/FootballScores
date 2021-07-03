package com.module.footballscores.ui.adapters

import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

import com.module.footballscores.R
import java.text.SimpleDateFormat
import java.util.*

//Binding adapter used to display images from URL using Glide
@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imgUrl: String?) {

    Glide.with(imageView.context)
        .load("$imgUrl")
        .apply(
            RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image)
        )
        .into(imageView)
}



const val TIMESTAMP_DATE_FORMAT_12H = "dd MMMM yyyy hh:mm"
@BindingAdapter("dateTime")
fun getCurrentDateTime(tv:TextView) {
    val sdf = SimpleDateFormat(
        TIMESTAMP_DATE_FORMAT_12H
    )

    tv?.text = sdf.format(Date())
}

@BindingAdapter("avaURL")
fun bindAva(imageView: ImageView, imgUrl: Uri?) {

    Glide.with(imageView.context)
        .load(imgUrl)
        .circleCrop()
        .apply(
            RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image)
        )
        .into(imageView)
}



