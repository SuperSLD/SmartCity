package online.jutter.smartsity.ui.schedule

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import online.jutter.smartsity.common.base.BaseView
import online.jutter.smartsity.domain.models.schedule.ScheduleDateLocal

interface ScheduleView: BaseView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showSchedule(data: List<ScheduleDateLocal>)

}
