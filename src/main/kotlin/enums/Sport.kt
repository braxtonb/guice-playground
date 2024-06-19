package org.example.enums

enum class Sport {
    BASEBALL,
    BASKETBALL,
    FOOTBALL;

    companion object {
        fun fromString(value: String): Sport = when (value) {
            "BASEBALL" -> BASEBALL
            "BASKETBALL" -> BASKETBALL
            "FOOTBALL" -> FOOTBALL
            else -> throw IllegalArgumentException("Unknown sport $value provided")
        }
    }
}
