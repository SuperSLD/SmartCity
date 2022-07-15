package online.jutter.smartsity.ui.leaderboard

import com.arellomobile.mvp.InjectViewState
import online.jutter.smartsity.Screens
import online.jutter.smartsity.data.net.models.CompetitionResponse
import online.jutter.smartsity.data.net.models.LeaderboardResponse
import online.jutter.smartsity.data.net.models.MemberResponse
import online.jutter.smartsity.domain.controllers.BottomVisibilityController
import online.jutter.smartsity.domain.usecases.GetLeaderBoardUserCase
import online.jutter.smartsity.ui.leaderboard.info.LeaderboardInfoView
import online.jutter.supersld.common.base.BasePresenter
import online.jutter.supersld.extensions.launchIO
import online.jutter.supersld.extensions.withUI
import org.koin.core.inject

@InjectViewState
class LeaderboardPresenter: BasePresenter<LeaderboardView>() {

    private val getScheduleListUseCase: GetLeaderBoardUserCase by inject()
    private val bottomVisibilityController: BottomVisibilityController by inject()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadSchedule()
    }

    fun leaderboardInfo(leaderboard: LeaderboardResponse) {
        router?.navigateTo(Screens.LeaderboardInfo(leaderboard))
    }

    override fun attachView(view: LeaderboardView?) {
        super.attachView(view)
        bottomVisibilityController.show()
    }

    fun loadSchedule() {
        launchIO {
            val data = getScheduleListUseCase()
            withUI {
                viewState.showLeaderBoard(data)
            }
        }
    }

}