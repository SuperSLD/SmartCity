package online.jutter.smartsity.ui.map.selectroom

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import online.jutter.roadmapview.RMDataController
import online.jutter.smartsity.R
import online.jutter.smartsity.databinding.FragmentSelectroomBinding
import online.jutter.supersld.common.base.BaseFragment
import online.jutter.supersld.extensions.addSystemTopAndBottomPadding

class SelectRoomFragment : BaseFragment(R.layout.fragment_selectroom), MvpView {

    private val binding: FragmentSelectroomBinding by viewBinding()

    private val adapter by lazy { RoomsAdapter(presenter::onRoomClick) }

    @InjectPresenter
    lateinit var presenter: SelectRoomPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listContainer.addSystemTopAndBottomPadding()
        binding.rvRooms.addSystemTopAndBottomPadding()
        binding.btnBack.setOnClickListener { onBackPressed() }

        initRoomsRecycler()
    }

    private fun initRoomsRecycler() {
        with(binding.rvRooms) {
            adapter = this@SelectRoomFragment.adapter
            layoutManager = LinearLayoutManager(context)
        }
        adapter.addData(RMDataController.create("")!!.getMapFromCache()!!.getRooms())
    }

    override fun onBackPressed() {
        presenter.back()
    }
}