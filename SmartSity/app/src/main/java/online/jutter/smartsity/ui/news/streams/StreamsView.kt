package online.jutter.smartsity.ui.news.streams

import online.jutter.smartsity.common.base.BaseView
import online.jutter.smartsity.domain.models.StreamLocal

interface StreamsView : BaseView {

    fun showStreams(streams: List<StreamLocal>)

}
