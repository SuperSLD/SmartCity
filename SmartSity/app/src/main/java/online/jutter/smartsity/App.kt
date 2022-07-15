package online.jutter.smartsity

import androidx.appcompat.app.AppCompatDelegate
import online.jutter.roadmapview.RMMapID
import online.jutter.roadmapview.RMMapView
import online.jutter.smartsity.data.getIsDayTheme
import online.jutter.smartsity.di.appModule
import online.jutter.supersld.AppBase


class App : AppBase(appModule = appModule()) {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(
            if (baseContext.getIsDayTheme()) {
                AppCompatDelegate.MODE_NIGHT_NO
            } else {
                AppCompatDelegate.MODE_NIGHT_YES
            }
        )

        RMMapView.setMapId(RMMapID.SARATOV)
    }
}