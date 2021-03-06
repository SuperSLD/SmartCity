package online.jutter.smartsity.ui.main

import android.os.Bundle
import online.jutter.smartsity.Screens
import online.jutter.supersld.common.base.FlowFragment
import ru.terrakok.cicerone.commands.BackTo
import ru.terrakok.cicerone.commands.Replace

class FlowMainFragment: FlowFragment(ROUTER) {
    companion object {
        const val ROUTER = "CONTAINER_ROUTER"
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (childFragmentManager.fragments.isEmpty()) {
            navigator.applyCommands(
                arrayOf(
                    BackTo(null),
                    Replace(Screens.MainContainer)
                )
            )
        }
    }
}