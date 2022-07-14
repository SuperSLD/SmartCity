package online.jutter.smartsity.ui.news

import android.content.Context
import android.nfc.tech.MifareUltralight.PAGE_SIZE
import com.arellomobile.mvp.InjectViewState
import online.jutter.smartsity.R
import online.jutter.smartsity.common.extesions.showToast
import online.jutter.smartsity.domain.controllers.models.Event
import online.jutter.smartsity.ui.ext.createHandler
import online.jutter.supersld.common.base.BasePresenter
import online.jutter.supersld.extensions.launchUI
import online.jutter.supersld.extensions.withIO
import org.koin.core.inject

@InjectViewState
class NewsPresenter: BasePresenter<NewsView>() {

    private val context: Context by inject()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadList()
    }

    fun loadList() {
        val handler = createHandler {
            viewState.showErrorLoading()
            //context.showToast(R.drawable.ic_close_toast, it.message.toString())
        }
        launchUI(handler) {
            viewState.toggleLoading(false)
        }
    }
}