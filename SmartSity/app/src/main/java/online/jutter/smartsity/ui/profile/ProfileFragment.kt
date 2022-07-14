package online.jutter.smartsity.ui.profile

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import online.jutter.smartsity.R
import online.jutter.smartsity.databinding.FragmentProfileBinding
import online.jutter.smartsity.ui.ext.SpaceBetweenItemDecoration
import online.jutter.smartsity.ui.ext.dpToPx
import online.jutter.supersld.common.base.BaseFragment
import online.jutter.supersld.extensions.addSystemTopPadding
import org.koin.android.ext.android.bind

class ProfileFragment: BaseFragment(R.layout.fragment_profile){

    private val binding: FragmentProfileBinding by viewBinding()

    private val teamAdapter by lazy { TeamAdapter() }
    private val resultsAdapter by lazy { ResultsAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUi()
    }

    private fun initUi() {
        with(binding) {
            vgContent.addSystemTopPadding()

            rvTeam.run {
                adapter = teamAdapter
                layoutManager = LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.VERTICAL,
                    false
                )
                addItemDecoration(SpaceBetweenItemDecoration(6.dpToPx))
            }
            rvResults.run {
                adapter = resultsAdapter
                layoutManager = LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.VERTICAL,
                    false
                )
                addItemDecoration(SpaceBetweenItemDecoration(5.dpToPx))
            }
        }
    }

    override fun onBackPressed() {

    }
}
