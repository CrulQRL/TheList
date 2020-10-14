package com.crulqrl.thelist.inject

import com.crulqrl.thelist.TheListApp
import com.crulqrl.thelist.home.HomeActivityBuilder
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ApiModule::class,
    DBModule::class,
    HomeActivityBuilder::class
])
interface AppComponent : AndroidInjector<TheListApp> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: TheListApp): AppComponent
    }
}