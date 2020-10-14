package dohun.kim.gatabuta.gatabuta_livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import dohun.kim.gatabuta.gatabuta_livedata.exception.NullLiveDataException
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

/**
 * If a LiveData is transformed, the result of the transformation must be observed.
 * Otherwise the transformation will never be evaluated.
 *
 * @link https://medium.com/androiddevelopers/unit-testing-livedata-and-other-common-observability-problems-bb477262eb04
 */
internal fun <T> LiveData<T>.getOrAwaitValue(): T {
    var data: T? = null
    val latch = CountDownLatch(1)
    val observer = object : Observer<T> {
        override fun onChanged(t: T) {
            data = t
            latch.countDown()
            this@getOrAwaitValue.removeObserver(this)
        }
    }

    observeForever(observer)

    if (!latch.await(100, TimeUnit.MILLISECONDS)) {
        throw TimeoutException("LiveData value was never set. Consider using hasNoValue() instead.")
    }

    if (data == null) {
        throw NullLiveDataException(
            "Data is null, expected non-null"
        )
    }

    return data!!
}