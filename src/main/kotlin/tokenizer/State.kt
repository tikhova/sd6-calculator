package tokenizer

import token.Token

interface State {
    fun consume(c: Char): State
    fun getTokens(): List<Token>
}