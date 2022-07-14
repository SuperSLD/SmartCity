package online.jutter.smartsity.ui.schedule

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import online.jutter.smartsity.domain.models.schedule.ScheduleDateLocal

interface ScheduleView: MvpView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showSchedule(data: List<ScheduleDateLocal>)

}
