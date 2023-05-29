package de.dannyb.hymns.presentation.hymnslist.mapper

import de.dannyb.hymns.domain.hymnslist.model.HymnDomainModel
import de.dannyb.hymns.presentation.hymnslist.model.HymnPresentationModel
import javax.inject.Inject

class HymnsDomainToPresentationMapper @Inject constructor() {
    fun toPresentation(hymns: List<HymnDomainModel>): List<HymnPresentationModel> = hymns.map {
        HymnPresentationModel(number = it.number, title = it.title)
    }
}