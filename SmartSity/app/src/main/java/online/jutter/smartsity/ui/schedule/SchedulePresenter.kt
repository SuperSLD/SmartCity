package online.jutter.smartsity.ui.schedule

import com.arellomobile.mvp.InjectViewState
import online.jutter.smartsity.Screens
import online.jutter.smartsity.common.base.BaseView
import online.jutter.smartsity.domain.controllers.BottomVisibilityController
import online.jutter.smartsity.domain.models.schedule.ScheduleLocal
import online.jutter.smartsity.domain.usecases.GetScheduleListUseCase
import online.jutter.supersld.common.base.BasePresenter
import online.jutter.supersld.extensions.launchIO
import online.jutter.supersld.extensions.launchUI
import online.jutter.supersld.extensions.withUI
import org.koin.core.inject

@InjectViewState
class SchedulePresenter: BasePresenter<ScheduleView>() {

    private val getScheduleListUseCase: GetScheduleListUseCase by inject()
    private val bottomVisibilityController: BottomVisibilityController by inject()

    override fun attachView(view: ScheduleView?) {
        super.attachView(view)
        bottomVisibilityController.show()
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadSchedule()
    }

    fun onCompetitionClick(item: ScheduleLocal) {
        router?.navigateTo(Screens.CompetitionDetail(item))
    }

    fun loadSchedule() {
        launchUI {
            viewState.toggleLoading(true)
            val data = withUI { getScheduleListUseCase() }
            viewState.toggleLoading(false)
            viewState.showSchedule(data)
        }
    }

}
