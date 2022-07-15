package online.jutter.smartsity.ui.leaderboard

import com.arellomobile.mvp.InjectViewState
import online.jutter.smartsity.domain.usecases.GetLeaderBoardUserCase
import online.jutter.supersld.common.base.BasePresenter
import online.jutter.supersld.extensions.launchIO
import online.jutter.supersld.extensions.withUI
import org.koin.core.inject

@InjectViewState
class LeaderboardPresenter: BasePresenter<LeaderboardView>() {

    private val getScheduleListUseCase: GetLeaderBoardUserCase by inject()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadSchedule()
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