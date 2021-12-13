import tokenizer.Tokenizer
import visitor.CalcVisitor
import visitor.ParserVisitor
import visitor.PrintVisitor

fun main() {
    val expression = readLine() + ""
    try {
        val state = Tokenizer().tokenize(expression)
        val tokens = state.getTokens()
        val reversePolishNotation = ParserVisitor(state.getTokens()).getReversePolishNotation()
        PrintVisitor(reversePolishNotation).printExpression()
        val result = CalcVisitor(reversePolishNotation).calculateResult()
        println(result)
    } catch (e: Exception) {
        print(e)
    }
}