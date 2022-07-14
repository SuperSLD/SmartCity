package online.jutter.smartsity.ui.ext

import android.content.res.Resources

val Int.dpToPx: Int
    get() = (this * Resources.getSystem().displayMetrics.scaledDensity).toInt()
