package kr.co.finda.finda.gatabuta

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.fail

suspend infix fun <T : Collection<*>> LiveDataTest<T>.hasSize(expected: Int?) {
    assertEquals(expected, value()?.size)
}

suspend fun <T : Collection<*>> LiveDataTest<T>.isEmpty() {
    val value = value()
    if (value?.isNotEmpty() == true) {
        fail("Value is not empty, value=$value")
    }
}

suspend fun <T: Collection<*>> LiveDataTest<T>.isNotEmpty() {
    val value = value()
    if (value?.isEmpty() == true) {
        fail("Value is empty, value=$value")
    }
}