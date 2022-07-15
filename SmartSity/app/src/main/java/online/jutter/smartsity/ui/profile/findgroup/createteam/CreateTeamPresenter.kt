package online.jutter.smartsity.ui.profile.findgroup.createteam

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpView
import online.jutter.roadmapview.data.models.map.RMRoom
import online.jutter.smartsity.Screens
import online.jutter.smartsity.domain.controllers.BottomVisibilityController
import online.jutter.smartsity.domain.controllers.SelectRoomController
import online.jutter.smartsity.domain.models.TeamLocal
import online.jutter.smartsity.domain.usecases.CreateTeamUseCase
import online.jutter.smartsity.domain.usecases.GetTeamsUseCase
import online.jutter.supersld.common.base.BasePresenter
import online.jutter.supersld.extensions.launchUI
import online.jutter.supersld.extensions.withIO
import org.koin.core.inject

@InjectViewState
class CreateTeamPresenter : BasePresenter<CreateTeamView>() {

    private val createTeamsUseCase: CreateTeamUseCase by inject()
    private val bottomVisibilityController: BottomVisibilityController by inject()

    override fun attachView(view: CreateTeamView?) {
        super.attachView(view)
        bottomVisibilityController.hide()
    }

    fun createTeam(name: String, code: String) {
        launchUI {
            viewState.toggleLoading(true)
            withIO { createTeamsUseCase(name, code) }
            viewState.toggleLoading(false)
            router?.exit()
        }
    }


    fun back() {
        router?.replaceScreen(Screens.FindGroup)
    }
}