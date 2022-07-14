package online.jutter.smartsity.ui.news.holders

import android.annotation.SuppressLint
import android.view.View
import kotlinx.android.synthetic.main.item_event_holder.view.*
import online.jutter.diffadapter2.base.DFBaseHolder
import online.jutter.diffadapter2.base.HolderLayout
import online.jutter.smartsity.R
import online.jutter.smartsity.domain.controllers.models.Event

@SuppressLint("NonConstantResourceId")
@HolderLayout(layout = R.layout.item_event_holder)
class EventHolder (itemView: View) : DFBaseHolder<Event>(itemView) {
    @SuppressLint("SetTextI18n")
    override fun bind(item: Event) {
        with(itemView) {
            tvTitle.text = item.title
            tvInfo.text = item.info
            tvDate.text = item.date
        }
    }
}