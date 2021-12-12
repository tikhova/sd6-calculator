package token

class SubOperation: Operation() {
    override fun getPriority(): Int {
        return 1
    }

    override fun toString(): String {
        return "MINUS"
    }
}