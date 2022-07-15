package online.jutter.smartsity.ui.leaderboard

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import online.jutter.smartsity.data.net.models.LeaderboardResponse

interface LeaderboardView: MvpView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showLeaderBoard(data: List<LeaderboardResponse>)
}