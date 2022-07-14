package online.jutter.smartsity.data

import android.content.Context
import com.google.gson.Gson
import online.jutter.roadmapview.data.models.map.RMMarker
import online.jutter.supersld.common.PreferenceHelper

const val MAIN_PREFS = "main_prefs"

const val IS_DAY_THEME = "is_day_theme"
const val HOME_MARKER = "home_marker"

fun Context.saveIsDayTheme(day: Boolean) {
    PreferenceHelper.customPrefs(this, MAIN_PREFS).edit().putBoolean(IS_DAY_THEME, day).apply()
}

fun Context.getIsDayTheme(): Boolean {
    return PreferenceHelper.customPrefs(this, MAIN_PREFS).getBoolean(IS_DAY_THEME, true)
}

fun Context.saveHomeMarker(marker: RMMarker) {
    PreferenceHelper.customPrefs(this, MAIN_PREFS).edit().putString(HOME_MARKER, Gson().toJson(marker)).apply()
}

fun Context.getHomeMarker(): RMMarker? {
    return Gson().fromJson(
        PreferenceHelper.customPrefs(this, MAIN_PREFS).getString(HOME_MARKER, null),
        RMMarker::class.java
    )
}