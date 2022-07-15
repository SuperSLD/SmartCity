package online.jutter.smartsity.ui.map

import com.arellomobile.mvp.InjectViewState
import online.jutter.smartsity.Screens
import online.jutter.smartsity.domain.controllers.NavigationController
import online.jutter.supersld.common.base.BasePresenter
import org.koin.core.inject

@InjectViewState
class MapPresenter: BasePresenter<MapView>() {

    private val navigationController: NavigationController by inject()

    override fun attachView(view: MapView?) {
        super.attachView(view)
        navigationController.get()?.let { viewState.findRoad(it) }
    }

    fun onOpenNavigation() {
        router?.navigateTo(Screens.Navigation)
    }

    fun back() {
        router?.exit()
    }
}