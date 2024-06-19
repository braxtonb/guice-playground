package org.example.models

data class Batter(
    val name: String
) : Athlete(name) {
    override fun score() {
        println("[${this.javaClass.name}] My name is $name and I just hit a home run!")
    }
}
