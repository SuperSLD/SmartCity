package online.jutter.smartsity.common.extesions

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.core.app.ActivityCompat
import java.util.*

fun Vibrator.shortVibration() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE))
    } else {
        vibrate(100)
    }
}

fun Context.openWebLink(link: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
    startActivity(intent)
}

/**
 * Получение первых нескольких элементов списка.
 * @param count количество элементов.
 */
fun <T> MutableList<T>.firstItems(count: Int): MutableList<T> {
    val result = mutableListOf<T>()
    for (i in 0 until (if (count > this.size) this.size else count)) {
        result.add(this[i])
    }
    return result
}

/**
 * Duplicate any model for test.
 * @param count - size new list
 */
fun <T> T.toList(count: Int): MutableList<T> = mutableListOf<T>().apply {
    for (i in 0 until count) this.add(this@toList)
}

/**
 * Получение UUID строки.
 */
fun getUUID(): String {
    return UUID.randomUUID().toString()
}

fun Context.geoEnabled() = ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED