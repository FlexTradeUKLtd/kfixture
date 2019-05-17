package com.flextrade.kfixture.utility.query

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MostParameterConstructorQueryTest {

    @Test
    fun `getConstructorsForClass should return list with one element`() {
        val constructors = MostParameterConstructorQuery().getConstructorsForClass(Object::class.java)

        assertEquals(1, constructors.size)
    }

    @Test
    fun `getConstructorsForClass should return constructor with most parameters`() {
        val constructors = MostParameterConstructorQuery().getConstructorsForClass(ManyConstructors::class.java)

        assertEquals(3, constructors.first().parameters.size)
    }

    @Test
    fun `getConstructorsForClass should exclude constructors with DefaultConstructorMarker as parameter`() {
        val constructors = MostParameterConstructorQuery().getConstructorsForClass(WithBadConstructor::class.java)

        assertEquals(1, constructors.first().parameters.size)
    }
}

class ManyConstructors(val a: String, val b: String) {
    constructor() : this("a", "b")

    constructor(b: String): this("a", b)

    constructor(a: String, b: String, c: String): this(a, b)
}

class DefaultConstructorMarker

class WithBadConstructor(val a: String) {
    constructor() : this("a")

    constructor(b: DefaultConstructorMarker): this("a")
}
