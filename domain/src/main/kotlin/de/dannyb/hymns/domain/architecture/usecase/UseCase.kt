package de.dannyb.hymns.domain.architecture.usecase

interface UseCase<REQUEST, RESULT> {

    suspend fun execute(input: REQUEST, onResult: (RESULT) -> Unit)

}