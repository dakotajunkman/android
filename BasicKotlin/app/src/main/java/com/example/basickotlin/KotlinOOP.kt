package com.example.basickotlin

fun main() {
    val person = Person("Dakota", "Junkman")
}

// when the constructor has no annotations or visibility (public, private)
// the constructor keyword can be omitted
class Person (firstName: String, lastName: String) {
    // code that runs when the object is created
    init {
        println("Person created $firstName $lastName")
    }
}