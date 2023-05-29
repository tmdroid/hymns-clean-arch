package de.dannyb.hymns.presentation.hymndetails.view

import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import de.dannyb.hymns.domain.architecture.usecase.UseCaseExecutor
import de.dannyb.hymns.domain.hymndetails.usecase.GetHymnDetailsUseCase
import de.dannyb.hymns.presentation.architecture.BaseViewModel
import de.dannyb.hymns.presentation.hymndetails.mapper.HymnDetailsDomainToPresentationMapper
import de.dannyb.hymns.presentation.hymndetails.model.HymnDetailsViewState
import de.dannyb.hymns.presentation.hymndetails.navigation.TopicArgs
import javax.inject.Inject

@HiltViewModel
class HymnDetailsViewModel @Inject constructor(
    private val getHymnDetailsUseCase: GetHymnDetailsUseCase,
    private val hymnDetailsDomainToPresentationMapper: HymnDetailsDomainToPresentationMapper,
    savedStateHandle: SavedStateHandle,
    useCaseExecutorFactory: UseCaseExecutor.Factory
) : BaseViewModel<HymnDetailsViewState, Unit>(useCaseExecutorFactory) {

    private val topicArgs: TopicArgs = TopicArgs(savedStateHandle)

    override fun initialState(): HymnDetailsViewState {
        return HymnDetailsViewState.Loading
    }

    override fun onEntered() {
        val hymn = getHymnDetailsUseCase.executeInBackground(topicArgs.hymnNumber)
            .let { hymnDetailsDomainToPresentationMapper.toPresentation(it) }
        updateViewState { HymnDetailsViewState.Success(hymn = hymn) }
    }
}