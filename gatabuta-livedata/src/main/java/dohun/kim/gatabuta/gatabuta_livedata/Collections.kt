package dohun.kim.gatabuta.gatabuta_livedata

import org.junit.Assert
import org.junit.Assert.fail

infix fun <T : Collection<*>> LiveDataTest<T>.hasSize(expected: Int?) {
    Assert.assertEquals(expected, value.size)
}

fun <T : Collection<*>> LiveDataTest<T>.isNullOrEmpty() {
    if (!value.isNullOrEmpty()) {
        fail()
    }
}

fun <T : Collection<*>> LiveDataTest<T>.isEmpty() {
    if (!value.isEmpty()) {
        fail()
    }
}

fun <T: Collection<*>> LiveDataTest<T>.isNotEmpty() {
    if (value.isEmpty()) {
        fail()
    }
}