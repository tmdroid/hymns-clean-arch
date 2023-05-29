package de.dannyb.hymns.app.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.dannyb.hymns.domain.hymndetails.repository.DummyHymnDetailsRepository
import de.dannyb.hymns.domain.hymndetails.repository.HymnDetailsRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class HymnDetailsScreenModule {

    @Binds
    abstract fun bindHymnDetailsRepository(dummyHymnDetailsRepository: DummyHymnDetailsRepository): HymnDetailsRepository

}