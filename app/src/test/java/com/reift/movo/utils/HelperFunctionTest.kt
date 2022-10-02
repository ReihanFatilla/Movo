package com.reift.movo.utils

import org.junit.Assert.assertEquals
import org.junit.Test

internal class HelperFunctionTest {

    @Test
    fun durationFormatter() {
        val min = 90
        assertEquals("1h 30min", HelperFunction.durationFormatter(min))
    }

    @Test
    fun dateFormatter() {
    }

    @Test
    fun monthNameGenerator() {
        val month = "12"
        assertEquals("December", HelperFunction.monthNameGenerator(month))
    }
}