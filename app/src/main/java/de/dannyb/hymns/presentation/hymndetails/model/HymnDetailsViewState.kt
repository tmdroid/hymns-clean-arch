package de.dannyb.hymns.presentation.hymndetails.model

sealed interface HymnDetailsViewState {
    object Loading : HymnDetailsViewState

    data class Success(val hymn: HymnDetailsPresentationModel) : HymnDetailsViewState
}