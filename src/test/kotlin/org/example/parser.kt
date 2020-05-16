package org.example

import org.junit.Assert.assertEquals
import org.junit.Test

class TestParser {
    @Test
    fun testLetStatement() {
        val input = """
let x = 5
let y = 6            
        """.trimMargin()
        val program = Parser(input).parse()
        assertEquals(program.statements.size, 2)
        val statement = program.statements[0] as LetStatement
        assertEquals(statement.name.value,"x")
    }
}