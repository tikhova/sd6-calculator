import tokenizer.Tokenizer
import visitor.ParserVisitor
import visitor.PrintVisitor

fun main(args: Array<String>) {
    val expression = args.joinToString("")
    try {
        val state = Tokenizer().tokenize(expression)
        val reversePolishNotation = ParserVisitor(state.getTokens()).getReversePolishNotation()
        PrintVisitor(reversePolishNotation).printExpression()
    } catch (e: Exception) {
        print(e)
    }
}