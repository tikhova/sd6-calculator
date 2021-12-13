package token

import visitor.TokenVisitor

abstract class Operation: Token {
    override fun accept(visitor: TokenVisitor) {
        visitor.visit(this)
    }

    abstract fun getPriority(): Int

    abstract fun apply(a: Long, b: Long): Long
}