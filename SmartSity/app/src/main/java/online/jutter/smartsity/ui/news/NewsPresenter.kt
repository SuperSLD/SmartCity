package online.jutter.smartsity.ui.news

import android.content.Context
import android.nfc.tech.MifareUltralight.PAGE_SIZE
import com.arellomobile.mvp.InjectViewState
import online.jutter.smartsity.R
import online.jutter.smartsity.Screens
import online.jutter.smartsity.common.extesions.showToast
import online.jutter.smartsity.domain.controllers.BottomVisibilityController
import online.jutter.smartsity.domain.controllers.models.Event
import online.jutter.smartsity.domain.models.NewsLocal
import online.jutter.smartsity.domain.usecases.GetNewsUseCase
import online.jutter.smartsity.ui.ext.createHandler
import online.jutter.supersld.common.base.BasePresenter
import online.jutter.supersld.extensions.launchIO
import online.jutter.supersld.extensions.launchUI
import online.jutter.supersld.extensions.withIO
import org.koin.core.inject

@InjectViewState
class NewsPresenter: BasePresenter<NewsView>() {

    private val bottomVisibilityController: BottomVisibilityController by inject()
    private val getNewsUseCase: GetNewsUseCase by inject()

    override fun attachView(view: NewsView?) {
        super.attachView(view)

        bottomVisibilityController.show()
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadList()
    }

    fun loadList() {
        launchIO {
            viewState.toggleLoading(true)
            val data = getNewsUseCase()
            launchUI {
                viewState.toggleLoading(false)
                viewState.addList(data)
            }
        }
    }

    fun toNewsDetail(news: NewsLocal) {
        router?.navigateTo(Screens.NewsDetail(news))
    }

    fun toStreams() {
        router?.navigateTo(Screens.Streams)
    }
}
