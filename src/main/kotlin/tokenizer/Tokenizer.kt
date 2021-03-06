package tokenizer

class Tokenizer {
    fun tokenize(expression: String): State {
        var state: State = StartState(mutableListOf())

        for (c in expression + '\n') {
            state = state.consume(c)
        }

        if (state !is EndState) {
            throw Exception("Could not reach the end of the expression")
        }

        return state
    }
}