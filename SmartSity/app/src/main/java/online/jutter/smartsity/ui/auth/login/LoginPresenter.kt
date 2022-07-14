package online.jutter.smartsity.ui.auth.login

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpView
import online.jutter.smartsity.Screens
import online.jutter.supersld.common.base.BasePresenter

@InjectViewState
class LoginPresenter : BasePresenter<MvpView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun onLogin(number: String) {
        router?.navigateTo(Screens.Pin(number))
    }

    fun back() {
        router?.exit()
    }
}