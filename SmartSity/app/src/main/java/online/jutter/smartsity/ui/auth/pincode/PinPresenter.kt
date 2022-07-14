package online.jutter.smartsity.ui.auth.pincode

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpView
import online.jutter.smartsity.Screens
import online.jutter.smartsity.domain.usecases.SavePhoneUseCase
import online.jutter.supersld.common.base.BasePresenter
import org.koin.core.inject

@InjectViewState
class PinPresenter : BasePresenter<MvpView>() {

    private val savePhoneUseCase: SavePhoneUseCase by inject()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun openMain(phone: String) {
        savePhoneUseCase(phone)
        router?.newRootScreen(Screens.FlowMain)
    }

    fun back() {
        router?.exit()
    }
}