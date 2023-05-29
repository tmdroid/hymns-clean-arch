package de.dannyb.hymns.presentation.architecture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.dannyb.hymns.domain.architecture.destination.PresentationDestination
import de.dannyb.hymns.domain.architecture.usecase.UseCaseExecutor
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.update

abstract class BaseViewModel<VIEW_STATE : Any, NOTIFICATION : Any>(
    useCaseExecutorFactory: UseCaseExecutor.Factory
) : ViewModel() {

    private val _viewState by lazy { MutableStateFlow(initialState()) }
    val viewState = _viewState.asStateFlow()

    private val _notification = Channel<NOTIFICATION>(Channel.BUFFERED)
    val notification = _notification.consumeAsFlow()

    private val _destination = Channel<PresentationDestination>(Channel.BUFFERED)
    val destination = _destination.consumeAsFlow()

    internal abstract fun initialState(): VIEW_STATE

    private val currentViewState: VIEW_STATE
        get() = viewState.value

    internal val useCaseExecutor: UseCaseExecutor

    init {
        useCaseExecutor = useCaseExecutorFactory.invoke(viewModelScope)
    }

    internal fun updateViewState(newViewState: VIEW_STATE) {
        _viewState.update { newViewState }
    }

    internal fun updateViewState(updatedState: VIEW_STATE.() -> VIEW_STATE) {
        updateViewState(currentViewState.updatedState())
    }

    internal fun notify(notification: NOTIFICATION) {
        _notification.trySend(notification)
    }

    internal fun navigateTo(destination: PresentationDestination) {
        _destination.trySend(destination)
    }

    internal fun navigateBack() {
        _destination.trySend(PresentationDestination.Back)
    }

    abstract fun onEntered() // used to trigger data loading

}