package de.dannyb.hymns.domain.hymnslist.usecase

import de.dannyb.hymns.domain.architecture.coroutine.CoroutineContextProvider
import de.dannyb.hymns.domain.architecture.usecase.BackgroundExecutingUseCase
import de.dannyb.hymns.domain.hymnslist.model.HymnDomainModel
import de.dannyb.hymns.domain.hymnslist.repository.DownloadHymnsRepository
import javax.inject.Inject

@Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
class DownloadHymnsUseCase @Inject constructor(
    private val downloadHymnsRepository: DownloadHymnsRepository,
    coroutineContextProvider: CoroutineContextProvider,
) : BackgroundExecutingUseCase<String, List<HymnDomainModel>>(coroutineContextProvider) {

    override fun executeInBackground(language: String): List<HymnDomainModel> {
        return downloadHymnsRepository.downloadHymns(language)
    }

}