import java.util.*

fun main() {
    val st = StringTokenizer(readln())
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()
    
    when {
        a == b -> println("==")
        a < b -> println("<")
        else -> println(">")
    }
}