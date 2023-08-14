import kotlin.math.ln

/**
 * Lista 4 z WpumKJ
 *
 * @author Tomasz Targiel
 */
fun formatResult(name: String, n: Int, f: (Int) -> Int): String {
    val msg = "Wynikiem operacji %s z %d jest: %d"
    return msg.format(name, n, f(n))

//    return ("Wynikiem operacji $name z $n jest: " + f(n))
}

val <T> List<T>.tail: List<T>
    get() = takeLast(this.size - 1)

val <T> List<T>.head: T
    get() = first()

fun main() {
    fun fib(i: Int): Int {
        tailrec fun rec(count: Int, prev: Int, acc: Int): Int {
            return if (count == 0) acc else rec(count-1, acc, acc + prev)
        }

        return rec(i, 1, 0)
    }

    fun log2(i: Int): Int {
        return (ln(i.toDouble()) / ln(2.0)).toInt()
    }

    fun suma(a: Array<Int>): Int {
        return a
            .filter { it >= 0 }
            .reduce { sum, element -> sum + element }
    }

    fun countElements(a: Array<Array<Char>>): Map<Char, Int> {
        var temporaryArray: Array<Char> = emptyArray()
        for (x in a) {
            temporaryArray += x
        }

        return temporaryArray.groupingBy { it }.eachCount()
    }

    fun <A> isSorted(aa: List<A>, order: (A, A) -> Boolean): Boolean {
        var isSorted = true
        val pairs = aa.windowed(2, 1)
        for (x in pairs) {
            if (!order(x[0], x[1])) {
                isSorted = false
                break
            }
        }
        return isSorted
    }

    fun zadanie1() {
        println("-------- ZADANIE 1 --------")

        val copycat: (String, Int) -> String = { s: String, i: Int -> s.repeat(i) }
        println(copycat("a", 3))
    }

    fun zadanie2() {
        println("\n-------- ZADANIE 2 --------")

        val f: (String) -> String = { it + "!" }
        println(f("tekst"))
    }

    fun zadanie3() {
        println("\n-------- ZADANIE 3 --------")

        println(fib(4))
    }

    fun zadanie4() {
        println("\n-------- ZADANIE 4 --------")

        println(log2(2))
    }

    fun zadanie5() {
        println("\n-------- ZADANIE 5 --------")

        println(formatResult("fib", 4, ::fib))
        println(formatResult("log2", 4, ::log2))
    }

    fun zadanie6() {
        println("\n-------- ZADANIE 6 --------")

        println(listOf(1, 2, 3, 4).tail)
        println(listOf(1, 2, 3, 4).head)

        println()
    }

    fun zadanie7() {
        println("\n-------- ZADANIE 7 --------")

        println(isSorted(listOf(1, 2, 3, 4), {i: Int, j: Int -> i < j}))
        println(isSorted(listOf(1, 1, 1, 1), {i: Int, j: Int -> i==j}))
        println(isSorted(listOf("ahyyhh", "bkjn", "cnn", "duu"), {i: String, j: String -> i.first() < j.first()}))
    }

    fun zadanie8() {
        println("\n-------- ZADANIE 8 --------")

        println(suma(arrayOf(1, -4, 12, 0, -3, 29, -150)))
    }

    fun zadanie9() {
        println("\n-------- ZADANIE 9 --------")

        println(countElements(arrayOf(arrayOf('a', 'b', 'c'), arrayOf('c', 'd', 'f'), arrayOf('d', 'f', 'g'))))
    }

    zadanie1()
    zadanie2()
    zadanie3()
    zadanie4()
    zadanie5()
    zadanie6()
    zadanie7()
    zadanie8()
    zadanie9()
}