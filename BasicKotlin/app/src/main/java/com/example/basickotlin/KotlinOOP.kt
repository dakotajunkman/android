package com.example.basickotlin

fun main() {
    val person = Person("Dakota", "Junkman", 21)
    person.hobby = "code everyday"
    person.stateHobby()
}

// when the constructor has no annotations or visibility (public, private)
// the constructor keyword can be omitted
class Person (val firstName: String, val lastName: String) {
    // Member variables - Properties
    var age: Int? = null
    var hobby: String = "watch Netflix"

    // code that runs when the object is created
    init {
        println("Person created $firstName $lastName")
    }

    // secondary constructor
    constructor(firstName: String, lastName: String, age: Int):
            this(firstName, lastName){
                this.age = age
            }

    // Member functions - Methods
    fun stateHobby() {
        println("$firstName hobby is $hobby")
    }
}