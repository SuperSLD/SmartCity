package online.jutter.smartsity.domain.controllers

import online.jutter.supersld.common.datacontrol.PublishDataController
import ru.terrakok.cicerone.android.support.SupportAppScreen

class ChangeBottomTabController {
    val state = PublishDataController<SupportAppScreen>()

    fun changeMainScreen(screen: SupportAppScreen) = state.emit(screen)
}