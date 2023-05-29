package de.dannyb.hymns.presentation.hymndetails.model

data class HymnDetailsPresentationModel(
    val number: Int,
    val title: String,
    val key: String,
    val category: String,
    val stanzas: List<String>,
    val isFavorite: Boolean,
    val hasSheetDownloaded: Boolean,
)
