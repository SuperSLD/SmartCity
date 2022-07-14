package online.jutter.smartsity.di

import org.koin.dsl.module

fun appModule() = module {
    provideDataFlow()
    provideUeeCases()
    provideControllers()
    provideNetModules()
}