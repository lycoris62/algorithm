import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val a = nextInt()
    val b = nextInt()
    when {
        a == b -> println("==")
        a < b -> println("<")
        else -> println(">")
    }
}