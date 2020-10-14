package dohun.kim.gatabuta.gatabuta_livedata

import androidx.lifecycle.LiveData
import dohun.kim.gatabuta.gatabuta_livedata.exception.NullLiveDataException
import org.junit.Assert.*
import java.util.concurrent.TimeoutException

class LiveDataTest<T>(private val liveData: LiveData<T>) {
    val value: T
        get() = liveData.getOrAwaitValue()
}

/**
 * Start test scope
 */
val <T>LiveData<T>.test: LiveDataTest<T>
    get() = LiveDataTest(this)

infix fun <T> LiveData<T>.test(block: LiveDataTest<T>.() -> Unit) {
    block.invoke(LiveDataTest(this))
}

/**
 * Assertion extensions
 */
infix fun <T> LiveDataTest<T>.equalTo(expected: Any?) {
    assertEquals(value, expected)
}

infix fun <T> LiveDataTest<T>.notEqualTo(expected: Any?) {
    assertNotEquals(value, expected)
}

fun <T> LiveDataTest<T>.hasValue() {
    try {
        value
    } catch (e: TimeoutException) {
        fail()
    }
}

fun <T> LiveDataTest<T>.hasNoValue() {
    try {
        value
        fail()
    } catch (e: TimeoutException) {
    }
}

fun <T> LiveDataTest<T>.isNull() {
    try {
        value
    } catch (e: NullLiveDataException) {
    }
}

fun <T> LiveDataTest<T>.isNotNull() {
    try {
        value
    } catch (e: NullLiveDataException) {
        fail()
    }
}




