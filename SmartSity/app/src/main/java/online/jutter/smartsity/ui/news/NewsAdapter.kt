package online.jutter.smartsity.ui.news

import android.nfc.tech.MifareUltralight.PAGE_SIZE
import online.jutter.diffadapter2.DiffAdapter
import online.jutter.diffadapter2.base.HolderFactory
import online.jutter.smartsity.domain.controllers.models.Event
import online.jutter.smartsity.ui.news.holders.EventHolder
import online.jutter.supersld.extensions.launchUI
import online.jutter.supersld.extensions.withIO

class NewsAdapter : DiffAdapter() {

    companion object {
        const val LIVE_RECORD_ITEM = 1001
        const val TITLE_ITEM = 1002
        const val EVENT_ITEM = 1003
    }

    override fun initFactory() = HolderFactory(hashMapOf(
        EVENT_ITEM to EventHolder::class.java
    ))

    fun addData(data: MutableList<Event>) {
        data.forEach { adv ->
            val list = getList()
            list.add(Pair(LIVE_RECORD_ITEM, adv))
            list.add(Pair(TITLE_ITEM, adv))
            list.add(Pair(EVENT_ITEM, adv))
        }
        notifyDataSetChanged()
    }
}