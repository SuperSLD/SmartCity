package online.jutter.smartsity.ui.news.detail

import com.arellomobile.mvp.InjectViewState
import online.jutter.smartsity.domain.controllers.BottomVisibilityController
import online.jutter.smartsity.domain.models.NewsLocal
import online.jutter.supersld.common.base.BasePresenter
import org.koin.core.inject

@InjectViewState
class NewsDetailPresenter(private val news: NewsLocal?) : BasePresenter<NewsDetailsView>() {

    private val bottomVisibilityController: BottomVisibilityController by inject()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        bottomVisibilityController.hide()
        loadData()
    }

    private fun loadData() {
        news?.let {
            viewState.showNewsDetail(it)
        }
    }

    fun back() {
        router?.exit()
    }

}
