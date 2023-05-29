package de.dannyb.hymns.presentation.hymndetails.mapper

import de.dannyb.hymns.domain.hymndetails.model.HymnDetailsDomainModel
import de.dannyb.hymns.presentation.hymndetails.model.HymnDetailsPresentationModel
import javax.inject.Inject

class HymnDetailsDomainToPresentationMapper @Inject constructor() {
    fun toPresentation(hymn: HymnDetailsDomainModel): HymnDetailsPresentationModel = with(hymn) {
        HymnDetailsPresentationModel(
            number = number,
            title = title,
            category = category,
            key = key,
            stanzas = stanzas,
            isFavorite = isFavorite,
            hasSheetDownloaded = hasSheetDownloaded
        )
    }
}