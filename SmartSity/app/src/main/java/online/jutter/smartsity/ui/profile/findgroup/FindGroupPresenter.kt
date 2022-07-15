package online.jutter.smartsity.ui.profile.findgroup

import com.arellomobile.mvp.InjectViewState
import online.jutter.smartsity.Screens
import online.jutter.smartsity.domain.controllers.BottomVisibilityController
import online.jutter.smartsity.domain.models.TeamLocal
import online.jutter.smartsity.domain.usecases.GetTeamsUseCase
import online.jutter.supersld.common.base.BasePresenter
import online.jutter.supersld.extensions.launchUI
import online.jutter.supersld.extensions.withIO
import org.koin.core.inject

@InjectViewState
class FindGroupPresenter : BasePresenter<FindGroupView>() {

    private val getTeamsUseCase: GetTeamsUseCase by inject()
    private val bottomVisibilityController: BottomVisibilityController by inject()

    override fun attachView(view: FindGroupView?) {
        super.attachView(view)
        bottomVisibilityController.hide()
        loadList()
    }

    fun onTeamClick(team: TeamLocal) {
        router?.navigateTo(Screens.JoinTeam(team))
    }

    fun onCreateTeam() {
        router?.replaceScreen(Screens.CreateTeam)
    }

    fun loadList() {
        launchUI {
            viewState.toggleLoading(true)
            val data = withIO { getTeamsUseCase() }
            viewState.toggleLoading(false)
            viewState.addList(data)
        }
    }


    fun back() {
        router?.exit()
    }
}
