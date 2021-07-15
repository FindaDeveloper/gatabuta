package dohun.kim.gatabuta.gatabuta_livedata

import org.junit.Assert.assertEquals
import org.junit.Assert.fail

suspend fun <T : CharSequence> LiveDataTest<T>.isBlank() {
    if (value()?.isNotBlank() == true) {
        fail()
    }
}

suspend infix fun <T : CharSequence> LiveDataTest<T>.hasLength(expected: Int?) {
    assertEquals(expected, value()?.length)
}

suspend fun <T : CharSequence> LiveDataTest<T>.isEmpty() {
    if (value()?.isNotEmpty() == true) {
        fail()
    }
}

