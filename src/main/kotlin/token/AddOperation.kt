package token

class AddOperation: Operation() {
    override fun getPriority(): Int {
        return 1
    }

    override fun toString(): String {
        return "PLUS"
    }
}