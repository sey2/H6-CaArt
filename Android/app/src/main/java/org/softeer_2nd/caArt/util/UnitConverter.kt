package org.softeer_2nd.caArt.util

import android.content.Context
import android.util.DisplayMetrics

fun Int.px2dp(context: Context): Float {
    val dpi = context.resources.displayMetrics.densityDpi.toFloat()
    val density = DisplayMetrics.DENSITY_DEFAULT
    return this * dpi / density
}

fun Float.dp2px(context: Context): Int {
    val dpi = context.resources.displayMetrics.densityDpi.toFloat()
    val density = DisplayMetrics.DENSITY_DEFAULT
    return (this * dpi / density).toInt()
}