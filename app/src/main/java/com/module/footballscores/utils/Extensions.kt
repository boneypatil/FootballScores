package com.module.footballscores.utils

import android.view.View
import java.text.SimpleDateFormat
import java.util.*


fun View.hide() {
    visibility = View.GONE
}

fun View.show(show:Boolean = true) {
    if(show)
        this.visibility = View.VISIBLE
    else
        this.visibility = View.GONE
}


