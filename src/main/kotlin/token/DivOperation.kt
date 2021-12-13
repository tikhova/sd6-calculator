package token

class DivOperation: Operation() {
    override fun getPriority(): Int {
        return 2
    }

    override fun apply(a: Long, b: Long): Long {
        return a / b
    }

    override fun toString(): String {
        return "DIV"
    }
}