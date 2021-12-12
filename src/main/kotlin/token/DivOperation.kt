package token

class DivOperation: Operation() {
    override fun getPriority(): Int {
        return 2
    }

    override fun toString(): String {
        return "DIV"
    }
}