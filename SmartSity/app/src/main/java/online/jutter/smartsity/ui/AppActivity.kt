package online.jutter.smartsity.ui

import androidx.fragment.app.Fragment
import online.jutter.smartsity.R
import online.jutter.smartsity.Screens
import online.jutter.supersld.ActivityBase

class AppActivity : ActivityBase() {

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        window?.setWindowAnimations(R.style.WindowAnimationTransition)
    }

    override fun themeIsDay(): Boolean {
        return true
    }

    override fun getStatusAndNavigationColor(): Pair<Int, Int> {
        return Pair(R.color.colorStatusBar, R.color.colorNavigationBar)
    }

    override fun getStartFragment(): Fragment {
        return Screens.FlowGlobal.fragment
    }
}