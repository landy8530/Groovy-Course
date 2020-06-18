package com.github.groovy.syntax

/**
 * @author landyl* @create 14:16 06/18/2020
 */
class HelloWorld {
    def number = 3.14

    static void main(String[] args) {
        def map = [:]

        map."an identifier with a space and double quotes" = "ALLOWED"
        // Single-quoted strings are plain java.lang.String and don’t support interpolation.
        // Double-quoted strings are plain java.lang.String if there’s no interpolated expression,
        // but are groovy.lang.GString instances if interpolation is present.
        map.'with-dash-signs-and-single-quotes' = "ALLOWED"

        assert map."an identifier with a space and double quotes" == "ALLOWED"
        assert map.'with-dash-signs-and-single-quotes' == "ALLOWED"

        //All the Groovy strings can be concatenated with the + operator:
        assert 'ab' == 'a' + 'b'

        def aMultilineString = '''line one
                                line two
                                line three'''


        System.out.println("==============================")

        println('an escaped single quote: \' needs a backslash')
        println('an escaped escape character: \\ needs a double backslash')
        println('The Euro currency symbol: \u20AC')

        //The placeholder expressions are surrounded by ${}
        def name = 'Guillaume' // a plain string
        def greeting = "Hello ${name}"

        assert greeting.toString() == 'Hello Guillaume'

        def sum = "The sum of 2 and 3 equals ${2 + 3}"
        assert sum.toString() == 'The sum of 2 and 3 equals 5'

        /**
         * Not only are expressions allowed in between the ${} placeholder, but so are statements. However,
         * a statement’s value is just null. So if several statements are inserted in that placeholder,
         * the last one should somehow return a meaningful value to be inserted. For instance,
         * "The sum of 1 and 2 is equal to ${def a = 1; def b = 2; a + b}" is supported and
         * works as expected but a good practice is usually to stick to simple expressions inside GString placeholders.
         */
        //In addition to ${} placeholders, we can also use a lone $ sign prefixing a dotted expression:
        def person = [name: 'Guillaume', age: 36]
        assert "$person.name is $person.age years old" == 'Guillaume is 36 years old'

//        HelloWorld hw = new HelloWorld();
//        hw.shouldFail(new MissingPropertyException(""))
        shouldFail(new MissingPropertyException(""))

        // If you need to escape the $ or ${} placeholders in a GString so they appear as is without interpolation,
        // you just need to use a \ backslash character to escape the dollar sign:
        assert '$5' == "\$5"
        assert '${name}' == "\${name}"


    }


    //You can think of "$number.toString()" as being interpreted by the parser as "${number.toString}()".
    def static shouldFail(MissingPropertyException) {
        println "${number.toString()}"

        String thing = 'treasure'
//        assert 'The x-coordinate of the treasure is represented by treasure.x' ==
//                "The x-coordinate of the $thing is represented by $thing.x"   // <= Not allowed: $thing.x ambiguous!!
        assert 'The x-coordinate of the treasure is represented by treasure.x' ==
                "The x-coordinate of the $thing is represented by ${thing}.x"  // <= Curly braces required
    }
}
