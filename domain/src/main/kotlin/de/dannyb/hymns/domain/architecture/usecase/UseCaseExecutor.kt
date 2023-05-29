package de.dannyb.hymns.domain.architecture.usecase

import de.dannyb.hymns.domain.architecture.exception.DomainException
import de.dannyb.hymns.domain.architecture.exception.UnknownDomainException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.concurrent.CancellationException

class UseCaseExecutor(
    private val coroutineScope: CoroutineScope
) {

    class Factory {
        operator fun invoke(coroutineScope: CoroutineScope) = UseCaseExecutor(coroutineScope)
    }

    fun <INPUT, OUTPUT> execute(
        useCase: UseCase<INPUT, OUTPUT>,
        value: INPUT,
        onResult: (OUTPUT) -> Unit = {},
        onException: (DomainException) -> Unit = {}
    ) {
        coroutineScope.launch {
            try {
                useCase.execute(value, onResult)
            } catch (ignore: CancellationException) {
                // no op
            } catch (t: Throwable) {
                onException(t as? DomainException ?: UnknownDomainException(t))
            }
        }
    }

}