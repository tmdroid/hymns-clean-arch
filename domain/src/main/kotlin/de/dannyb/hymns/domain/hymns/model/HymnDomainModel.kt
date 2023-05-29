package de.dannyb.hymns.domain.hymns.model

data class HymnDomainModel(
    val number: Int,
    val title: String,
    val category: String,
    val key: String?,
    val stanzas: List<String>,
    val hasMp3: Boolean,
    val hasSheet: Boolean,
)