package dohun.kim.gatabuta

import org.mockito.Mockito.*

sealed class Interactions {

    object NoInteraction : Interactions()
    object NoMoreInteraction : Interactions()
}

val noInteraction = Interactions.NoInteraction
val noMoreInteraction = Interactions.NoMoreInteraction

infix fun <T> T.verifyFor(method: T.() -> Unit) {
    verify(this).apply(method)
}

infix fun <T> T.verifyFor(interactions: Interactions) {
    when (interactions) {
        is Interactions.NoInteraction -> verifyNoInteractions(this)
        is Interactions.NoMoreInteraction -> verifyNoMoreInteractions(this)
    }
}