package token

import visitor.TokenVisitor

class NumberToken(private val number: Long) : Token {
    fun getValue(): Long {
        return number
    }

    override fun toString(): String {
        return "NUMBER($number)"
    }

    override fun accept(visitor: TokenVisitor) {
        visitor.visit(this)
    }
}