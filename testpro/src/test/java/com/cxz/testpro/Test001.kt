package com.cxz.testpro

import org.junit.Test

class Test001 {

    @Test
    fun mainTest() {
        var name = "100"
        getName(name) {
            it.replaceAfterLast("1", "qq")
        }
        print(name)
    }
}