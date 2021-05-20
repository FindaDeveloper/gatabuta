package dohun.kim.gatabuta.gatabuta_livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.asFlow
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withTimeout

/**
 * If a LiveData is transformed, the result of the transformation must be observed.
 * Otherwise the transformation will never be evaluated.
 *
 * @link https://medium.com/androiddevelopers/unit-testing-livedata-and-other-common-observability-problems-bb477262eb04
 */
internal suspend fun <T> LiveData<T>.getOrAwaitValue(): T? =
    try {
        withTimeout(100) {
            this@getOrAwaitValue.asFlow().first()
        }
    } catch (e: TimeoutCancellationException) {
        null
    }
