package online.jutter.smartsity.ui.view.floorsview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.view_floors.view.*
import online.jutter.smartsity.R

class FloorsView  : RelativeLayout {

    private var mFloorChangeListener = { _:Int->}
    private val mAdapter by lazy { FloorsAdapter() }



    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, defUtils: Int) : super(
        context,
        attributeSet,
        defUtils
    )

    init {
        View.inflate(context, R.layout.view_floors, this)

        with(rvFloors) {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    fun setFloors(floorCount: Int) {
        if (floorCount <= 1) {
            visibility = GONE
            mAdapter.updateFloors(floorCount)
        } else {
            visibility = VISIBLE
            mAdapter.updateFloors(floorCount)
            mAdapter.onFloorChanged {
                mFloorChangeListener(it)
            }
        }
    }

    fun onFloorChanged(l: (Int)->Unit) {
        mFloorChangeListener = l
    }
}