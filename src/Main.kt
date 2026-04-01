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
    println("Rules ")
    println("")
    println("### Game Setup\n" +

            "- A row of 16 squares, numbered 1 to 16 from left to right\n" +
            "- 5 counters (total) are placed randomly on the board - 4 white and 1 black\n" +
            "- Decide who goes first\n" +
            "\n" +
            "### Gameplay\n" +
            "- Players take turns - You may not skip your turn\n" +
            "- On your turn you must do exactly one of the following:\n" +
            "    - Slide any counter (black or white) any number of squares to the left, as long as no other counter is in the way and the destination square is empty, or...\n" +
            "    - Remove the counter on square 1 (only if a counter is there)\n" +
            "\n" +
            "### Win Condition\n" +
            "- The player who removes the black counter from square 1 wins\n" +
            "\n" +
            "### Variant\n" +
            "- Counters can slide either left or right (but still can't jump other counters)\n")
    println("────────────────────────────────────────────────────────────────────────────────────────────────────")
    createSquares()
    createSquares()
    showSquares()
    slideCounter()


    while (t+rue) {
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
    for (i in 1..8)
        squares.add("---")

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

