package online.jutter.smartsity.ui.auth.pincode

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpView
import online.jutter.smartsity.Screens
import online.jutter.smartsity.domain.usecases.CheckUserRegisteredUseCase
import online.jutter.smartsity.domain.usecases.SavePhoneUseCase
import online.jutter.supersld.common.base.BasePresenter
import online.jutter.supersld.extensions.launchUI
import org.koin.core.inject

@InjectViewState
class PinPresenter : BasePresenter<MvpView>() {

    private val savePhoneUseCase: SavePhoneUseCase by inject()
    private val checkUserRegisteredUseCase: CheckUserRegisteredUseCase by inject()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun next(phone: String) {
        savePhoneUseCase(phone)
        launchUI {
            val isRegistered = checkUserRegisteredUseCase()
            if (isRegistered) {
                router?.newRootScreen(Screens.FlowMain)
            } else {
                router?.newRootScreen(Screens.Registration)
            }
        }
    }

    fun back() {
        router?.exit()
    }
}
