package online.jutter.smartsity.ui.leaderboard.info

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_competition_detail.vToolbar
import kotlinx.android.synthetic.main.fragment_leadeboard.*
import kotlinx.android.synthetic.main.fragment_leadeboard_info.*
import kotlinx.android.synthetic.main.item_leaderboard_holder.view.*
import online.jutter.smartsity.R
import online.jutter.smartsity.data.net.models.LeaderboardResponse
import online.jutter.smartsity.data.net.models.MemberResponse
import online.jutter.smartsity.ui.leaderboard.LeaderBoardAdapter
import online.jutter.supersld.common.base.BaseFragment

class LeaderboardInfoFragment: BaseFragment(R.layout.fragment_leadeboard_info), LeaderboardInfoView {
    @InjectPresenter
    lateinit var presenter: LeaderboardInfoPresenter

    private val adapter by lazy { LeaderBoardInfoAdapter() }
    private var memberList: MutableList<MemberResponse> = mutableListOf()

    override fun onBackPressed() {
        presenter.back()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
    }

    private fun initUI() {
        with(vToolbar) {
            setTitle(R.string.leaderboard_info_title)
            onBack(this@LeaderboardInfoFragment::onBackPressed, null)
        }
        if (leaderboard?.list?.size!! > 2) {
            memberList.addAll(leaderboard?.list!!)
            memberList.retainAll{ it.rank > 3 }
        }

        adapter.addAll(memberList)
        with(rvMembers) {
            adapter = this@LeaderboardInfoFragment.adapter
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }

        vTopMembers.tvOtherPlayers.visibility = View.GONE

        vTopMembers.tvCompetitionName.text = leaderboard?.competition?.sport?.name?:"---"
        vTopMembers.tvPlace.text = leaderboard?.competition?.place?.name?:"---"
        vTopMembers.tvFirstPlaceName.text = leaderboard?.list?.get(0)?.name?:"---"
        if (leaderboard?.list?.find { it.rank == 2 } == null) {
            vTopMembers.secondPlaceLayout.visibility = View.GONE
        } else vTopMembers.tvSecondPlaceName.text = leaderboard?.list?.get(1)?.name?:"---"

        if (leaderboard?.list?.find { it.rank == 3 } == null) {
            vTopMembers.thirdPlaceLayout.visibility = View.GONE
        } else vTopMembers.tvThirdPlaceName.text = leaderboard?.list?.get(2)?.name?:"---"

    }

    companion object {
        var leaderboard: LeaderboardResponse? = null

        fun createInstance(
            c: LeaderboardResponse
        ) = LeaderboardInfoFragment().apply {
            leaderboard = c
        }
    }
}