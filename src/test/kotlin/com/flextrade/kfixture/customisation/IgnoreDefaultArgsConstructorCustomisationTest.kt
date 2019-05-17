package com.flextrade.kfixture.customisation

import com.flextrade.kfixture.KFixture
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class IgnoreDefaultArgsConstructorCustomisationTest {

    @Test
    fun `should use constructor ignoring default arguments`() {
        val kFixture = KFixture {
            add(IgnoreDefaultArgsConstructorCustomisation())
        }

        val fixture = kFixture<Defaulted>()

        assertNotNull(fixture.id)
    }
}

data class Defaulted(val id: String? = null)
