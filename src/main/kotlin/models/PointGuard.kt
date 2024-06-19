package org.example.models

data class PointGuard(
    val name: String
) : Athlete(name) {
    override fun score() {
        println("[${this.javaClass.name}] My name is $name and I just scored a 3 pointer!")
    }
}
