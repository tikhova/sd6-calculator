package visitor

import token.Brace
import token.NumberToken
import token.Operation
import token.Token
import java.util.*


class CalcVisitor(private val tokens: List<Token>): TokenVisitor {
    private val stack = Stack<Long>()

    fun calculateResult(): Long {
        if (stack.size != 1) {
            tokens.forEach { token -> token.accept(this) }

            if (stack.size != 1) {
                throw Exception("Invalid reverse polish expression")
            }
        }

        return stack.firstElement()
    }

    override fun visit(token: NumberToken) {
        stack.push(token.getValue())
    }

    override fun visit(token: Brace) {
        throw Exception("Unexpected brace in reverse polish notation")
    }

    override fun visit(token: Operation) {
        if (stack.size < 2) {
            throw Exception("Invalid reverse polish expression")
        }

        val a = stack.pop()
        val b = stack.pop()
        stack.push(token.apply(b, a))
    }
}