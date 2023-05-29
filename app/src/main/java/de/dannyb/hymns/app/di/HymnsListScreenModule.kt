package de.dannyb.hymns.app.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.dannyb.hymns.domain.hymns.repository.DownloadHymnsRepository
import de.dannyb.hymns.domain.hymns.repository.DummyDownloadHymnsRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class HymnsListScreenModule {

    @Binds
    abstract fun bindDownloadHymnsRepository(dummyDownloadHymnsRepository: DummyDownloadHymnsRepository): DownloadHymnsRepository

}