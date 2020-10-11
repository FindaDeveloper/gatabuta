package dohun.kim.gatabuta

import org.mockito.Mockito.verify

infix fun <T> T.verifyFor(method: T.() -> Unit) {
    verify(this).apply(method)
}