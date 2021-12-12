package tokenizer

import token.*

class StartState(private val tokens: MutableList<Token>): State {
    override fun consume(c: Char): State {
        when (c) {
            '(' -> tokens.add(Brace(true))
            ')' -> tokens.add(Brace(false))
            '+' -> tokens.add(AddOperation())
            '-' -> tokens.add(SubOperation())
            '*' -> tokens.add(MulOperation())
            '/' -> tokens.add(DivOperation())
            '\u0000' -> return EndState(tokens)
            ' ' -> return this
            else ->  return if (c.isDigit()) NumberState(c, tokens) else ErrorState(c, tokens)
        }

        return this
    }

    override fun getTokens(): List<Token> {
        return tokens
    }
}