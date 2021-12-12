package token

import visitor.TokenVisitor

class Brace(private val opening: Boolean): Token {
    override fun toString(): String {
        return if (opening) "LEFT" else "RIGHT"
    }

    override fun accept(visitor: TokenVisitor) {
        visitor.visit(this)
    }

    fun isOpening(): Boolean {
        return opening
    }
}