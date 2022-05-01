package com.example.basickotlin

import java.lang.IllegalArgumentException

fun main() {
    val car = Cars()
    println(car.myBrand)
    car.maxSpeed = 2

    val user = User(1, "Dakota")
    val name = user.name
    print(user.component1()) // 1
    print(user.component2()) // "Dakota"

    val (myId, myName) = user // deconstruction
}

private class Cars {
    // this needs to be set later, perhaps in init
    lateinit var owner : String

    /* default getters are created for all class members
     * default setters are created for any members initialized with var
     * custom getters and setters can be created as shown below
     * field is used to represent the member in getters
     * value is used in setters as parameter
     */

    // custom getter
    val myBrand : String = "BMW"
        get() {
            return field.lowercase()
        }

    var maxSpeed = 250
        set(value) {
            field = if (value > 0) value else throw IllegalArgumentException("Maxspeed must be positive")
        }

    var myModel = "M5"
        private set // member can only be set within the class
}

// must have at least 1 parameter
// compiler automatically creates an equals and toString method
data class User(val id: Long, val name: String)