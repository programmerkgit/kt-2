package org.example

import org.junit.Assert.assertEquals
import org.junit.Test

class TestParser {
    @Test
    fun testLetStatement() {
        val input = "let x = 5"
        val program = Parser(input).parse()
        assertEquals(program.statements.size, 1)
    }
}