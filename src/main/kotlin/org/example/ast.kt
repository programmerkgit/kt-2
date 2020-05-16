package org.example


interface Node {
    fun tokenLiteral(): String
    override fun toString(): String
}

interface Statement : Node {
    fun statementNode()
}

interface Expression : Node {
    fun expressionNode()
}

class Program(val statements: List<Statement>) : Node {
    override fun tokenLiteral(): String {
        return if (statements.isEmpty()) {
            statements.first().tokenLiteral()
        } else {
            ""
        }
    }

    override fun toString(): String {
        return statements.joinToString("")
    }
}

class LetStatement(
    private val token: LetToken,
    val name: Identifier,
    val value: Expression?
) : Statement {
    override fun statementNode() {
    }

    override fun tokenLiteral(): String {
        return token.literal
    }

    override fun toString(): String {
        return "${tokenLiteral()} $name = ${value ?: ""};"
    }

}

class ReturnStatement(
    private val token: ReturnToken,
    private val returnValue: Expression
) : Statement {
    override fun statementNode() {
    }

    override fun tokenLiteral(): String {
        return token.literal
    }

    override fun toString(): String {
        return "${tokenLiteral()} $returnValue;"
    }
}

class ExpressionStatement(
    private val token: Token,
    private val expression: Expression? = null
) : Statement {
    override fun statementNode() {
        TODO("Not yet implemented")
    }

    override fun tokenLiteral(): String {
        return token.literal
    }

    override fun toString(): String {
        return "${expression?.toString()}"
    }

}

class BlockStatement(
    val token: Token,
    val statements: List<Statement>
) : Statement {
    override fun statementNode() {
        TODO("Not yet implemented")
    }

    override fun tokenLiteral(): String {
        return token.literal
    }

    override fun toString(): String {
        TODO("Not yet implemented")
    }
}

class Identifier(
    val token: IdentifierToken,
    val value: Int
) : Node {
    override fun tokenLiteral(): String {
        return token.literal
    }

    override fun toString(): String {
        return value.toString()
    }

    fun expressionNode() {

    }
}

class BooleanNode(val token: Token, val value: Boolean) : Node {
    override fun tokenLiteral(): String {
        return token.literal
    }

    override fun toString(): String {
        TODO("Not yet implemented")
    }

}

class IntegerLiteral(
    val token: Token,
    val value: Int
) : Node {
    override fun tokenLiteral(): String {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        TODO("Not yet implemented")
    }

}

