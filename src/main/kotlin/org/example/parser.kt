package org.example


class Parser(input: String) {

    private val tokenizer = Tokenizer(input)

    private var currentToken: Token = tokenizer.nextToken()

    private fun nextToken(): Token {
        val next = tokenizer.nextToken()
        currentToken = next
        return next
    }

    fun parse(): Program {
        return parseProgram()
    }

    /* Program => { statement } */
    private fun parseProgram(): Program {
        val statements = mutableListOf<Statement>()
        while (currentToken !is EOFToken) {
            /* nullのチェック必要?? */
            statements.add(parseStatement())
            nextToken()
        }
        return Program(statements)
    }

    private fun parseStatement(): Statement {
        return when (currentToken) {
            is LetToken -> {
                parseLetStatement()
            }
            is ReturnToken -> {
                parseReturnStatement()
            }
            else -> {
                TODO("Implement")
            }
        }
    }

    private fun parseReturnStatement(): ReturnStatement {
        TODO("return")
    }

    private fun parseLetStatement(): LetStatement {
        return when (val letToken = currentToken) {
            is LetToken -> {
                when (val identifierToken = nextToken()) {
                    is IdentifierToken -> {
                        LetStatement(
                            letToken,
                            Identifier(identifierToken, identifierToken.literal.toInt()),
                            /* TODO implement expression */
                            null as Expression
                        )
                    }
                    else -> error("unexpected token")
                }
            }
            else -> error("unexpected token")
        }
    }
}