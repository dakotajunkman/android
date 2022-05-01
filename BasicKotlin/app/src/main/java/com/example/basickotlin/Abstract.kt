package com.example.basickotlin

// cannot be instantiated
// members and methods are not abstract unless marked as such
abstract class Mammal(private val name: String,
                      private val origin: String,
                      private val weight: Double) {

    // must be overridden
    abstract var maxSpeed: Double

    abstract fun run()
    abstract fun breath()

    fun displayDetails() {
        println("Name: $name, Origin: $origin, Weight: $weight")
    }
}

class Human(name: String, origin: String, weight: Double, override var maxSpeed: Double) :
    Mammal(name, origin, weight) {
    override fun run() {
        return
    }

    override fun breath() {
        return
    }
        }