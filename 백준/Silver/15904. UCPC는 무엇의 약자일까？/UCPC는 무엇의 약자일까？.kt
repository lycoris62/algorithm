fun main() {
    val str = readln()
    val arr = charArrayOf('U', 'C', 'P', 'C')
    var idx = 0;

    for (ch in str) {
        if (ch == arr[idx]) {
            idx++
        }

        if (idx == arr.size) {
            println("I love UCPC")
            return
        }
    }

    println("I hate UCPC")
}