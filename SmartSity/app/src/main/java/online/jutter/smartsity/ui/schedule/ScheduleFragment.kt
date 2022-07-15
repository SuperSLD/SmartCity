package online.jutter.smartsity.ui.schedule

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_schedule.*
import kotlinx.android.synthetic.main.view_loading.*
import online.jutter.smartsity.R
import online.jutter.smartsity.databinding.FragmentScheduleBinding
import online.jutter.smartsity.domain.models.schedule.ScheduleDateLocal
import online.jutter.smartsity.ui.ext.SpaceBetweenItemDecoration
import online.jutter.smartsity.ui.ext.dpToPx
import online.jutter.smartsity.ui.schedule.adapters.ScheduleDateAdapter
import online.jutter.supersld.common.base.BaseFragment
import online.jutter.supersld.extensions.addSystemTopPadding

class ScheduleFragment: BaseFragment(R.layout.fragment_schedule), ScheduleView {

    @InjectPresenter
    lateinit var presenter: SchedulePresenter

    private val binding: FragmentScheduleBinding by viewBinding()

    private val adapter by lazy { ScheduleDateAdapter(presenter::onCompetitionClick) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUi()
        initListeners()
    }

    private fun initUi() {
        with(binding) {
            root.addSystemTopPadding()
            rvSchedule.run {
                adapter = this@ScheduleFragment.adapter
                layoutManager = LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.VERTICAL,
                    false
                )
                addItemDecoration(SpaceBetweenItemDecoration(26.dpToPx))
            }
        }
    }

    private fun initListeners() {
        with(binding) {
            srl.setOnRefreshListener {
                presenter.loadSchedule()
            }
        }
    }

    override fun showSchedule(data: List<ScheduleDateLocal>) {
        adapter.addAll(data)
    }

    override fun showErrorLoading() {}

    override fun onBackPressed() {}

    override fun toggleLoading(show: Boolean) {
        binding.srl.isRefreshing = show
        loading.visibility = if (show) View.VISIBLE else View.GONE
        rvSchedule.visibility = if (show) View.GONE else View.VISIBLE
    }
}
