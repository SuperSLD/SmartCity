package online.jutter.smartsity.ui.schedule.successjoin

import android.os.Bundle
import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_success.*
import online.jutter.smartsity.R
import online.jutter.supersld.common.base.BaseFragment

class SuccessFragment : BaseFragment(R.layout.fragment_success), MvpView {

    @InjectPresenter
    lateinit var presenter: SuccessPresenter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btnSuccess.setOnClickListener { onBackPressed() }
    }

    override fun onBackPressed() {
        presenter.back()
    }
}