package online.jutter.smartsity.ui.auth.pincode

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpView
import online.jutter.smartsity.Screens
import online.jutter.supersld.common.base.BasePresenter

@InjectViewState
class PinPresenter : BasePresenter<MvpView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun openMain() {
        router?.newRootScreen(Screens.FlowMain)
    }

    fun back() {
        router?.exit()
    }
}