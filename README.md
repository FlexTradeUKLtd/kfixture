# KFixture

KFixture is a Kotlin wrapper around [JFixture](https://github.com/FlexTradeUKLtd/jfixture).

[![Build Status](https://travis-ci.org/FlexTradeUKLtd/kfixture.svg)](https://travis-ci.org/FlexTradeUKLtd/kfixture)

## Usage

Import it into maven as so:

```xml
<dependency>
	<groupId>com.flextrade.jfixture</groupId>
	<artifactId>kfixture</artifactId>
	<version>1.0.0</version>
	<scope>test</scope>
</dependency>
```

Create an instance, and invoke it to create fixtured values:

```kotlin
val kFixture = KFixture()

val integer = kFixture<Int>()
val myObject: SomeObject = kFixture()
```

### Numerical Ranges

To create a range for integers, call `.intRange(..)`. However, the upper limit is exclusive. 
The example below creates an integer fixture between 0 and 4:

```kotlin
val integer = kFixture.intRange(0..5)
```

### Customisation

To customise your KFixture, just pass a body as a parameter:

```kotlin
val kFixture = KFixture {
    circularDependencyBehaviour().omitSpecimen()
}
``` 

#### Ignoring default arguments on constructors

```kotlin
val kFixture = KFixture {
    add(IgnoreDefaultArgsConstructorCustomisation())
}
```

To fixture classes where every argument has a default value, use this customisation. This will apply to all fixtures generated using this instance.
