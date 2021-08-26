package kr.co.finda.finda.gatabuta

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.fail

suspend infix fun <T : Collection<*>> LiveDataTest<T>.hasSize(expected: Int?) {
    assertEquals(expected, value()?.size)
}

suspend fun <T : Collection<*>> LiveDataTest<T>.isEmpty() {
    if (value()?.isNotEmpty() == true) {
        fail("")
    }
}

suspend fun <T : Collection<*>> LiveDataTest<T>.isNotEmpty() {
    if (value()?.isEmpty() == true) {
        fail("")
    }
}
