package online.jutter.smartsity.ui.splash

import com.arellomobile.mvp.MvpView
import kotlinx.coroutines.delay
import online.jutter.smartsity.Screens
import online.jutter.smartsity.domain.usecases.IsAuthUseCase
import online.jutter.smartsity.ui.ext.createEmptyHandler
import online.jutter.supersld.common.base.BasePresenter
import online.jutter.supersld.extensions.launchIO
import online.jutter.supersld.extensions.withUI
import org.koin.core.inject

class SplashPresenter : BasePresenter<MvpView>() {

    private val isAuthUseCase: IsAuthUseCase by inject()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        start()
    }

    private fun start() {
        launchIO(createEmptyHandler()) {
            delay(2000)
            withUI {
                if (isAuthUseCase()) {
                    router?.newRootScreen(Screens.FlowMain)
                } else {
                    router?.newRootScreen(Screens.Login)
                }
            }
        }
    }

    fun back() {
        router?.exit()
    }
}