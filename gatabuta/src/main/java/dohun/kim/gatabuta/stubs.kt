package dohun.kim.gatabuta

import org.mockito.Mockito.`when`

infix fun <T> T.returns(value: T?) {
    `when`(this).thenReturn(value)
}