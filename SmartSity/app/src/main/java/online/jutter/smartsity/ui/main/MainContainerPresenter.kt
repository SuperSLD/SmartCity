package online.jutter.smartsity.ui.main

import com.arellomobile.mvp.InjectViewState
import online.jutter.smartsity.domain.controllers.BottomVisibilityController
import online.jutter.smartsity.domain.controllers.ChangeBottomTabController
import online.jutter.supersld.common.base.BasePresenter
import online.jutter.supersld.extensions.launchIO
import online.jutter.supersld.extensions.withUI
import org.koin.core.inject

@InjectViewState
class MainContainerPresenter: BasePresenter<MainContainerView>() {

    private val changeBottomTabController: ChangeBottomTabController by inject()
    private val bottomVisibilityController: BottomVisibilityController by inject()


    override fun attachView(view: MainContainerView?) {
        super.attachView(view)
        bottomVisibilityController.show()
        viewState.initBottomNavigation()
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        listenChangeBottomTab()
        listenBottomNavigationVisibility()
    }

    private fun listenChangeBottomTab() {
        changeBottomTabController.state
            .listen {
                viewState.changeBottomTab(it)
            }.connect()
    }

    private fun listenBottomNavigationVisibility() {
        bottomVisibilityController.state
            .listen {
                viewState.changeBottomNavigationVisibility(it)
            }.connect()
    }


}