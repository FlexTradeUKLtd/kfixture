package com.flextrade.kfixture.utility.query

import com.flextrade.jfixture.ConstructorQuery
import com.flextrade.jfixture.utility.comparators.ConstructorParameterCountComparator
import java.lang.reflect.Constructor

class MostParameterConstructorQuery: ConstructorQuery {
    override fun getConstructorsForClass(clazz: Class<*>): List<Constructor<*>> =
            listOf(clazz.constructors
                    .filter(::doesNotHaveDefaultConstructorMarkerAsArgument)
                    .sortedWith(ConstructorParameterCountComparator())
                    .last())

    /*
    Kotlin generates a constructor with DefaultConstructorMarker as a parameter
    which often has more parameters than any other genuinely useful constructors
     */
    private fun doesNotHaveDefaultConstructorMarkerAsArgument(constructor: Constructor<*>) =
            constructor.parameters.none { it.type.canonicalName.contains("DefaultConstructorMarker") }

}
