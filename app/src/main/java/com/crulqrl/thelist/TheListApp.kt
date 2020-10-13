package com.crulqrl.thelist

import com.crulqrl.thelist.inject.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class TheListApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }
}