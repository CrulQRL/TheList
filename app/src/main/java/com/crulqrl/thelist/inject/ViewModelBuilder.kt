package com.crulqrl.thelist.inject

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module


@Module
internal abstract class ViewModelBuilder {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}