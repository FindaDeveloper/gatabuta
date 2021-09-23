package kr.co.finda.finda.gatabuta

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.fail

suspend fun <T : CharSequence> LiveDataTest<T>.isBlank() {
    val value = value()
    if (value?.isNotBlank() == true) {
        fail("Value is not blank, value=$value")
    }
}

suspend infix fun <T : CharSequence> LiveDataTest<T>.hasLength(expected: Int?) {
    assertEquals(expected, value()?.length)
}

suspend fun <T : CharSequence> LiveDataTest<T>.isEmpty() {
    val value = value()
    if (value?.isNotEmpty() == true) {
        fail("Value is not empty, value=$value")
    }
}

