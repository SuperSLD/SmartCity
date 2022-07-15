package online.jutter.smartsity.ui.news.streams

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.presenter.InjectPresenter
import online.jutter.smartsity.domain.controllers.BottomVisibilityController
import online.jutter.smartsity.domain.usecases.GetStreamsUseCase
import online.jutter.supersld.common.base.BasePresenter
import online.jutter.supersld.extensions.launchIO
import online.jutter.supersld.extensions.withUI
import org.koin.core.inject

@InjectViewState
class StreamsPresenter : BasePresenter<StreamsView>() {

    private val bottomVisibilityController: BottomVisibilityController by inject()
    private val getStreamsUseCase: GetStreamsUseCase by inject()

    override fun attachView(view: StreamsView?) {
        super.attachView(view)

        bottomVisibilityController.hide()
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        loadStreams()
    }

    fun loadStreams() {
        launchIO {
            val data = getStreamsUseCase()
            withUI {
                viewState.showStreams(data)
            }
        }
    }

    fun back() {
        router?.exit()
    }

}
