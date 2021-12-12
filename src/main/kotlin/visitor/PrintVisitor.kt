package visitor

import token.Brace
import token.NumberToken
import token.Operation
import token.Token

class PrintVisitor(private val tokens: List<Token>): TokenVisitor {
    private val tokenStrings: ArrayList<String> = arrayListOf()

    fun printExpression() {
        if (tokenStrings.isEmpty() && tokens.isNotEmpty()) {
            tokens.forEach { token -> token.accept(this) }
        }

        println(tokenStrings.joinToString(" "))
    }

    override fun visit(token: NumberToken) {
        tokenStrings.add(token.toString())
    }

    override fun visit(token: Brace) {
        tokenStrings.add(token.toString())
    }

    override fun visit(token: Operation) {
        tokenStrings.add(token.toString())
    }
}