package online.jutter.smartsity.ui.schedule

import com.arellomobile.mvp.InjectViewState
import online.jutter.smartsity.common.base.BaseView
import online.jutter.smartsity.domain.usecases.GetScheduleListUseCase
import online.jutter.supersld.common.base.BasePresenter
import online.jutter.supersld.extensions.launchIO
import online.jutter.supersld.extensions.withUI
import org.koin.core.inject

@InjectViewState
class SchedulePresenter: BasePresenter<ScheduleView>() {

    private val getScheduleListUseCase: GetScheduleListUseCase by inject()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadSchedule()
    }

    fun loadSchedule() {
        launchIO {
            viewState.toggleLoading(true)
            val data = getScheduleListUseCase()
            withUI {
                viewState.toggleLoading(false)
                viewState.showSchedule(data)
            }
        }
    }

}
