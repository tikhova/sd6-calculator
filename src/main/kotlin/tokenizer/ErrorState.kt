package tokenizer

import token.Token

class ErrorState(private val c: Char, private val tokens: MutableList<Token>): State {
    override fun isEOF(): Boolean {
        return false
    }

    override fun getError(): Exception {
        return Exception("Met unexpected character $c")
    }

    override fun consume(c: Char): State {
        return this
    }

    override fun getTokens(): List<Token> {
        return tokens
    }
}