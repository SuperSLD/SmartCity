package online.jutter.smartsity.ui.schedule.competitiondetail

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.arellomobile.mvp.presenter.InjectPresenter
import online.jutter.smartsity.R
import online.jutter.smartsity.data.net.models.CompetitionResponse
import online.jutter.smartsity.databinding.FragmentScheduleBinding
import online.jutter.smartsity.domain.models.schedule.ScheduleDateLocal
import online.jutter.smartsity.ui.ext.SpaceBetweenItemDecoration
import online.jutter.smartsity.ui.ext.dpToPx
import online.jutter.smartsity.ui.schedule.adapters.ScheduleDateAdapter
import online.jutter.supersld.common.base.BaseFragment
import online.jutter.supersld.extensions.addSystemTopPadding
import org.koin.android.ext.android.bind

class CompetitionDetailFragment: BaseFragment(R.layout.fragment_competition_detail), CompetitionDetailView {

    companion object {
        var competition: CompetitionResponse? = null

        fun createInstance() = CompetitionDetailFragment().apply {
            arguments = Bundle()

        }
    }

    @InjectPresenter
    lateinit var presenter: CompetitionDetailPresenter

    private val binding: FragmentScheduleBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun showErrorLoading() {}

    override fun onBackPressed() {}

    override fun toggleLoading(show: Boolean) {
        binding.srl.isRefreshing = show
    }
}
