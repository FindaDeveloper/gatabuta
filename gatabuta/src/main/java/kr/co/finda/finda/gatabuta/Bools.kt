package kr.co.finda.finda.gatabuta

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue

suspend fun LiveDataTest<Boolean>.isTrue() {
    assertTrue(value() == true)
}

suspend fun LiveDataTest<Boolean>.isFalse() {
    assertFalse(value() == true)
}
