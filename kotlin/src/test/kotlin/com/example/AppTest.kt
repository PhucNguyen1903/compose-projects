package com.example

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringUtilsTest {
    @Test
    fun `test string reversal`() {
        val stringUtils = StringUtils()
        assertEquals("olleh", stringUtils.reverse("hello"), "Should reverse 'hello' to 'olleh'")
        assertEquals("", stringUtils.reverse(""), "Empty string should return empty")
        assertEquals("a", stringUtils.reverse("a"), "Single character should remain the same")
    }
}
