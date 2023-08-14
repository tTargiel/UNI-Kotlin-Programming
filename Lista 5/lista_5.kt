import java.util.*

/**
 * Lista 5 z WpumKJ
 *
 * @author Tomasz Targiel
 */
fun main() {
    fun secondPower(a: List<Number>): List<Number> {
        val secondPowerList = emptyList<Number>().toMutableList()

        for (x in a.indices) {
            val numberAt = a[x].toDouble()

            if ((x % 2 == 1) and (numberAt >= 0)) {
                secondPowerList += numberAt*numberAt
            }
        }

        return secondPowerList
    }

    fun firstLetterSort(a: List<String>): SortedMap<Char, List<String>> {
        return a.filter { it.length % 2 == 0 }.groupBy { it.first() }.toSortedMap()
    }

    fun permutations(vararg numbers: Int): List<List<Int>> {
        val argsList: MutableList<Int> = numbers.toList().toMutableList()
        val permList: MutableList<List<Int>> = mutableListOf()

        fun generate(k: Int, list: List<Int>) {
            if (k == 1) {
                permList.add(list.toList())
            }
            else {
                for (i in 0 until k) {
                    generate(k - 1, list)

                    if (k % 2 == 0) {
                        Collections.swap(list, i, k - 1)
                    }
                    else {
                        Collections.swap(list, 0, k - 1)
                    }
                }
            }
        }

        generate(argsList.count(), argsList.toList())

        return permList
    }

    fun check(N: Int, list: List<Int>): Int {
        val falseCondition = 0
        val snapshots = list.windowed(N, 1)

        for (i in 0 until snapshots.size - 1) {
            val checkList: MutableList<Boolean> = mutableListOf()

            for (j in 0 until snapshots[i].size - 1) {
                for (k in (j + 1) until snapshots[i].size) {
                    checkList.add(snapshots[i][j] + snapshots[i][k] == snapshots[i + 1][N - 1])
                }
            }

            if (checkList.firstOrNull { it } == null) {
                return snapshots[i + 1][N - 1]
            }
        }

        return falseCondition
    }

    fun zadanie1() {
        println("-------- ZADANIE 1 --------")

        println(secondPower(listOf(1, 2, 3.5, 5, -6, 1, 1)))
    }

    fun zadanie2() {
        println("\n-------- ZADANIE 2 --------")

        println(firstLetterSort(listOf("cherry", "blueberry", "citrus", "apple", "apricot", "banana", "coconut")))
    }

    fun zadanie3() {
        println("\n-------- ZADANIE 3 --------")

        println(permutations(1, 2, 3))
    }

    fun zadanie4() {
        println("\n-------- ZADANIE 4 --------")

        println(check(5, listOf(35, 25, 15, 25, 47, 40, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299, 277, 309, 576)))
    }

    zadanie1()
    zadanie2()
    zadanie3()
    zadanie4()
}
