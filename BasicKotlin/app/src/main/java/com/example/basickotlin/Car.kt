package com.example.basickotlin

import java.lang.IllegalArgumentException

fun main() {
    val car = Car()
    println(car.myBrand)
    car.maxSpeed = 2
}

class Car {
    // this needs to be set later, perhaps in init
    lateinit var owner : String

    /* default getters are created for all class members
     * default setters are created for any members initialized with var
     * custom getters and setters can be created as shown below
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