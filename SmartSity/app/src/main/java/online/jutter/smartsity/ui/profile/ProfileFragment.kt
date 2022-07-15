package online.jutter.smartsity.ui.profile

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.arellomobile.mvp.presenter.InjectPresenter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import online.jutter.smartsity.R
import online.jutter.smartsity.databinding.FragmentProfileBinding
import online.jutter.smartsity.domain.models.ProfileLocal
import online.jutter.smartsity.ui.ext.SpaceBetweenItemDecoration
import online.jutter.smartsity.ui.ext.dpToPx
import online.jutter.supersld.common.base.BaseFragment
import online.jutter.supersld.extensions.addSystemTopPadding
import org.koin.android.ext.android.bind

class ProfileFragment: BaseFragment(R.layout.fragment_profile), ProfileView{

    private val binding: FragmentProfileBinding by viewBinding()

    private val teamAdapter by lazy { TeamAdapter() }
    private val resultsAdapter by lazy { ResultsAdapter() }

    @InjectPresenter
    lateinit var presenter: ProfilePresenter

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

    override fun showProfileData(data: ProfileLocal) {
        with (binding) {
            tvName.text = data.user.firstname + " " + data.user.lastname
            tvCity.text = data.user.city
            tvTeamName.text = data.team.name

            Glide
                .with(requireContext())
                .load(data.user.avatar)
                .apply(RequestOptions.circleCropTransform())
                .into(ivAvatar)
        }

        teamAdapter.addAll(data.team.participants, data.team.captainId)
        resultsAdapter.addAll(
            data.goldMedalsCount,
            data.silverMedalsCount,
            data.bronzeMedalsCount,
            data.otherMedalsCount
        )
    }

    override fun onBackPressed() {

    }

    override fun showErrorLoading() { }

    override fun toggleLoading(show: Boolean) {

    }
}
