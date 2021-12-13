package token

class AddOperation: Operation() {
    override fun getPriority(): Int {
        return 1
    }

    override fun apply(a: Long, b: Long): Long {
        return a + b
    }

    override fun toString(): String {
        return "PLUS"
    }
}