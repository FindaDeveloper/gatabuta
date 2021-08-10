package kr.co.finda.finda.gatabuta

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue

suspend fun LiveDataTest<Boolean>.isTrue() {
    assertTrue(value() == true)
}

suspend fun LiveDataTest<Boolean>.isFalse() {
    assertFalse(value() == true)
}
