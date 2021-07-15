package dohun.kim.gatabuta.gatabuta_livedata

import org.junit.Assert
import org.junit.Assert.fail

suspend infix fun <T : Collection<*>> LiveDataTest<T>.hasSize(expected: Int?) {
    Assert.assertEquals(expected, value()?.size)
}

suspend fun <T : Collection<*>> LiveDataTest<T>.isEmpty() {
    if (value()?.isNotEmpty() == true) {
        fail()
    }
}

suspend fun <T: Collection<*>> LiveDataTest<T>.isNotEmpty() {
    if (value()?.isEmpty() == true) {
        fail()
    }
}