package online.jutter.smartsity.ui.profile

import com.arellomobile.mvp.InjectViewState
import online.jutter.smartsity.domain.usecases.GetProfileUseCase
import online.jutter.supersld.common.base.BasePresenter
import online.jutter.supersld.extensions.launchIO
import online.jutter.supersld.extensions.withUI
import org.koin.core.inject

@InjectViewState
class ProfilePresenter: BasePresenter<ProfileView>() {

    private val getProfileUseCase: GetProfileUseCase by inject()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadProfile()
    }

    private fun loadProfile() {
        launchIO {
            val data = getProfileUseCase()
            withUI {
                viewState.showProfileData(data)
            }
        }
    }

}
