package online.jutter.smartsity.ui.view

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.view_toolbar.view.*
import online.jutter.smartsity.R
import online.jutter.smartsity.common.extesions.getColor
import online.jutter.smartsity.common.extesions.show
import online.jutter.supersld.extensions.addSystemTopPadding

class ToolbarView : LinearLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defUtils: Int) : super(
        context,
        attributeSet,
        defUtils
    )

    init {
        inflate(context, R.layout.view_toolbar, this)
        addSystemTopPadding()
        setBackgroundColor(getColor(R.color.colorBackground))
    }

    fun setTitle(title: Int) {
        tvTitle.setText(title)
    }

    fun setTitle(title: String) {
        tvTitle.text = title
    }

    fun onBack(back: ()->Unit, resId: Int? = null) {
        if (resId != null) {
            icClose.setImageDrawable(ContextCompat.getDrawable(context, resId))
        }
        icClose.show()
        icClose.setOnClickListener {
            back()
        }
    }

    fun setFirstAction(action: Action) {
        icFirst.show()
        icFirst.setImageDrawable(ContextCompat.getDrawable(context, action.resId))
        icFirst.setOnClickListener {
            action.action()
        }
    }

    fun setSecondAction(action: Action) {
        icSecond.show()
        icSecond.setImageDrawable(ContextCompat.getDrawable(context, action.resId))
        icSecond.setOnClickListener {
            action.action()
        }
    }

    fun setTextAction(action: Action) {
        tvAction.show()
        tvAction.setText(action.resId)
        tvAction.setOnClickListener {
            action.action()
        }
    }

    class Action(
        val resId: Int,
        val action: ()->Unit
    )
}