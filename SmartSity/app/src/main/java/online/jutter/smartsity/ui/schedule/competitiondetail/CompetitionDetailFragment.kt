package online.jutter.smartsity.ui.schedule.competitiondetail

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_competition_detail.*
import online.jutter.smartsity.R
import online.jutter.smartsity.common.extesions.hide
import online.jutter.smartsity.common.extesions.show
import online.jutter.smartsity.domain.models.schedule.ScheduleLocal
import online.jutter.supersld.common.base.BaseFragment

class CompetitionDetailFragment: BaseFragment(R.layout.fragment_competition_detail), CompetitionDetailView {

    companion object {
        var competition: ScheduleLocal? = null

        fun createInstance(
            c: ScheduleLocal
        ) = CompetitionDetailFragment().apply {
            competition = c
        }
    }

    @InjectPresenter
    lateinit var presenter: CompetitionDetailPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(vToolbar) {
            setTitle(competition?.sport?.name?:"---")
            onBack(this@CompetitionDetailFragment::onBackPressed, null)
        }

        tvDescription.text = competition?.sport?.description?:"---"

        tvPlace.text = competition?.place?.name?:"---"
        tvCompetition.text = competition?.sport?.name?:"---"

        btnJoin.setOnClickListener {
            presenter.onJoin(competition?.id?.toInt()!!)
        }
    }

    override fun showErrorLoading() {}

    override fun onBackPressed() {
        presenter.back()
    }

    override fun toggleLoading(show: Boolean) {
        if (show) {
            btnJoin.hide()
            pbLoading.show()
        } else {
            pbLoading.hide()
            btnJoin.show()
        }
    }
}
