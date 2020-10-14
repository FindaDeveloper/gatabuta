package dohun.kim.gatabuta.gatabuta_livedata

import org.junit.Assert.assertEquals
import org.junit.Assert.fail

fun <T: CharSequence> LiveDataTest<T>.isBlank() {
    if (!value.isBlank()) {
        fail()
    }
}

infix fun <T : CharSequence> LiveDataTest<T>.hasLength(expected: Int?) {
    assertEquals(expected, value.length)
}

fun <T: CharSequence> LiveDataTest<T>.isEmpty() {
    if (value.isNotEmpty()) {
        fail()
    }
}

