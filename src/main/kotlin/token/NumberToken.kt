package token

import visitor.TokenVisitor

class NumberToken(private val number: Long) : Token {
    override fun toString(): String {
        return "NUMBER($number)"
    }

    override fun accept(visitor: TokenVisitor) {
        visitor.visit(this)
    }
}