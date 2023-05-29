package de.dannyb.hymns.domain.architecture.exception

class UnknownDomainException(
    throwable: Throwable
) : DomainException(throwable) {
    constructor(errorMessage: String) : this(Throwable(errorMessage))
}