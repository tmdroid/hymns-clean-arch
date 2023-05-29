package de.dannyb.hymns.domain.hymndetails.model

data class HymnDetailsDomainModel(
    val number: Int,
    val title: String,
    val key: String,
    val category: String,
    val stanzas: List<String>,
    val isFavorite: Boolean,
    val hasSheetDownloaded: Boolean,
)
