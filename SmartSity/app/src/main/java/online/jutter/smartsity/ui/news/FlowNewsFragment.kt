package online.jutter.smartsity.ui.news

import android.os.Bundle
import online.jutter.smartsity.Screens
import online.jutter.supersld.common.base.FlowFragment
import ru.terrakok.cicerone.commands.BackTo
import ru.terrakok.cicerone.commands.Replace

class FlowNewsFragment: FlowFragment(ROUTER) {

    companion object {
        const val ROUTER = "NEWS_ROUTER"
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (childFragmentManager.fragments.isEmpty()) {
            navigator.applyCommands(
                arrayOf(
                    BackTo(null),
                    Replace(Screens.News)
                )
            )
        }
    }
}