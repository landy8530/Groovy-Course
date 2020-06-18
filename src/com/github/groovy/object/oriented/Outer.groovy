package com.github.groovy.object.oriented

/**
 * @author landyl* @create 14:09 06/18/2020
 */
class Outer {

    private String privateStr

    def callInnerMethod() {
        new Inner().methodA()
    }

    class Inner {
        def methodA() {
            println "${privateStr}."
        }
    }

}
