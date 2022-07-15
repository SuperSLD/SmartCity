package online.jutter.smartsity.ui.leaderboard.info

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import online.jutter.smartsity.R
import online.jutter.smartsity.data.net.models.MemberResponse
import online.jutter.supersld.common.base.BaseFragment

class LeaderboardInfoFragment: BaseFragment(R.layout.fragment_leadeboard_info), LeaderboardInfoView {
    @InjectPresenter
    lateinit var presenter: LeaderboardInfoPresenter
    private var memberList: MutableList<MemberResponse> = mutableListOf()

    override fun onResume() {
        super.onResume()
        memberList = arguments?.getParcelableArray(ARG_LIST) as MutableList<MemberResponse>
    }
    override fun onBackPressed() {
        presenter.back()
    }

    companion object {
        private const val ARG_LIST = "arg_list"

        fun create(members: MutableList<MemberResponse>): LeaderboardInfoFragment {
            val fragment = LeaderboardInfoFragment()

            val args = Bundle()
            args.putParcelableArray(ARG_LIST, members.toTypedArray())
            fragment.arguments = args

            return fragment
        }
    }
}