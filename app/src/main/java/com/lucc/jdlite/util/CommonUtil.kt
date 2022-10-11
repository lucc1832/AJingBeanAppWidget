package com.lucc.jdlite.util

import com.lucc.jdlite.MyApplication




fun Int.dmToPx(): Int {
    return MyApplication.mInstance.resources.getDimensionPixelSize(this)
}

fun Int.dmToSp(): Int {
    return MyApplication.mInstance.resources.getDimensionPixelSize(this)
}
