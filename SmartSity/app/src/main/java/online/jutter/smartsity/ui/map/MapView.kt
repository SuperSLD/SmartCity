package online.jutter.smartsity.ui.map

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import online.jutter.roadmapview.data.models.map.RMMarker

interface MapView: MvpView {

    @StateStrategyType(SkipStrategy::class)
    fun findRoad(markers: Pair<RMMarker, RMMarker>)
}