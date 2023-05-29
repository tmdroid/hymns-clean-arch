package de.dannyb.hymns.domain.hymndetails.repository

import de.dannyb.hymns.domain.hymndetails.model.HymnDetailsDomainModel

interface HymnDetailsRepository {

    fun getHymnDetails(hymnNumber: Int): HymnDetailsDomainModel

}