package online.jutter.smartsity.ui.auth.profile_filling

import com.arellomobile.mvp.InjectViewState
import online.jutter.smartsity.Screens
import online.jutter.smartsity.domain.usecases.RegistrationUseCase
import online.jutter.supersld.common.base.BasePresenter
import online.jutter.supersld.extensions.launchUI
import online.jutter.supersld.extensions.withIO
import org.koin.core.inject

@InjectViewState
class ProfileFillingPresenter : BasePresenter<ProfileFillingView>() {

    private val registrationUseCase: RegistrationUseCase by inject()

    fun send(name: String, lastName: String, city: String) {
        launchUI {
            withIO { registrationUseCase.invoke(name, lastName, city) }
            router?.newRootScreen(Screens.FlowMain)
        }
    }

}
