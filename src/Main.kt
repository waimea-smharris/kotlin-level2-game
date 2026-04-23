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
    println("Pinned \uD83D\uDCCC")
    println("")
    println("Rules")
    println("____________________________________________________________")
    println("")
    println(
        "### Game Setup\n" +
                "- A row of 16 squares, numbered 1 to 16 from left to right\n" +
                "- 5 counters are placed on the board - 4 white and 1 black\n" +
                "- Decide who goes first\n" +
                "\n" +
                "### Gameplay\n" +
                "- Players take turns\n" +
                "- You may not skip your turn\n" +
                "- On your turn you must do ONE of the following:\n" +
                "- Slide any counter any number of squares to the left, as long as no other counter is in the way and the destination square is empty, or...\n" +
                "- Remove the counter on square 1 (only if a counter is there)\n" +
                "\n" +
                "### Win Condition\n" +
                "- The player who removes the black counter from square 1 wins\n" +
                "\n" +
                "### Variant\n" +
                "- Counters can slide either left or right (but still can't jump other counters)\n"
    )
    println("____________________________________________________________")
    createSquares()
    createCounters()
    showSquares()
    while (true) {
        showSquares()
        val action = getUserAction()
        if (action == 1) {
            removeCounter()
        } else if (action == 2) {
            slideCounter()
        }
    }
}
fun createSquares() {
    squares.clear()
    for (i in 1..16) {
        squares.add(" ")
    }
}
fun createCounters() {
    val randomPositions = (0..15).shuffled().take(5)
    // First one is black
    squares[randomPositions[0]] = "[B]"
    // Other 4 are white
    for (i in 1 until randomPositions.size) {
        squares[randomPositions[i]] = "[W]"
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

fun getUserAction(): Int {
    println("Choose an action:")
    println("1. Remove counter from square 1")
    println("2. Slide a counter")
    print("Enter choice: ")
    return readLine()?.toIntOrNull() ?: 0
}
fun removeCounter() {
    if (squares[0] == "") {
        println("There is no counter on square 1")
        return
    }
    if (squares[0] == "[B]") {
        println("There is no counter on square 1")
        println("You win!")
        kotlin.system.exitProcess(0)
        return
    }else {
        println("White counter removed from square 1")
        squares[0] = " "
    }



}

fun slideCounter() {
    print("Enter counter position to move (1-16): ")
    val from = (readLine() ?.toIntOrNull() ?: return) - 1
    print("Enter new position (must move left): ")
    val to = (readLine()?.toIntOrNull() ?: return) - 1
    if (from !in 0..15  || to !in 0..15) {
        println("Invalid position")
        return
    }
    if (squares[from] == "") {
        println("No counter there")
        return
    }
    if (to > from) {
        println("Must move left only")
        return
    }
    if (squares[to] == " ") {
        println("Cannot jump over another counter")
        return
    }
    for (i in (to + 1) until from) {
        if (squares[i] == "  ") {
            println("Cannot jump over another counter")
            return
        }
}


}
//fun getUserAction(): Char {
//    println("[A] Add Counter")
//    println("[S] Slide Counter")
//    println("[Q] Quit")
//    print("Choice: ")
//
//    val input = readlnOrNull()?.firstOrNull()?.uppercaseChar()
//    if (input == null) {
//        return 'Q'
//    }
//
//    return input
//}
//
//fun getSquareNumber(): Int {
//    print("Enter cell number (1-16): ")
//    val num = readlnOrNull()?.toIntOrNull()
//    if (num == null) {
//        println("Invalid number")
//        return -1
//
//    }
//    return num - 1
//
//}
//
//fun addCounter() {
//    print("Enter counter: ")
//    var name = readln()
//    if (name.length > 8) {
//        name = name.substring(0, 8)
//
//    }
//
//    for (i in 0..15) {
//        if (squares[i] == "---") {
//            squares[i] = name
//            println("Counter added")
//            return
//
//        }
//
//    }
//
//    println("No empty squares")
//
//}
//
//
//fun slideCounter() {
//    println("First Square:")
//    val c1 = getSquareNumber()
//    println("Second Square:")
//    val c2 = getSquareNumber()
//    if (c1 >= 0 && c2 >= 0 && c1 < 8 && c2 < 8) {
//        val temp = squares[c1]
//        squares[c1] = squares[c2]
//        squares[c2] = temp
//        println("Counters switched")
//
//    }
//
//}
//
//
//
//












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

