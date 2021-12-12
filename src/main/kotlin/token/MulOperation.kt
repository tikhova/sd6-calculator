package token

class MulOperation: Operation() {
    override fun getPriority(): Int {
        return 2
    }

    override fun toString(): String {
        return "MUL"
    }
}