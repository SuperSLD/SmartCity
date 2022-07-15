package online.jutter.smartsity.ui.leaderboard

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_leadeboard.*
import kotlinx.android.synthetic.main.view_loading.*
import online.jutter.smartsity.R
import online.jutter.smartsity.data.net.models.LeaderboardResponse
import online.jutter.supersld.common.base.BaseFragment
import online.jutter.supersld.extensions.addSystemTopPadding

class LeaderboardFragment: BaseFragment(R.layout.fragment_leadeboard), LeaderboardView {

    @InjectPresenter
    lateinit var presenter: LeaderboardPresenter

    private val adapter by lazy { LeaderBoardAdapter(presenter::leaderboardInfo) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUi()
    }

    private fun initUi() {
        tvTitle.addSystemTopPadding()

        with(rvLeaderBoard) {
            adapter = this@LeaderboardFragment.adapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }

    override fun onBackPressed() {

    }

    override fun showLeaderBoard(data: List<LeaderboardResponse>) {
        adapter.addAll(data)
    }

    override fun showErrorLoading() {

    }

    override fun toggleLoading(show: Boolean) {
        loading.visibility = if (show) View.VISIBLE else View.GONE
        rvLeaderBoard.visibility = if (show) View.GONE else View.VISIBLE    }
}