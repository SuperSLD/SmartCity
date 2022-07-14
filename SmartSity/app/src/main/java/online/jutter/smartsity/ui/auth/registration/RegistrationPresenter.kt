package online.jutter.smartsity.ui.auth.registration

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpView
import kotlinx.coroutines.delay
import online.jutter.smartsity.Screens
import online.jutter.smartsity.ui.ext.createEmptyHandler
import online.jutter.supersld.common.base.BasePresenter
import online.jutter.supersld.extensions.launchIO
import online.jutter.supersld.extensions.withUI

@InjectViewState
class RegistrationPresenter : BasePresenter<MvpView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun back() {
        router?.exit()
    }
}