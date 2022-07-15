package online.jutter.smartsity.ui.news

import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import online.jutter.smartsity.common.base.BaseView
import online.jutter.smartsity.domain.controllers.models.Event
import online.jutter.smartsity.domain.models.NewsLocal

interface NewsView: BaseView {
    @StateStrategyType(SkipStrategy::class)
    fun addList(list: List<NewsLocal>)
}
