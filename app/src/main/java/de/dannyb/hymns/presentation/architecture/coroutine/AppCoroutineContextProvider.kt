package de.dannyb.hymns.presentation.architecture.coroutine

import de.dannyb.hymns.domain.architecture.coroutine.CoroutineContextProvider
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

class AppCoroutineContextProvider : CoroutineContextProvider {
    override val main: CoroutineContext = Dispatchers.Main
    override val io: CoroutineContext = Dispatchers.IO
}