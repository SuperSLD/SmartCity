package online.jutter.smartsity.ui.profile.findgroup

import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import online.jutter.smartsity.common.base.BaseView
import online.jutter.smartsity.domain.models.TeamLocal

interface FindGroupView: BaseView {

    @StateStrategyType(SkipStrategy::class)
    fun addList(list: List<TeamLocal>)
}
