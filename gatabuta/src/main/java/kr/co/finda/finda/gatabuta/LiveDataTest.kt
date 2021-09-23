package kr.co.finda.finda.gatabuta

import androidx.lifecycle.LiveData
import org.junit.jupiter.api.Assertions.*

class LiveDataTest<out T>(private val liveData: LiveData<T>) {
    suspend fun value(): T? = liveData.getOrAwaitValue()
}

/**
 * Start test scope
 */
val <T>LiveData<out T>.test: LiveDataTest<T>
    get() = LiveDataTest(this)

/**
 * Assertion extensions
 */
suspend infix fun <T> LiveDataTest<T>.equalTo(expected: Any?) {
    assertEquals(expected, value())
}

suspend infix fun <T> LiveDataTest<T>.notEqualTo(expected: Any?) {
    assertNotEquals(expected, value())
}

suspend fun <T> LiveDataTest<T>.isNull() {
    assertNull(value())
}

suspend fun <T> LiveDataTest<T>.isNotNull() {
    assertNotNull(value())
}
