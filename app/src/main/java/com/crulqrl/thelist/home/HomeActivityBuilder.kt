package com.crulqrl.thelist.home

import androidx.lifecycle.ViewModel
import com.crulqrl.thelist.inject.ViewModelBuilder
import com.crulqrl.thelist.inject.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
public abstract class HomeActivityBuilder {
    @ContributesAndroidInjector(modules = [
        ViewModelBuilder::class
    ])
    internal abstract fun bindHomeActivity(): HomeActivity

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel
}