package online.jutter.smartsity.ui.schedule.competitiondetail

import com.arellomobile.mvp.InjectViewState
import online.jutter.smartsity.common.base.BaseView
import online.jutter.smartsity.domain.usecases.GetScheduleListUseCase
import online.jutter.supersld.common.base.BasePresenter
import online.jutter.supersld.extensions.launchIO
import online.jutter.supersld.extensions.withUI
import org.koin.core.inject

@InjectViewState
class CompetitionDetailPresenter: BasePresenter<CompetitionDetailView>()
