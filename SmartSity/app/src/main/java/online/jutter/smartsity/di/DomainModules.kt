package online.jutter.smartsity.di

import online.jutter.smartsity.domain.controllers.*
import online.jutter.smartsity.domain.usecases.GetPhoneUseCase
import online.jutter.smartsity.domain.usecases.GetScheduleListUseCase
import online.jutter.smartsity.domain.usecases.IsAuthUseCase
import online.jutter.smartsity.domain.usecases.SavePhoneUseCase
import org.koin.core.module.Module

fun Module.provideUseCases() {
    single { GetPhoneUseCase(get()) }
    single { SavePhoneUseCase(get()) }
    single { IsAuthUseCase(get()) }
    single { GetScheduleListUseCase(get()) }
//    single { SaveHomeMarkerUseCase(get()) }
}

fun Module.provideControllers() {
    single { ChangeBottomTabController() }
    single { BottomVisibilityController() }
    single { SelectMarkerController() }
    single { NavigationController() }
    single { SelectRoomController() }
}
