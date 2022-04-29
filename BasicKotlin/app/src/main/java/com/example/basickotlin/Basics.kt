package com.example.basickotlin

fun main() {
    // mutable variable var
    var myName = "Dakota"
    myName = "Fred"

    // immutable variable val
    val immutName = "Dakota"

    // print does not add new line
    print(immutName)

    // println does add a new line
    println("Hello $myName")

    /* Above output: DakotaHello Fred */

    // Char must have single quotes
    val char = 'a'

    var string = "Hello World"
    var first = string.first()
    var last = string.last()

    println("First char: $first")
    println("Last char: $last")


    var season = 3

    when (season) {
        1 -> println("spring")
        2 -> println("summer")
        3 -> {
            println("fall")
            println("autumn")
        }
        4 -> println("winter")
        else -> println("lolwut")
    }

    var month = 3

    when (month) {
        in 3..5 -> println("spring")
        in 6..8 -> println("summer")
        in 9..11 -> println("fall")
        12, 1, 2 -> println("winter")
        else -> println("lolwut")
    }

    for (num in 10 downTo 1) {
        print(num)
    }

    fun add(a: Int, b: Int): Int {
        return a + b
    }

    println(add(4, 6))
}