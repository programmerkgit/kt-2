package org.example

enum class TokenKind {
    /* SPECIAL */
    EOF, //end of file
    ILLEGAL, // not recognized

    /* Noramal */
    IDENTIFIER, //
    INT, //

    /* Delimiters */
    LPAREN,//(
    RPAREN,//)
    LBRACE, // {
    RBRACE, // }
    COMMA, //,
    SEMICOLON, //;

    /* Op */
    ASSIGN, // =

    /* Operators */
    PLUS, // +
    MINUS, // -
    MULTI, // *
    DIV, // /
    BANG, // !

    /* MATH */
    LSS, //<
    GRT, //>
    LSSEQ, //<=
    GRTEQ, //>=
    EQUAL, // ==
    NOTEQ, // !=

    /* KEYWORDS */
    FUNCTION, // fn,
    RETURN, // return

    /* DEC */
    VAR, //var
    LET, //let
    CONST, //const
    VAL, // val

    /* SENTENCE */
    IF, // if
    ELSE, // else
    WHILE, // while,
    WHEN, //when,
    THEN, // then

    /* BOOL */
    TRUE, //true
    FALSE, // false
}

open class Token(
    val kind: TokenKind,
    val literal: String
) {
    override fun toString(): String {
        return "{Kind: ${kind}: Literal: $literal}"
    }
}

class IllegalToken(value: String) : Token(TokenKind.ILLEGAL, value)
class EOFToken() : Token(TokenKind.EOF, "")
class IdentifierToken(value: String) : Token(TokenKind.IDENTIFIER, value)
class IntToken(value: String) : Token(TokenKind.INT, value)

/* Math */
class PlusToken() : Token(TokenKind.PLUS, "+")
class MinusToken() : Token(TokenKind.MINUS, "-")
class MultiToken() : Token(TokenKind.MULTI, "*")
class DivToken() : Token(TokenKind.DIV, "/")
class BangToken() : Token(TokenKind.BANG, "!")

/* Op */
class AssignToken() : Token(TokenKind.ASSIGN, "=")

/* DelimiterToken */
class LParenToken() : Token(TokenKind.LPAREN, "(")
class RParentToken() : Token(TokenKind.RPAREN, ")")
class LBraceToken() : Token(TokenKind.LBRACE, "{")
class RBraceToken() : Token(TokenKind.RBRACE, "}")
class CommaToken() : Token(TokenKind.COMMA, ",")
class SemicolonToken() : Token(TokenKind.SEMICOLON, ";")

/* Comp */
class EqualToken() : Token(TokenKind.EQUAL, "==")
class NotEqToken() : Token(TokenKind.NOTEQ, "!=")
class LssToken() : Token(TokenKind.LSS, "<")
class LssEqToken() : Token(TokenKind.LSSEQ, "<=")
class GrtToken() : Token(TokenKind.GRT, ">")
class GrtEqToken() : Token(TokenKind.GRTEQ, ">=")

/* keywods */
class FuncToken() : Token(TokenKind.FUNCTION, "fn")
class IfToken() : Token(TokenKind.IF, "if")
class WhenToken() : Token(TokenKind.WHEN, "when")
class ElseToken() : Token(TokenKind.ELSE, "else")
class ThenToken() : Token(TokenKind.THEN, "then")
class ReturnToken() : Token(TokenKind.RETURN, "return")
class TrueToken() : Token(TokenKind.TRUE, "true")
class FalseToken() : Token(TokenKind.FALSE, "false")

/* Assign Keyword */
class LetToken() : Token(TokenKind.LET, "let")
class ValToken() : Token(TokenKind.VAL, "val")
class VarToken() : Token(TokenKind.VAL, "var")
class ConstToken() : Token(TokenKind.CONST, "const")