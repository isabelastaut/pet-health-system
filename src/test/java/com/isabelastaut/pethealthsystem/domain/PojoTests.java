package com.isabelastaut.pethealthsystem.domain;

import org.junit.jupiter.api.Test;
import pl.pojo.tester.api.assertion.Method;

import static pl.pojo.tester.api.FieldPredicate.exclude;
import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsFor;

class PojoTests {

    @Test
    public void testPojo() {
        final Class<?>[] classesUnderTest = {
                Owner.class,
                VaccinationCard.class};

        for (Class<?> classUnderTest : classesUnderTest) {
            assertPojoMethodsFor(classUnderTest, exclude("id")).testing(Method.GETTER, Method.SETTER, Method.CONSTRUCTOR).areWellImplemented();
        }
    }
}