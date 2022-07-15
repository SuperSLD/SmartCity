package online.jutter.smartsity.ui.profile.findgroup.createteam

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_competition_detail.vToolbar
import kotlinx.android.synthetic.main.fragment_createteam.*
import kotlinx.android.synthetic.main.fragment_findgroup.inTeam
import kotlinx.android.synthetic.main.view_pony_input.view.*
import online.jutter.smartsity.R
import online.jutter.smartsity.databinding.FragmentCreateteamBinding
import online.jutter.supersld.common.base.BaseFragment

class CreateTeamFragment : BaseFragment(R.layout.fragment_createteam), CreateTeamView {

    private val binding: FragmentCreateteamBinding by viewBinding()

    @InjectPresenter
    lateinit var presenter: CreateTeamPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(vToolbar) {
            setTitle("Создание команды")
            onBack(this@CreateTeamFragment::onBackPressed, null)
        }

        with(inTeam) {
            setHint("Название группы")
        }

        with(inCode) {
            setHint("Секретный код")
            setDigits("0123456789")
        }

        binding.btnCreate.setOnClickListener {
            if (inTeam.etInput.text!!.isNotEmpty() && inCode.etInput.text!!.isNotEmpty()) {
                presenter.createTeam(inTeam.etInput.text!!.toString(), inCode.etInput.text!!.toString())
            }
        }
    }

    override fun onBackPressed() {
        presenter.back()
    }

    override fun showErrorLoading() {}

    override fun toggleLoading(show: Boolean) {}
}