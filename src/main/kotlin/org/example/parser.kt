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
        val letToken = assertCurrentToken<LetToken>()
        val identifierToken = assertNextToken<IdentifierToken>()
        assertNextToken<AssignToken>()
        val intToken = assertNextToken<IntToken>()
        return LetStatement(
            letToken,
            Identifier(identifierToken, identifierToken.literal)
            /* TODO implement expression */
        )
    }

    private fun parseExpression(): Expression {

    }

    /* utilities */

    private inline fun <reified T> assertCurrentToken(): T {
        return assertTokenIs(currentToken)
    }

    private inline fun <reified T> assertNextToken(): T {
        return assertTokenIs(nextToken())
    }

    private inline fun <reified T> assertTokenIs(token: Token): T {
        if (token is T) {
            return token
        } else {
            error("not expected token ${token.kind} ${token.literal}")
        }
    }
}