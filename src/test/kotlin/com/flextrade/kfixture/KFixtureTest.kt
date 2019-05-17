package com.flextrade.kfixture

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class KFixtureTest {
    private val kFixture = KFixture()

    private val intLowerRange = 5
    private val intUpperRange = 10
    private val doubleLowerRange = 1.0
    private val doubleUpperRange = 5.0

    @Test
    fun `range should produce a floating point number between the lower and upper bound (exclusive)`() {
        val fixture = kFixture.range(doubleLowerRange..doubleUpperRange)

        assertTrue { doubleLowerRange <= fixture && fixture < doubleUpperRange }
    }

    @Test
    fun `range should produce a integer number between the lower and upper bound (exclusive)`() {
        val fixture = kFixture.range(intLowerRange..intUpperRange)

        assertTrue { fixture in intLowerRange..(intUpperRange - 1) }
    }

    data class FirstObject(val cyclicReference: SecondObject?)

    data class SecondObject(val cyclicReference: FirstObject?)

    @Test
    fun `kFixture should be able to resolve cyclic references once customised to omit the specimen`() {
        val kFixture = KFixture {
            circularDependencyBehaviour().omitSpecimen()
        }

        val objectFixture = kFixture<FirstObject>()

        assertNotNull(objectFixture)
        assertNotNull(objectFixture.cyclicReference)
        assertNull(objectFixture.cyclicReference!!.cyclicReference)
    }

}
