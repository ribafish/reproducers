package com.example.junittest

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class StringUtilsInstrumentationTest {

    @Test
    fun reverseString() {
        assertEquals("cba", "abc".reversed())
        assertEquals("", "".reversed())
    }

    @Test
    fun uppercaseString() {
        assertEquals("HELLO", "hello".uppercase())
        assertEquals("HELLO WORLD", "hello world".uppercase())
    }

    @Test
    fun trimString() {
        assertEquals("hello", "  hello  ".trim())
        assertEquals("", "   ".trim())
    }

    @Test
    fun containsSubstring() {
        assertTrue("hello world".contains("world"))
        assertTrue("abcdef".contains("cde"))
    }
}
