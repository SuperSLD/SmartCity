package online.jutter.smartsity.ui.map

import com.arellomobile.mvp.InjectViewState
import online.jutter.supersld.common.base.BasePresenter

@InjectViewState
class MapPresenter: BasePresenter<MapView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun back() = router?.exit()
}