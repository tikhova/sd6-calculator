import tokenizer.Tokenizer

fun main(args: Array<String>) {
    val expression = args.joinToString("")
    val state = Tokenizer().tokenize(expression)
    println(state.getTokens().joinToString(" ") { token -> token.toString() })
    println(state.getError())
}