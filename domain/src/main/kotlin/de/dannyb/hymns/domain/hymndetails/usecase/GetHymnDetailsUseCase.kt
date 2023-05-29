package de.dannyb.hymns.domain.hymndetails.usecase

import de.dannyb.hymns.domain.architecture.coroutine.CoroutineContextProvider
import de.dannyb.hymns.domain.architecture.usecase.BackgroundExecutingUseCase
import de.dannyb.hymns.domain.hymndetails.model.HymnDetailsDomainModel
import de.dannyb.hymns.domain.hymndetails.repository.HymnDetailsRepository
import javax.inject.Inject

class GetHymnDetailsUseCase @Inject constructor(
    private val hymnDetailsRepository: HymnDetailsRepository,
    coroutineContextProvider: CoroutineContextProvider
) : BackgroundExecutingUseCase<Int, HymnDetailsDomainModel>(coroutineContextProvider) {

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun executeInBackground(hymnNumber: Int): HymnDetailsDomainModel {
        return hymnDetailsRepository.getHymnDetails(hymnNumber)
    }
}