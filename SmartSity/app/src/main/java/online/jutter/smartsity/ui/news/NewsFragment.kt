package online.jutter.smartsity.ui.news

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_news.*
import online.jutter.smartsity.R
import online.jutter.smartsity.domain.controllers.models.Event
import online.jutter.supersld.common.base.BaseFragment

class NewsFragment: BaseFragment(R.layout.fragment_news), NewsView {

    @InjectPresenter
    lateinit var presenter: NewsPresenter

    private val adapter by lazy {  NewsAdapter()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(rvNews) {
            adapter = this@NewsFragment.adapter
            layoutManager = LinearLayoutManager(context)
        }
    }
    override fun onBackPressed() {

    }

    override fun addList(list: MutableList<Event>) {
        adapter.addData(list)
    }

    override fun showErrorLoading() {

    }

    override fun toggleLoading(show: Boolean) {

    }


}