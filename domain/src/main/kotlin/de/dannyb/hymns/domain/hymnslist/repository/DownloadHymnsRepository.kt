package de.dannyb.hymns.domain.hymnslist.repository

import de.dannyb.hymns.domain.hymnslist.model.HymnDomainModel

interface DownloadHymnsRepository {
    fun downloadHymns(language: String): List<HymnDomainModel>
}