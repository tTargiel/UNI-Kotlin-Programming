import java.io.File

/**
 * Lista 3 z WpumKJ
 *
 * @author Tomasz Targiel
 */
fun main() {
//    println(System.getProperty("user.dir")) // Wyświetl cwd (current working directory)

    val dictionary = File("./src/main/kotlin/slowa.txt") // W zmiennej dictionary przechowuj zawartość pliku ze słownikiem

    println("Ładuję słowa ze słownika...")

    val words = dictionary.readLines() // Czytaj linię po linii załadowanego pliku

    println(words.size.toString() + " słów załadowano.")
    println("START GRY")

    val random = (0..words.size).random() // Ze wszystkich linijek wylosuj jedną
    val randomWord = words[random] // Do zmiennej randomWord przypisz słowo z wcześniej wylosowanej linijki

    println("Wylosowano słowo o długości " + randomWord.length)
    println(randomWord)

    // Poniżej lista typu String poszczególnych etapów wisielca
    val gallows = listOf(
        "  +---+\n" +
                "      |\n" +
                "      |\n" +
                "      |\n" +
                "     ===",
        "  +---+\n" +
                "  O   |\n" +
                "      |\n" +
                "      |\n" +
                "     ===",
        "  +---+\n" +
                "  O   |\n" +
                "  |   |\n" +
                "      |\n" +
                "     ===",
        "  +---+\n" +
                "  O   |\n" +
                " /|   |\n" +
                "      |\n" +
                "     ===",
        "  +---+\n" +
                "  O   |\n" +
                " /|\\  |\n" +
                "      |\n" +
                "     ===",
        "  +---+\n" +
                "  O   |\n" +
                " /|\\  |\n" +
                " /    |\n" +
                "     ===",
        "  +---+\n" +
                "  O   |\n" +
                " /|\\  |\n" +
                " / \\  |\n" +
                "     ==="
    )
    val guessed = mutableListOf<String>() // Zmienna guessed będzie przechowywała listę wpisywanych liter
    var errors = 0 // Zmienna odpowiadająca za ilość popełnionych błędów
    var run = true // Zmienna logiczna dzięki której gra trwa lub nie

    while (run) {
        var count = 0 // Zmienna zliczająca dobrze odgadnięte litery

        println("\n" + gallows[errors] + "\n") // W zależności od ilości błędów wyświetl odpowiedni etap wisielca
        print("HASŁO: ")

        for (i in randomWord.indices) { // Dla każdej litery wylosowanego słowa (iteracja po indeksach)
            val predicateGuessed: (String) -> Boolean = { it == randomWord[i].toString() } // Zasada odpowiadająca za sprawdzanie równości między wpisanymi literami a tymi w wylosowanym słowie

            if (guessed.any(predicateGuessed) && guessed.isNotEmpty()) { // Jeżeli wpisana litera równa literze o indeksie i oraz lista guessed nie jest pusta
                print(" " + randomWord[i].uppercase()) // Wyświetl odgadniętą literę
            }
            else {
                print(" -") // Wyświetl myślnik
            }
        }

        println("\nŻYCIA " + (7 - errors)) // Wyświetl ilość żyć
        println("WYKORZYSTANE LITERY: $guessed") // Wyświetl listę wpisanych liter
        print("PODAJ LITERĘ: ")

        var letter = readln()[0] // Czytaj pierwszy znak z wprowadzonych danych
        val predicateSame: (String) -> Boolean = { it == letter.lowercase() } // Zasada sprawdzająca czy wcześniej wpisano już taką literę
        val predicateCorrect: (Char) -> Boolean = { it == letter.lowercase().single() } // Zasada sprawdzająca czy litery są poprawnie odgadnięte

        if (guessed.isEmpty()) { // Jeżeli lista guessed jest pusta
            guessed += letter.lowercase() // Dopisz do niej wpisaną literę
        }
        else {
            while (guessed.any(predicateSame)) { // Sprawdź czy wcześniej wpisano już taką literę - i rób to tyle razy, aby użytkownik wpisał nową literę
                print("PODAJ LITERĘ NIE WYBRANĄ POPRZEDNIO: ")
                letter = readln()[0]
            }
            guessed += letter.lowercase()
        }

        if (!(randomWord.any(predicateCorrect))) { // Jeżeli wpisana litera nie występuje w wylosowanym słowie
            errors += 1 // Zwiększ zmienną errors (ilości popełnionych błędów) o jeden
        }

        for (element in randomWord) { // Dla każdej litery w wylosowanym słowie
            val predicateGuessed: (String) -> Boolean = { it == element.toString() } // Zasada odpowiadająca za sprawdzanie równości między wpisanymi literami a tymi w wylosowanym słowie

            if (guessed.any(predicateGuessed) && guessed.isNotEmpty()) { // Jeżeli wpisana litera równa literze o indeksie i oraz lista guessed nie jest pusta
                count += 1 // Do zmiennej count (poprawnie odgadniętych znaków) dodaj 1
            }
        }

        if (errors >= 7 || count == randomWord.length) { // Jeżeli popełniono 7 błędów lub odgadnięto wszystkie znaki
            run = false // Zakończ grę poprzez wyjście z pętli while
        }
    }

    // W zależności od ilości błędów, wyświetl komunikat o wygranej lub przegranej
    if (errors < 7) {
        println("\nWYGRAŁEŚ/AŚ")
        println("ODPOWIEDŹ: $randomWord")
    }
    else {
        println("\nPRZEGRAŁĘŚ/AŚ")
        println("ODPOWIEDŹ: $randomWord")
    }
}