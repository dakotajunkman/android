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
}