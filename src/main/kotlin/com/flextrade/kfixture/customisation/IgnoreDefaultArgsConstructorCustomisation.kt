package com.flextrade.kfixture.customisation

import com.flextrade.jfixture.JFixture
import com.flextrade.jfixture.builders.ClassToConstructorRelay
import com.flextrade.jfixture.customisation.Customisation
import com.flextrade.jfixture.specifications.AlwaysSpecification
import com.flextrade.kfixture.utility.query.MostParameterConstructorQuery

class IgnoreDefaultArgsConstructorCustomisation: Customisation {

    override fun customise(fixture: JFixture) {
        val mostParameterConstructorRelay = ClassToConstructorRelay(MostParameterConstructorQuery(), AlwaysSpecification())
        fixture.addBuilderToStartOfPipeline(mostParameterConstructorRelay)
    }

}
