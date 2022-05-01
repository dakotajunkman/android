package com.example.basickotlin

interface Drivable {
    val maxSpeed: Double
    fun drive(): String
    fun brake() {
        println("The drivable is braking")
    }
}

open class Car(override val maxSpeed: Double, val name: String, val brand: String) : Drivable {
    override fun drive() = "Driving the interface"
}

