package tokenizer

import token.NumberToken
import token.Token

class NumberState(digit: Char, private val tokens: MutableList<Token>): State {
    private val numberStringBuilder: StringBuilder = StringBuilder().append(digit)

    override fun consume(c: Char): State {
        if (Character.isDigit(c)) {
            numberStringBuilder.append(c)

            return this
        } else {
            val value: Long = numberStringBuilder.toString().toLong()
            tokens.add(NumberToken(value))

            val newState = StartState(tokens)
            newState.consume(c)

            return newState
        }
    }

    override fun getTokens(): List<Token> {
        return tokens
    }
}