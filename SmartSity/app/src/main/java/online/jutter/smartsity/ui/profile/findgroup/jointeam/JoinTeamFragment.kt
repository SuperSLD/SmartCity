package online.jutter.smartsity.ui.profile.findgroup.jointeam

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_createteam.*
import kotlinx.android.synthetic.main.view_pony_input.view.*
import okhttp3.internal.addHeaderLenient
import online.jutter.smartsity.R
import online.jutter.smartsity.databinding.FragmentJoinTeamBinding
import online.jutter.smartsity.domain.models.TeamLocal
import online.jutter.smartsity.ui.profile.TeamAdapter
import online.jutter.supersld.common.base.BaseFragment
import online.jutter.supersld.extensions.addSystemTopAndBottomPadding

class JoinTeamFragment : BaseFragment(R.layout.fragment_join_team), JoinTeamView {

    @InjectPresenter
    lateinit var presenter: JoinTeamPresenter

    @ProvidePresenter
    fun providePresenter() = JoinTeamPresenter(
        arguments?.getParcelable(ARG_TEAM)
    )

    private val binding: FragmentJoinTeamBinding by viewBinding()

    private val teamAdapter by lazy { TeamAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUi()
    }

    private fun initUi() {
        with(binding) {
            root.addSystemTopAndBottomPadding()

            vToolbar.setTitle("Присоединится к команде")
            vToolbar.onBack({onBackPressed()}, R.drawable.ic_arrow_left)

            with(inCode) {
                setHint("Секретный код")
                setDigits("0123456789")
            }

            inCode.etInput.addTextChangedListener {
                btnJoin.isEnabled = !it.isNullOrEmpty()
            }

            btnJoin.setOnClickListener {
                presenter.joinTeam(inCode.etInput.text.toString())
            }

            rvTeam.run {
                adapter = teamAdapter
                layoutManager = LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.VERTICAL,
                    false
                )
            }
        }
    }

    override fun showTeam(team: TeamLocal) {
        binding.tvTeamName.text = team.name
        teamAdapter.addAll(team.participants, team.captainId)
    }

    override fun onBackPressed() {
        presenter.back()
    }

    companion object {

        private const val ARG_TEAM = "arg_team"

        fun create(team: TeamLocal): JoinTeamFragment {

            val fragment = JoinTeamFragment()
            val args = Bundle()

            args.putParcelable(ARG_TEAM, team)

            fragment.arguments = args

            return fragment
        }

    }

}
