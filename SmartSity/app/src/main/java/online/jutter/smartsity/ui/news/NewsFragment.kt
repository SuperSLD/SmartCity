package online.jutter.smartsity.ui.news

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_news.*
import online.jutter.smartsity.R
import online.jutter.smartsity.domain.controllers.models.Event
import online.jutter.smartsity.domain.models.NewsLocal
import online.jutter.supersld.common.base.BaseFragment
import online.jutter.supersld.extensions.addSystemTopPadding

class NewsFragment: BaseFragment(R.layout.fragment_news), NewsView {

    @InjectPresenter
    lateinit var presenter: NewsPresenter

    private val adapter by lazy {  NewsAdapter(presenter::toNewsDetail) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vgContent.addSystemTopPadding()

        with(rvNews) {
            adapter = this@NewsFragment.adapter
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                true
            )
        }
    }
    override fun onBackPressed() {

    }

    override fun addList(list: List<NewsLocal>) {
        adapter.addAll(list)
    }

    override fun showErrorLoading() {

    }

    override fun toggleLoading(show: Boolean) {

    }


}
