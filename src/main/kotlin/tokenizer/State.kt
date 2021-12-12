package tokenizer

import token.Token

interface State {
    fun isEOF(): Boolean
    fun getError(): Exception?
    fun consume(c: Char): State
    fun getTokens(): List<Token>
}