package de.dannyb.hymns.presentation.hymnslist.view

import dagger.hilt.android.lifecycle.HiltViewModel
import de.dannyb.hymns.domain.architecture.usecase.UseCaseExecutor
import de.dannyb.hymns.domain.hymns.usecase.DownloadHymnsUseCase
import de.dannyb.hymns.presentation.architecture.BaseViewModel
import de.dannyb.hymns.presentation.hymnslist.mapper.HymnsDomainToPresentationMapper
import de.dannyb.hymns.presentation.hymnslist.model.HymnsListViewState
import javax.inject.Inject

@HiltViewModel
class HymnsListViewModel @Inject constructor(
    private val downloadHymnsUseCase: DownloadHymnsUseCase,
    private val hymnsToPresentationMapper: HymnsDomainToPresentationMapper,
    useCaseExecutorFactory: UseCaseExecutor.Factory,
) : BaseViewModel<HymnsListViewState, Unit>(useCaseExecutorFactory) {

    override fun initialState(): HymnsListViewState = HymnsListViewState.Loading

    private fun fetchHymnsList() {
        useCaseExecutor.execute(downloadHymnsUseCase, "ro", onResult = {
            val hymns = hymnsToPresentationMapper.toPresentation(it)
            updateViewState { HymnsListViewState.Success(hymns = hymns) }
        })
    }

    override fun onEntered() = fetchHymnsList()
}