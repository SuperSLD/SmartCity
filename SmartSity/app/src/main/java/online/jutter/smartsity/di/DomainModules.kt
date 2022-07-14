package online.jutter.smartsity.di

import online.jutter.smartsity.domain.controllers.BottomVisibilityController
import online.jutter.smartsity.domain.controllers.ChangeBottomTabController
import org.koin.core.module.Module

fun Module.provideUeeCases() {
//    single { GetThemeIsDayUseCase(get()) }
//    single { SaveThemeIsDayUseCase(get()) }
//    single { GetHomeMarkerUseCase(get()) }
//    single { SaveHomeMarkerUseCase(get()) }
}

fun Module.provideControllers() {
    single { ChangeBottomTabController() }
    single { BottomVisibilityController() }
//    single { SelectRoomController() }
}
