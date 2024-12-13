import java.util.*

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val x = st.nextToken().toInt()

    val arr: IntArray = readln().split(" ").map { it.toInt() }.toIntArray()

    val sb = StringBuilder()

    for (i in arr) {
        if (i < x) {
            sb.append(i).append(" ")
        }
    }

    println(sb)
}