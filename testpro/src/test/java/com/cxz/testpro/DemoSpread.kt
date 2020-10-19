package com.cxz.testpro


fun <T> getName(value: T, bock: (T) -> T) {
    bock
}