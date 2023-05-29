package de.dannyb.hymns.presentation.hymndetails.view

import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import de.dannyb.hymns.domain.architecture.usecase.UseCaseExecutor
import de.dannyb.hymns.presentation.architecture.BaseViewModel
import de.dannyb.hymns.presentation.hymndetails.model.HymnDetailsViewState
import de.dannyb.hymns.presentation.hymndetails.navigation.TopicArgs
import de.dannyb.hymns.presentation.hymndetails.view.preview.HymnDetailsPreviewParameterProvider
import javax.inject.Inject

@HiltViewModel
class HymnDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    useCaseExecutorFactory: UseCaseExecutor.Factory
) : BaseViewModel<HymnDetailsViewState, Unit>(useCaseExecutorFactory) {

    private val topicArgs: TopicArgs = TopicArgs(savedStateHandle)

    override fun initialState(): HymnDetailsViewState {
        return HymnDetailsViewState.Loading
    }

    override fun onEntered() {
        println("XDBG: ${topicArgs.hymnNumber}")

        val provider = HymnDetailsPreviewParameterProvider(topicArgs.hymnNumber)
        val hymn = provider.values.first()

        updateViewState { HymnDetailsViewState.Success(hymn = hymn) }
    }
}