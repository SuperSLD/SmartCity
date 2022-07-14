package online.jutter.smartsity.ui.auth.pincode

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpView
import online.jutter.supersld.common.base.BasePresenter

@InjectViewState
class PinPresenter : BasePresenter<MvpView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun back() {
        router?.exit()
    }
}