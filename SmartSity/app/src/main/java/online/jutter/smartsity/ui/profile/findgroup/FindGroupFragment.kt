package online.jutter.smartsity.ui.profile.findgroup

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_competition_detail.vToolbar
import kotlinx.android.synthetic.main.fragment_findgroup.*
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.view_pony_input.view.*
import online.jutter.smartsity.R
import online.jutter.smartsity.databinding.FragmentFindgroupBinding
import online.jutter.smartsity.domain.models.TeamLocal
import online.jutter.smartsity.ui.view.PonyInputView
import online.jutter.supersld.common.base.BaseFragment
import online.jutter.supersld.extensions.addSystemTopAndBottomPadding

class FindGroupFragment : BaseFragment(R.layout.fragment_findgroup), FindGroupView {

    private val binding: FragmentFindgroupBinding by viewBinding()

    private val adapter by lazy { GroupsAdapter(presenter::onTeamClick) }

    @InjectPresenter
    lateinit var presenter: FindGroupPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(vToolbar) {
            setTitle("Поиск команды")
            onBack(this@FindGroupFragment::onBackPressed, null)
        }

        with(inTeam) {
            setHint("Название группы")
            addEndAction(PonyInputView.Action(
                textId = R.string.search,
                action = {
                    adapter.setFilter(it)
                }
            ))
            enable()
        }

        binding.listContainer.addSystemTopAndBottomPadding()
        binding.rvRooms.addSystemTopAndBottomPadding()
        binding.btnCreate.setOnClickListener { presenter.onCreateTeam() }

        initRecycler()
    }

    private fun initRecycler() {
        with(binding.rvRooms) {
            adapter = this@FindGroupFragment.adapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onBackPressed() {
        presenter.back()
    }

    override fun addList(list: List<TeamLocal>) {
        adapter.addData(list)
    }

    override fun showErrorLoading() {}

    override fun toggleLoading(show: Boolean) {}
}