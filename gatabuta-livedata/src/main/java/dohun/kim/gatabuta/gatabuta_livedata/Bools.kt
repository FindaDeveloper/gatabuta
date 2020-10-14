package dohun.kim.gatabuta.gatabuta_livedata

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue

fun LiveDataTest<Boolean>.isTrue() {
    assertTrue(value)
}

fun LiveDataTest<Boolean>.isFalse() {
    assertFalse(value)
}
