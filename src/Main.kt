/**
 * =====================================================================
 * Programming Project for NCEA Level 2, Standard 91896
 * ---------------------------------------------------------------------
 * Project Name:   PROJECT NAME HERE
 * Project Author: PROJECT AUTHOR HERE
 * GitHub Repo:    GITHUB REPO URL HERE
 * ---------------------------------------------------------------------
 * Notes:
 * PROJECT NOTES HERE
 * =====================================================================
 */



val squares = mutableListOf<String>()

fun main() {

    println(" Pinned \uD83D\uDCCC")
    println("────────────────────────────────────────────────────────────────────────────────────────────────────")
    createSquares()
    createSquares()
    showSquares()
    slideCounter()


    while (true) {
        showSquares()
        val action = getUserAction()
        if (action == 'A') {
            addCounter()
        } else if (action == 'S') {
            slideCounter()
        } else if (action == 'Q') {
            println("---")
            break
        }

    }

}



fun createSquares() {
    for (i in 1..8) {
        squares.add("---")

    }
}

fun showSquares() {
    println("   1     2     3     4     5     6     7     8     9     10    11    12    13    14    15    16")
    print("╭─────")
    print("┬─────".repeat(n = squares.size - 1))
    println("╮")

    for (cell in squares) {
        print("│ ${cell.padEnd(length = 3)} ")
    }
    println("│")

    print("╰─────")
    print("┴─────".repeat(n = squares.size - 1))
    print("╯")
    for (c in squares) {

    }
    println()
}

fun getUserAction(): Char {
    println("[A] Add Counter")
    println("[S] Slide Counter")
    println("[Q] Quit")
    print("Choice: ")

    val input = readlnOrNull()?.firstOrNull()?.uppercaseChar()
    if (input == null) {
        return 'Q'
    }

    return input
}

fun getSquareNumber(): Int {
    print("Enter cell number (1-16): ")
    val num = readlnOrNull()?.toIntOrNull()
    if (num == null) {
        println("Invalid number")
        return -1

    }
    return num - 1

}

fun addCounter() {
    print("Enter counter: ")
    var name = readln()
    if (name.length > 8) {
        name = name.substring(0, 8)

    }

    for (i in 0..15) {
        if (squares[i] == "---") {
            squares[i] = name
            println("Counter added")
            return

        }

    }

    println("No empty squares")

}


fun slideCounter() {
    println("First Square:")
    val c1 = getSquareNumber()
    println("Second Square:")
    val c2 = getSquareNumber()
    if (c1 >= 0 && c2 >= 0 && c1 < 8 && c2 < 8) {
        val temp = squares[c1]
        squares[c1] = squares[c2]
        squares[c2] = temp
        println("Counters switched")

    }

}
















//fun getSquareNumber() {
//
//}
//
//fun slideCounter() {
//
//}
//
//fun addCounter() {
//
//}

