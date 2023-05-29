package de.dannyb.hymns.presentation.hymnslist.model

sealed interface HymnsListViewState {
    object Loading : HymnsListViewState
    data class Success(val hymns: List<HymnPresentationModel>) : HymnsListViewState
}