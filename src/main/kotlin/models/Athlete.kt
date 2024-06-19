package org.example.models

abstract class Athlete(private val name: String) {
    abstract fun score()

    fun celebrate() {
        println("[${this.javaClass.name}] My name is $name and we won the championship!")
    }
}
