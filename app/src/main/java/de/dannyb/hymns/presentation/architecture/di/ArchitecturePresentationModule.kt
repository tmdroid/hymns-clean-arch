package de.dannyb.hymns.presentation.architecture.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import de.dannyb.hymns.domain.architecture.coroutine.CoroutineContextProvider
import de.dannyb.hymns.domain.architecture.usecase.UseCaseExecutor
import de.dannyb.hymns.presentation.architecture.coroutine.AppCoroutineContextProvider

@Module
@InstallIn(ViewModelComponent::class)
object ArchitecturePresentationModule {

    @Provides
    fun provideUseCaseExecutorFactory(): UseCaseExecutor.Factory = UseCaseExecutor.Factory()

    @Provides
    fun providesCoroutineContextProvider(): CoroutineContextProvider = AppCoroutineContextProvider()

}