/**
 * Lista 6 z WpumKJ
 *
 * @author Tomasz Targiel
 */
class SudokuSolve{
    fun inRow(grid: Array<Array<Int?>>, number: Int, row: Int): Boolean {
        for (i in 0 until 9) {
            if (grid[row][i] == number) {
                return true
            }
        }

        return false
    }

    fun inColumn(grid: Array<Array<Int?>>, number: Int, column: Int): Boolean {
        for (i in 0 until 9) {
            if (grid[i][column] == number) {
                return true
            }
        }

        return false
    }

    fun inBox(grid: Array<Array<Int?>>, number: Int, column: Int, row: Int): Boolean {
        val boxRow = row - row % 3
        val boxColumn = column - column % 3

        for (i in boxRow until boxRow + 3) {
            for (j in boxColumn until boxColumn + 3) {
                if (grid[i][j] == number) {
                    return true
                }
            }
        }

        return false
    }

    fun validPlace(grid: Array<Array<Int?>>, number: Int, column: Int, row: Int): Boolean {
        return !inRow(grid, number, row) && !inColumn(grid, number, column) && !inBox(grid, number, column, row)
    }

    fun solve(grid: Array<Array<Int?>>): Boolean {
        for (i in 0 until 9) {
            for (j in 0 until 9) {
                if (grid[i][j] == -1) {
                    for (k in 1..9) {
                        if (validPlace(grid, k, j, i)) {
                            grid[i][j] = k

                            if (solve(grid)) {
                                return true
                            }
                            else {
                                grid[i][j] = -1
                            }
                        }
                    }

                    return false
                }
            }
        }

        return true
    }

    fun print(grid: Array<Array<Int?>>) {
        for (i in 0 until 9) {
            if (i % 3 == 0 && i != 0) {
                println("------|-------|------")
            }

            for (j in 0 until 9) {
                if (j % 3 == 0 && j != 0) {
                    print("|")
                    print(" ")
                }

                if (grid[i][j] == -1) {
                    print("*")
                }
                else {
                    print(grid[i][j])
                }
                print(" ")
            }

            println()
        }
    }
}

fun main() {
//    print("Podaj pierwszy wiersz (w puste miejsca wpisz -1, wartości oddzielaj przecinkami): ")
//    val firstRow = readln()
    val firstRow = "9, -1, -1, 1, 7, 5, -1, -1, -1"
    val firstRowList = firstRow.split(",").map { it.trim() }

//    print("Podaj drugi wiersz: ")
//    val secondRow = readln()
    val secondRow = "1, -1, -1, 3, -1, 9, -1, -1, -1"
    val secondRowList = secondRow.split(",").map { it.trim() }

//    print("Podaj trzeci wiersz: ")
//    val thirdRow = readln()
    val thirdRow = "5, 7, 3, -1, -1, 8, -1, -1, -1"
    val thirdRowList = thirdRow.split(",").map { it.trim() }

//    print("Podaj czwarty wiersz: ")
//    val fourthRow = readln()
    val fourthRow = "-1, 9, -1, -1, 5, 1, 3, 7, -1"
    val fourthRowList = fourthRow.split(",").map { it.trim() }

//    print("Podaj piąty wiersz: ")
//    val fifthRow = readln()
    val fifthRow = "-1, 1, -1, -1, 3, 6, 4, -1, 9"
    val fifthRowList = fifthRow.split(",").map { it.trim() }

//    print("Podaj szósty wiersz: ")
//    val sixthRow = readln()
    val sixthRow = "-1, -1, -1, -1, -1, -1, 5, -1, 1"
    val sixthRowList = sixthRow.split(",").map { it.trim() }

//    print("Podaj siódmy wiersz: ")
//    val seventhRow = readln()
    val seventhRow = "-1, -1, -1, 6, 2, -1, -1, 8, -1"
    val seventhRowList = seventhRow.split(",").map { it.trim() }

//    print("Podaj ósmy wiersz: ")
//    val eighthRow = readln()
    val eighthRow = "-1, -1, 7, -1, 9, -1, -1, -1, -1"
    val eighthRowList = eighthRow.split(",").map { it.trim() }

//    print("Podaj dziewiąty wiersz: ")
//    val ninthRow = readln()
    val ninthRow = "-1, -1, -1, -1, -1, 3, -1, 5, -1"
    val ninthRowList = ninthRow.split(",").map { it.trim() }

    val first = arrayOfNulls<Int>(9)
    val second = arrayOfNulls<Int>(9)
    val third = arrayOfNulls<Int>(9)
    val fourth = arrayOfNulls<Int>(9)
    val fifth = arrayOfNulls<Int>(9)
    val sixth = arrayOfNulls<Int>(9)
    val seventh = arrayOfNulls<Int>(9)
    val eighth = arrayOfNulls<Int>(9)
    val ninth = arrayOfNulls<Int>(9)

    for (i in 0 until 9) {
        first[i] = firstRowList[i].toInt()
        second[i] = secondRowList[i].toInt()
        third[i] = thirdRowList[i].toInt()
        fourth[i] = fourthRowList[i].toInt()
        fifth[i] = fifthRowList[i].toInt()
        sixth[i] = sixthRowList[i].toInt()
        seventh[i] = seventhRowList[i].toInt()
        eighth[i] = eighthRowList[i].toInt()
        ninth[i] = ninthRowList[i].toInt()
    }

    val grid: Array<Array<Int?>> = arrayOf(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth)

    val game = SudokuSolve()
    println("Wpisane przez Ciebie Sudoku:")
    game.print(grid)

    if (game.solve(grid)) {
        println("\nRozwiązanie Sudoku:")
        game.print(grid)
    }
    else {
        println("\nWpisane Sudoku nie posiada rozwiązań!")
    }
}
