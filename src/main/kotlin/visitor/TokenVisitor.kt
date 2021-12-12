package visitor

import token.Brace
import token.NumberToken
import token.Operation
import token.Token

interface TokenVisitor {
    fun visit(token: NumberToken)
    fun visit(token: Brace)
    fun visit(token: Operation)

    fun visit(token: Token) {
        when (token) {
            is NumberToken -> visit(token)
            is Brace -> visit(token)
            is Operation -> visit(token)
            else -> {
                throw Exception("Unexpected token: $token")
            }
        }
    }
}