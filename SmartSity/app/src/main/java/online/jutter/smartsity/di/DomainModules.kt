package online.jutter.smartsity.di

import online.jutter.smartsity.domain.controllers.BottomVisibilityController
import online.jutter.smartsity.domain.controllers.ChangeBottomTabController
import online.jutter.smartsity.domain.usecases.*
import org.koin.core.module.Module

fun Module.provideUseCases() {
    single { GetPhoneUseCase(get()) }
    single { SavePhoneUseCase(get()) }
    single { IsAuthUseCase(get()) }
    single { GetScheduleListUseCase(get()) }
    single { GetProfileUseCase(get(), get()) }
//    single { SaveHomeMarkerUseCase(get()) }
}

fun Module.provideControllers() {
    single { ChangeBottomTabController() }
    single { BottomVisibilityController() }
//    single { SelectRoomController() }
}
