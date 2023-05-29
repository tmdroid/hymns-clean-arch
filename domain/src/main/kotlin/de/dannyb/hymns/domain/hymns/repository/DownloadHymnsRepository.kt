package de.dannyb.hymns.domain.hymns.repository

import de.dannyb.hymns.domain.hymns.model.HymnDomainModel

interface DownloadHymnsRepository {
    fun downloadHymns(language: String): List<HymnDomainModel>
}