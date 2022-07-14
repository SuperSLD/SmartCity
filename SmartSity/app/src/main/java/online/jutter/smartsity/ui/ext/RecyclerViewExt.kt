package online.jutter.smartsity.ui.ext

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SpaceBetweenItemDecoration(private val space: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        if (parent.getChildAdapterPosition(view) != 0) {
            when(val lm = parent.layoutManager) {
                is LinearLayoutManager -> {
                    when(lm.orientation) {
                        RecyclerView.VERTICAL -> outRect.top = space
                        RecyclerView.HORIZONTAL -> outRect.left = space
                    }
                }
            }
        }
    }

}
