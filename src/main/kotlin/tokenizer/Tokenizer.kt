package tokenizer

class Tokenizer {
    fun tokenize(expression: String): State {
        var state: State = StartState(mutableListOf())

        for (c in expression + '\u0000') {
            state = state.consume(c)
        }

        return state
    }
}