package online.jutter.smartsity.ui.map.navigation

import android.graphics.Color
import com.arellomobile.mvp.InjectViewState
import online.jutter.roadmapview.data.models.map.RMMarker
import online.jutter.smartsity.Screens
import online.jutter.smartsity.domain.controllers.NavigationController
import online.jutter.smartsity.domain.controllers.SelectMarkerController
import online.jutter.smartsity.domain.controllers.SelectRoomController
import online.jutter.supersld.common.base.BasePresenter
import org.koin.core.inject

@InjectViewState
class NavigationPresenter : BasePresenter<NavigationView>() {

    private val selectMarkerController: SelectMarkerController by inject()
    private val selectRoomController: SelectRoomController by inject()
    private val navigationController: NavigationController by inject()
    private var isStartMarker = false

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        listenMarker()
        listenRoom()
    }

    fun onSelectStart() {
        isStartMarker = true
        router?.navigateTo(Screens.SelectRoom)
    }

    fun onSelectEnd() {
        isStartMarker = false
        router?.navigateTo(Screens.SelectRoom)
    }

    fun onDone(start: RMMarker, end: RMMarker) {
        navigationController.setMarkers(start, end)
        back()
    }

    private fun listenMarker() {
        selectMarkerController.state
            .listen {

            }.connect()
    }

    private fun listenRoom() {
        selectRoomController.state.listen {
            if (isStartMarker) {
                viewState.addStartMarker(
                    RMMarker(
                        id = "end",
                        symbol = "A",
                        x = it.position.x.toFloat(),
                        y = it.position.y.toFloat(),
                        floor = it.position.floor,
                        color = Color.parseColor("#F2514B"),
                        textColor = Color.parseColor("#FFFFFF")
                    )
                )
            } else {
                viewState.addEndMarker(
                    RMMarker(
                        id = "end",
                        symbol = "Б",
                        x = it.position.x.toFloat(),
                        y = it.position.y.toFloat(),
                        floor = it.position.floor,
                        color = Color.parseColor("#2F83CF"),
                        textColor = Color.parseColor("#FFFFFF")
                    )
                )
            }
        }
    }

    fun back() {
        router?.exit()
    }
}