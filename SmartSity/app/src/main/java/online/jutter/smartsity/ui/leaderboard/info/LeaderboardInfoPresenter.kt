package online.jutter.smartsity.ui.leaderboard.info

import android.content.Context
import online.jutter.smartsity.domain.controllers.BottomVisibilityController
import online.jutter.supersld.common.base.BasePresenter
import org.koin.core.inject

class LeaderboardInfoPresenter: BasePresenter<LeaderboardInfoView>() {

    private val bottomVisibilityController: BottomVisibilityController by inject()
    private val context: Context by inject()

    fun back() = router?.exit()

    override fun attachView(view: LeaderboardInfoView?) {
        super.attachView(view)
        bottomVisibilityController.hide()
    }
}