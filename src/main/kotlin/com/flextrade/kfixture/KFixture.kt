package com.flextrade.kfixture

import com.flextrade.jfixture.FluentCustomisation
import com.flextrade.jfixture.JFixture
import com.flextrade.jfixture.customisation.Customisation

class KFixture(val jFixture: JFixture = JFixture(), customiser: FluentCustomisation.() -> Unit = { }) : FluentCustomisation by jFixture.customise() {
    init {
        customiser(this)
    }

    inline operator fun <reified T> invoke(): T {
        return jFixture.create(T::class.java)
    }

    inline fun <reified T> range(range: ClosedRange<T>): T
            where T : Number,
                  T : Comparable<T> =
            jFixture.create().inRange(T::class.java, range.start, range.endInclusive)!!

    fun customise(customisation: Customisation): KFixture {
        jFixture.customise(customisation)
        return this
    }
}
