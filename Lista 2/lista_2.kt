/**
 * Lista 2 z WpumKJ
 *
 * @author Tomasz Targiel
 */
fun main() {
    fun convertToRoman(n: Int): String {
        val baseValues = listOf(1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000)
        val romanNumerals = listOf("I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M")
        var answer = ""
        var currentIndex = baseValues.size - 1 // Ostatnia pozycja listy - będę iterował od tyłu
        var currentNumber = n

        while (currentNumber > 0) {
            var quotient = currentNumber / baseValues[currentIndex] // Ile razy zmieści się liczba z aktualnej pozycji w aktualnej liczbie

            currentNumber %= baseValues[currentIndex] // Reszta z dzielenia aktualnej liczby przez liczbe na aktualnej pozycji

            while (quotient > 0) {
                answer += romanNumerals[currentIndex] // Tyle razy ile trzeba dodaje liczbe rzymską do odpowiedzi
                quotient--
            }

            currentIndex--
        }

        return answer
    }

    fun convertFromRoman(s: String): Int {
        val values = mapOf("I" to 1, "V" to 5, "X" to 10, "L" to 50, "C" to 100, "D" to 500, "M" to 1000)
        var answer = 0
        var currentIndex = s.length - 1 // Ostatnia pozycja kolekcji - będę iterował od tyłu
        var nonExisting = false
        var previousValue = 0

        for (x in 0 .. s.length - 4) {
            nonExisting = s.length >= 4 && s[x].toString() == s[x+1].toString() && s[x+1].toString() == s[x+2].toString() && s[x+2].toString() == s[x+3].toString()
        }

        if (nonExisting) {
            println("Taka liczba w rzymskim systemie liczbowym nie ma prawa istnieć (nigdy nie mogą po sobie występować więcej niż 3x te same znaki)")
        }
        else {
            while (currentIndex > -1) {
                val currentValue = values[s[currentIndex].toString()]!! // Zapisuje wartość odpowiadającą znakowi na aktualnej pozycji iterując od tyłu

                if (currentValue >= previousValue) { // Jeżeli aktualna wartość jest większa lub równa poprzedniej
                    answer += currentValue // Dodaj ją do odpowiedzi
                }
                else { // Jeżeli mniejsza
                    answer -= currentValue // Odejmij ją od odpowiedzi
                }

                previousValue = currentValue
                currentIndex--
            }
        }

        return answer
    }

    fun isCyclic(i: String): Boolean {
        // Wypisuję na ekranie sprawdzaną liczbę
        println("Czy liczba $i jest cykliczna? ")

        // Liczę ilość cyfr oraz sprawdzam czy są one takie same
        val firstChar = i[0].digitToInt()
        var areEqual = true
        var count = 1

        for (x in 1 until i.length) {
            count++

            if (i[x].digitToInt() != firstChar) {
                areEqual = false
            }
        }

        // Jeżeli wszystkie cyfry są takie same, to liczba nie jest cykliczna
        if (areEqual) {
            return false
        }

        // Jeżeli ilość cyfr jest parzysta oraz dwie połówki liczby są takie same, to liczba nie jest cykliczna
        if (count % 2 == 0) {
            var firstHalf = ""
            var secondHalf = ""

            for (j in 0 until count / 2) {
                firstHalf += i[j]
                secondHalf += i[count / 2 + j]
            }

            if (firstHalf == secondHalf && isCyclic(firstHalf)) {
                return false
            }
        }

        var currentNumber = i.toLong()

        while (true) {
            // Dokonuję permutacji kołowej
            val divisor = currentNumber / 10
            val remainder = currentNumber % 10

            currentNumber = (Math.pow(10.0, (count - 1).toDouble()).toLong() * remainder + divisor)

            // Jeżeli wszystkie permutacje zostały sprawdzone i otrzymana liczba jest taka sama jak pierwotna, to przerwij pętlę
            if (currentNumber == i.toLong()) {
                break
            }

            if (currentNumber % i.toLong() != 0L) {
                return false
            }
        }

        return true
    }

    fun zadanie1() {
        println("-------- ZADANIE 1 --------")

//        print("Wpisz liczbę arabską do konwersji na liczbę rzymską: ")
//
//        val n = Integer.valueOf(readLine())

        val n = 1337

        println(convertToRoman(n))
    }

    fun zadanie2() {
        println("\n-------- ZADANIE 2 --------")

//        print("Wpisz liczbę rzymską do konwersji na liczbę arabską: ")
//
//        val s = readln()

        val s = "MCCCXXXVII"

        println(convertFromRoman(s))
    }

    fun zadanie3() {
        println("\n-------- ZADANIE 3 --------")

//        print("Wpisz dowolną liczbę, aby sprawdzić czy jest ona cykliczna: ")
//
//        val testNumber = readln()

        val testNumber = "142857"

        if (isCyclic(testNumber)) {
            print("Tak")
        }
        else {
            print("Nie")
        }
    }

    zadanie1()
    zadanie2()
    zadanie3()
}