package dohun.kim.gatabuta

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import org.junit.Assert.*
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

/**
 * @link https://medium.com/androiddevelopers/unit-testing-livedata-and-other-common-observability-problems-bb477262eb04
 *
 * If a LiveData is transformed, the result of the transformation must be observed.
 * Otherwise the transformation will never be evaluated.
 */
internal fun <T> LiveData<T>.getOrAwaitValue(): T? {
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

    if (!latch.await(500, TimeUnit.MILLISECONDS)) {
        throw TimeoutException("LiveData value was never set.")
    }

    return data
}

infix fun <T> LiveData<T>.equals(expected: T?) {
    val actual = getOrAwaitValue()
    assertEquals(expected, actual)
}

infix fun <T> LiveData<T>.not(unexpected: T?) {
    val actual = getOrAwaitValue()
    assertNotEquals(unexpected, actual)
}

fun LiveData<Boolean>.isTrue() {
    val condition = getOrAwaitValue() ?: false
    assertTrue(condition)
}

fun LiveData<Boolean>.isFalse() {
    val condition = getOrAwaitValue() ?: false
    assertFalse(condition)
}

infix fun <T : Collection<*>> LiveData<T>.hasSize(expected: Int) {
    val value = getOrAwaitValue()
    val actual = value?.size
    assertEquals(expected, actual)
}

infix fun <T : CharSequence> LiveData<T>.hasLength(expected: Int) {
    val value = getOrAwaitValue()
    val actual = value?.length
    assertEquals(expected, actual)
}