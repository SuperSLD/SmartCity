package online.jutter.smartsity.ui.schedule.competitiondetail

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import com.arellomobile.mvp.InjectViewState
import online.jutter.smartsity.domain.usecases.JoinToCompetitionUseCase
import online.jutter.smartsity.ui.ext.createHandler
import online.jutter.supersld.common.base.BasePresenter
import online.jutter.supersld.extensions.launchUI
import online.jutter.supersld.extensions.withIO
import org.koin.core.inject

@InjectViewState
class CompetitionDetailPresenter: BasePresenter<CompetitionDetailView>() {

    private val joinToCompetitionUseCase: JoinToCompetitionUseCase by inject()
    private val context: Context by inject()

    @SuppressLint("ShowToast")
    fun onJoin(id: Int) {
        val handler = createHandler {
            Toast.makeText(context, it.message.toString(), Toast.LENGTH_SHORT)
            viewState.toggleLoading(false)
        }
        launchUI(handler) {
            viewState.toggleLoading(true)
            withIO { joinToCompetitionUseCase(id) }
            Toast.makeText(context, "Вы записались", Toast.LENGTH_SHORT)
            back()
        }
    }

    fun back() = router?.exit()
}
