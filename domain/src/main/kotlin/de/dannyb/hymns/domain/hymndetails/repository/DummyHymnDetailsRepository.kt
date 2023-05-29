package de.dannyb.hymns.domain.hymndetails.repository

import de.dannyb.hymns.domain.hymndetails.model.HymnDetailsDomainModel
import javax.inject.Inject

class DummyHymnDetailsRepository @Inject constructor() : HymnDetailsRepository {
    override fun getHymnDetails(hymnNumber: Int): HymnDetailsDomainModel {
        return HymnDetailsDomainModel(
            number = hymnNumber,
            title = "Demo title",
            key = listOf(
                "A",
                "B",
                "C",
                "D",
                "E",
                "F",
                "G"
            ).let { it[hymnNumber % it.size] },
            category = "Category 1",
            stanzas = listOf(
                "1. Doamne sfinte, Te mărim!\r\nDe puterea Ta măiastră\r\nPovestesc, când le privim,\r\nStelele din bolta-albastră,\r\nTu, ce haru-Ți spre noi pleci\r\nNeschimbat rămâi în veci!",
                "2. Tot ce poate lăuda,\r\nÎngerii în mii de cete,\r\nAdunați spre a-Ți cânta,\r\nNu-ncetează să repete:\r\n\u201cSfânt e peste toate-n tot\r\nDumnezeul Sabaot!\u201d",
                "3. Dar mai scumpă decât tot\r\nȚi-este slaba mea cântare,\r\nCe-o înalț așa cum pot\r\nÎn această adunare,\r\nVrem cu toții a-Ți cânta:\r\n\u201cMare e iubirea Ta!\u201d"
            ),
            isFavorite = false,
            hasSheetDownloaded = false,
        )
    }
}