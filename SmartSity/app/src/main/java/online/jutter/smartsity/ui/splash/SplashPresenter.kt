package online.jutter.smartsity.ui.splash

import com.arellomobile.mvp.MvpView
import kotlinx.coroutines.delay
import online.jutter.smartsity.Screens
import online.jutter.smartsity.ui.ext.createEmptyHandler
import online.jutter.supersld.common.base.BasePresenter
import online.jutter.supersld.extensions.launchIO
import online.jutter.supersld.extensions.withUI

class SplashPresenter : BasePresenter<MvpView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        start()
    }

    private fun start() {
        launchIO(createEmptyHandler()) {
            delay(2000)
            withUI {
                router?.newRootScreen(Screens.FlowMain)
            }
        }
    }

    fun back() {
        router?.exit()
    }
}