package online.jutter.smartsity.common.extesions

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources

/**
 * ????????????
 * миленько, но зачем оно тут хз
 */
val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

/**
 * Отображение красивого тоста с текстом
 * и иконкой.
 * @param iconId иконка.
 * @param message само сообщение.
 *
 * @author Leonid Solyanoy (solyanoy.leonid@gmail.com)
 */
@SuppressLint("InflateParams")
fun Context.showToast(iconId: Int, message: String = "", isLong: Boolean = false) {
//    val view = LayoutInflater.from(this).inflate(R.layout.view_toast, null, false)
//    val tvMessage = view.findViewById<TextView>(R.id.tvMessage)
//    val ivIcon = view.findViewById<ImageView>(R.id.ivIcon)
//
//    tvMessage.text = message
//    if (Build.VERSION.SDK_INT > 24) {
//        ivIcon.setImageDrawable(ContextCompat.getDrawable(this, iconId))
//    } else {
//        ivIcon.visibility = View.GONE
//    }
//
//    val toast = Toast(this)
//    toast.setGravity(Gravity.BOTTOM, 0, 80.px)
//    toast.duration = if (isLong) Toast.LENGTH_LONG else Toast.LENGTH_SHORT
//    toast.view = view
//    toast.show()
}