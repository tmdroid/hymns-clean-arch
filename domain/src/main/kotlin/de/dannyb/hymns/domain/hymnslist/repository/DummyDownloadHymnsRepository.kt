package de.dannyb.hymns.domain.hymnslist.repository

import de.dannyb.hymns.domain.hymnslist.model.HymnDomainModel
import javax.inject.Inject

class DummyDownloadHymnsRepository @Inject constructor() : DownloadHymnsRepository {
    override fun downloadHymns(language: String): List<HymnDomainModel> {
        return buildList {
            repeat(100) {
                val h = HymnDomainModel(
                    number = it + 1,
                    title = "Hymn Title ${it + 1}",
                    category = "Category ${(1..10).random()}",
                    key = null,
                    stanzas = emptyList(),
                    hasMp3 = false,
                    hasSheet = false
                )

                add(h)
            }
        }
    }
}