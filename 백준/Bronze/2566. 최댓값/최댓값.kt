import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    var max : Int = Int.MIN_VALUE
    var row : Int = 0
    var col: Int = 0

    for (i in 1..9) {
        val st = StringTokenizer(readLine())
        for (j in 1..9) {
            val x: Int = st.nextToken().toInt()
            if (x > max) {
                max = x
                row = i
                col = j
            }
        }
    }

    println(max)
    println("$row $col")
}