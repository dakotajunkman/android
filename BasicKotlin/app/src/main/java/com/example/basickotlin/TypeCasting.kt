package com.example.basickotlin

import kotlin.math.floor

fun main() {
    val stringList = listOf("Denis", "Frank", "Michael", "Garry")
    val mixedList: List<Any> = listOf("Denis", 31, 5, "BDay", 70.5)

    for (value in mixedList) {
        when (value) {
            is Int -> println("Integer: $value")
            is Double -> println("Double $value with floor ${floor(value)}")
            is String -> println("String $value of length ${value.length}")
            else -> println("random type")
        }
    }
}