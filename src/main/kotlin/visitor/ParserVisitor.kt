package visitor

import token.*
import java.util.*


class ParserVisitor(private val tokens: List<Token>): TokenVisitor {
    private val expression = mutableListOf<Token>()
    private val operationStack = Stack<Token>()

    fun getReversePolishNotation(): List<Token> {
        if (expression.isEmpty() && tokens.isNotEmpty()) {
            tokens.forEach { token -> token.accept(this) }
        }

        while (operationStack.isNotEmpty()) {
            if (operationStack.peek() is Brace) {
                throw Exception("Incorrectly placed braces")
            }
            expression.add(operationStack.pop());
        }

        return expression
    }

    override fun visit(token: NumberToken) {
        expression.add(token)
    }

    override fun visit(token: Brace) {
        if (token.isOpening()) {
            operationStack.add(token)
        } else {
            while (!(operationStack.last() is Brace && (operationStack.last() as Brace).isOpening())) {
                expression.add(operationStack.removeLast())
            }

            if (operationStack.last() is Brace) {
                operationStack.removeLast()
            } else {
                throw Exception("Incorrectly placed braces")
            }
        }
    }

    override fun visit(token: Operation) {
        while (operationStack.isNotEmpty()) {
            val last: Token = operationStack.peek()

            if (last is Operation && last.getPriority() >= token.getPriority()) {
                expression.add(operationStack.pop())
            } else {
                break
            }
        }

        operationStack.add(token)
    }
}