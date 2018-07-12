package statistics_cash.fedka27.github.com.statisticscash.extentions

import kotlinx.coroutines.experimental.DefaultDispatcher
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.newFixedThreadPoolContext
import kotlin.coroutines.experimental.CoroutineContext

private const val NETWORK_THREAD_MAX_COUNT = 3
private const val NETWORK_THREAD_NAME = "network"

val uiContext: CoroutineContext = UI
val netContext: CoroutineContext = newFixedThreadPoolContext(NETWORK_THREAD_MAX_COUNT, NETWORK_THREAD_NAME)
val ioContext: CoroutineContext = DefaultDispatcher