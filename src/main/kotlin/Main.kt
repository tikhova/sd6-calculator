import tokenizer.Tokenizer
import visitor.PrintVisitor

fun main(args: Array<String>) {
    val expression = args.joinToString("")
    try {
        val state = Tokenizer().tokenize(expression)
        PrintVisitor(state.getTokens()).printExpression()
    } catch (e: Exception) {
        print(e)
    }
}