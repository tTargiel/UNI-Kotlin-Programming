/**
 * Lista 1 z WpumKJ
 *
 * @author Tomasz Targiel
 */
fun main() {
    fun isDividableBy3(number: Int): Boolean {
        return number % 3 == 0
    }

    fun isDividableBy5(number: Int): Boolean {
        return number % 5 == 0
    }

    fun isDividableBy7(number: Int): Boolean {
        return number % 7 == 0
    }

    fun isDividableBy11(number: Int): Boolean {
        return number % 11 == 0
    }

    fun isDividableBy13(number: Int): Boolean {
        return number % 13 == 0
    }

    fun zadanie1() {
        println("-------- ZADANIE 1 --------")

        for (i in 1..100) {
            var result = ""
            if (isDividableBy3(i)) result += "trzy"
            if (isDividableBy5(i)) result += "pięć"
            if (result == "") println(i) else println(result)
        }
    }

    fun zadanie2() {
        println("\n-------- ZADANIE 2 --------")

        for (i in 1..100) {
            var result = ""
            if (isDividableBy3(i)) result += "trzy"
            if (isDividableBy5(i)) result += "pięć"
            if (isDividableBy7(i)) result += "siedem"
            if (result == "") println(i) else println(result)
        }
    }

    fun zadanie3() {
        println("\n-------- ZADANIE 3 --------")

        for (i in 1..100) {
            var result = ""
            if (isDividableBy3(i)) result += "trzy"
            if (isDividableBy5(i)) result += "pięć"
            if (isDividableBy7(i)) result += "siedem"
            if (isDividableBy11(i)) result += "jedenaście"
            if (isDividableBy13(i)) result += "trzynaście"
            if (result == "") println(i) else println(result)
        }
    }

    fun zadanie4() {
        fun missingNumber(tab: IntArray): Int {
            var sumOfTabElements = 0
            var desiredSumOfTabElements = 0
            val result: Int
            var check = false

            for (i in tab) {
                sumOfTabElements += i
            }

            for (j in tab.indices) {
                desiredSumOfTabElements += j + 1
                if (tab[j] == 0) {
                    check = true
                }
            }

            result = if (desiredSumOfTabElements - sumOfTabElements == 0) {
                if (check) {
                    tab.size
                } else {
                    0
                }
            } else {
                desiredSumOfTabElements - sumOfTabElements
            }

            return result
        }

        val tab1: IntArray = intArrayOf(4, 2, 1, 3) // Brakująca liczba to 0
        val tab2: IntArray = intArrayOf(5, 3, 0, 1, 4) // Brakująca liczba to 2
        val tab3: IntArray = intArrayOf(4, 2, 1, 3, 0) // Brakująca liczba to 5
        val tab4: IntArray = intArrayOf(2, 1, 6, 4, 5, 3, 0) // Brakująca liczba to 7

        println("\n-------- ZADANIE 4 --------")
        println("Brakująca liczba w tablicy 1: " + missingNumber(tab1))
        println("Brakująca liczba w tablicy 2: " + missingNumber(tab2))
        println("Brakująca liczba w tablicy 3: " + missingNumber(tab3))
        println("Brakująca liczba w tablicy 4: " + missingNumber(tab4))
    }

    zadanie1()
    zadanie2()
    zadanie3()
    zadanie4()
}