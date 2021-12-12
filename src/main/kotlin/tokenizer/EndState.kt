package tokenizer

import token.Token

class EndState(private val tokens: MutableList<Token>) : State {
    override fun consume(c: Char): State {
        return this
    }

    override fun getTokens(): List<Token> {
        return tokens
    }
}