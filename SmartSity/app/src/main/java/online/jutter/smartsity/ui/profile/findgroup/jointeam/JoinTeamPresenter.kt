package online.jutter.smartsity.ui.profile.findgroup.jointeam

import com.arellomobile.mvp.InjectViewState
import online.jutter.smartsity.Screens
import online.jutter.smartsity.domain.controllers.BottomVisibilityController
import online.jutter.smartsity.domain.models.TeamLocal
import online.jutter.smartsity.domain.usecases.JoinTeamUseCase
import online.jutter.smartsity.ui.profile.findgroup.createteam.CreateTeamView
import online.jutter.supersld.common.base.BasePresenter
import online.jutter.supersld.extensions.launchUI
import online.jutter.supersld.extensions.withIO
import org.koin.core.inject

@InjectViewState
class JoinTeamPresenter(private val team: TeamLocal?) : BasePresenter<JoinTeamView>() {

    private val bottomVisibilityController: BottomVisibilityController by inject()
    private val joinTeamUseCase: JoinTeamUseCase by inject()

    override fun attachView(view: JoinTeamView?) {
        super.attachView(view)
        bottomVisibilityController.hide()
        loadTeam()
    }

    private fun loadTeam() {
        team?.let {
            viewState.showTeam(it)
        }
    }

    fun joinTeam(code: String) {
        team?.let {
            launchUI {
                withIO { joinTeamUseCase(team.id, code) }
                router?.newRootScreen(Screens.FlowProfile)
            }
        }
    }

    fun back() {
        router?.replaceScreen(Screens.FindGroup)
    }

}
