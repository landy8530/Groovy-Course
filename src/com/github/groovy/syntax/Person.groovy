package com.github.groovy.syntax

/**
 * @author landyl* @create 14:12 06/18/2020
 * Groovydoc follows the same conventions as Java’s own Javadoc.
 * So you’ll be able to use the same tags as with Javadoc.
 */
/**
 * A Class description
 */
class Person {
    /** the name of the person */
    String name

    /**
     * Creates a greeting method for a certain person.
     *
     * @param otherPerson the person to greet
     * @return a greeting message
     */
    String greet(String otherPerson) {
        "Hello ${otherPerson}"
    }
}

