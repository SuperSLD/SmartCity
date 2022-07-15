package online.jutter.smartsity.ui.news.detail

import com.arellomobile.mvp.MvpView
import online.jutter.smartsity.common.base.BaseView
import online.jutter.smartsity.domain.models.NewsLocal

interface NewsDetailsView : MvpView {

    fun showNewsDetail(data: NewsLocal)

}
